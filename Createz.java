import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Createz {

    public static boolean create() throws IOException, InterruptedException{

        Scanner sc = new Scanner(System.in);
        ProcessBuilder processBuilder = new ProcessBuilder();

        
        System.out.println("   ***********************************************************   ");
        System.out.println("   *****                                                 *****   ");
        System.out.println("   *****     Creating a new key-pair for local device    *****   ");
        System.out.println("   *****   ___________________________________________   *****   ");
        System.out.println("   *****                                                 *****   ");
        
        // Ask for user input
        System.out.println("   *****                Choose an alias:                 *****   ");
        String username = sc.nextLine();
        System.out.println("   *****                 Provide email:                  *****   ");
        String email = sc.nextLine();
        System.out.println("   *****             Provide phone-number:               *****   ");
        System.out.println("   *****        (optional for account recovery)          *****   ");
        System.out.println("   *****             (press Enter to SKIP)               *****   ");
        String phoneNo = sc.nextLine();

        // Perfor user creation
        // processBuilder.command("bash", "-c", encryptedMsg);

        // Start GPG's own user-creation
        processBuilder.command("bash", "-c", "gpg --gen-key");
        Process process = processBuilder.start();
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        //Creating output string
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }
        
        int exitVal = process.waitFor();
        if (exitVal == 0) {
            System.out.println("                     " + output);
            System.out.println("   *****                                                 *****   ");
            System.out.println("   *****   -------------------------------------------   *****   ");
            System.out.println("   *****                    OTP ABOVE                    *****   ");
            
            return true;
        } else {
            System.out.println("This shouldn't happen. Contact devs pls!");
            
            return false;
        }



    }
    
}
