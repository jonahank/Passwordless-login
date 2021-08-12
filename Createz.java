import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Createz {

    public static String create() throws IOException, InterruptedException{

        Scanner sc = new Scanner(System.in);
        ProcessBuilder processBuilder = new ProcessBuilder();
        System.out.println("             ***********************************************************   ");
        System.out.println("             *****                                                 *****   ");
        System.out.println("             *****     Creating a new key-pair for local device    *****   ");
        System.out.println("             *****   ___________________________________________   *****   ");
        System.out.println("             *****                                                 *****   ");

        // Perform user creation
        // Start GPG's own user-creation
        processBuilder.command("bash", "-c", "gpg --gen-key");
        Process process = processBuilder.start();
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        //Creating output string
        String line = "";
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }
        
        int exitVal = process.waitFor();
        if (exitVal == 0) {
            System.out.println("             *****             User created successfully!          *****   ");
            System.out.println("             *****   -------------------------------------------   *****   ");
            System.out.println("             *****                                                 *****   ");
            
            return null;
        } else {
            System.out.println("             *****  Something went wrong! Contact devs: Createz2   *****   ");
            
            return null;
        }

    }
    
}
