import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SetUserz {


    public static String setUser() throws IOException, InterruptedException{
        Scanner sc = new Scanner(System.in);
        ProcessBuilder processBuilder = new ProcessBuilder();

        // Menu intro
        System.out.println("   ***********************************************************   ");
        System.out.println("   *****                                                 *****   ");
        System.out.println("   *****         Setting the current local user          *****   ");
        System.out.println("   *****                                                 *****   ");
        
        
        // Perform user look-up
        while (true) {
            // Ask for user input
            System.out.println("   *****   ___________________________________________   *****   ");
            System.out.println("   *****     Provide an email for an existing user:      *****   ");
            System.out.println("   *****     (press 'Q' to return to the main menu)      *****   ");
            System.out.println("   *****                                                 *****   ");
            System.out.println("   *****                                                 *****   ");
            String email = sc.nextLine();
            if (email.toUpperCase().equals("Q")) return null;
    
            // Start GPG's own user-lookup
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
                // System.out.println(output);
                
                // Check if only one email appears in the search
                String temp = output.toString();
                long countCheck = temp.codePoints().filter(ch -> ch == '@').count();
                // System.out.println(countCheck);
                if (countCheck == 1) {
                    System.out.println("   *****           Local user set successfully!          *****   ");
                    System.out.println("   *****   -------------------------------------------   *****   ");
                    System.out.println("   *****                                                 *****   ");

                    return email;
                }
                if (countCheck > 1) System.out.println("   *****       Email not unique, please try again        *****   ");
            } else {
                System.out.println("   *****   No user with that email, please try again     *****   ");
                return null;
            }
        }
    }
    
}
