import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Createz {

    public static String create() throws IOException, InterruptedException{

        Scanner sc = new Scanner(System.in);
        ProcessBuilder processBuilder = new ProcessBuilder();
        System.out.println("   ***********************************************************   ");
        System.out.println("   *****                                                 *****   ");
        System.out.println("   *****     Creating a new key-pair for local device    *****   ");
        System.out.println("   *****   ___________________________________________   *****   ");
        System.out.println("   *****                                                 *****   ");
        
        // Ask for user input
        System.out.println("   *****                 Provide email:                  *****   ");
        String email = sc.nextLine();
        
        // Check if email already exists:
        processBuilder.command("bash", "-c", "gpg --list-keys " + email);
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
            // output for debugging:
            System.out.println(output);
            
            // Check if email appears in the search and return false if true
            String temp = output.toString();
            long countCheck = temp.codePoints().filter(ch -> ch == '@').count();
            System.out.println("   *****               Email already in use!             *****   ");
            System.out.println("   *****                                                 *****   ");
            System.out.println("   *****             ... returning to menu ...           *****   ");
 
            System.out.println(countCheck);
            if (countCheck >= 1) return null;
        }

        // Perform user creation
        // Start GPG's own user-creation
        System.out.println("   *****       Follow the instructions and make sure     *****   ");
        System.out.println("   *****        to provide the same email as above!      *****   ");
        System.out.println("   *****                                                 *****   ");
        System.out.println("   *****                                                 *****   ");
        processBuilder.command("bash", "-c", "gpg --gen-key");
        process = processBuilder.start();
        output = new StringBuilder();
        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        //Creating output string
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }
        
        exitVal = process.waitFor();
        if (exitVal == 0) {
            System.out.println("   *****             User created successfully!          *****   ");
            System.out.println("   *****   -------------------------------------------   *****   ");
            System.out.println("   *****                                                 *****   ");
            
            return email;
        } else {
            System.out.println("   *****  Something went wrong! Contact devs: Createz2   *****   ");
            
            return null;
        }

    }
    
}
