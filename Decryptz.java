import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;

public class Decryptz {

    public static String decrypt() throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        ProcessBuilder processBuilder = new ProcessBuilder();

        
        System.out.println("   ***********************************************************   ");
        System.out.println("   *****                                                 *****   ");
        System.out.println("   *****       Update encrypted_message.txt with OTP     *****   ");
        System.out.println("   *****   ___________________________________________   *****   ");
        System.out.println("   *****                                                 *****   ");
        System.out.println("   *****             (press enter when done)             *****   ");
        String command = "";
        command = sc.nextLine();


        //User check:
        File OTP = new File("encmsg.txt");
        Scanner OTPReader = new Scanner(OTP);
        while (OTPReader.hasNext()) {
            System.out.println(OTPReader.nextLine());
        }
        System.out.println();
        System.out.println("   *****            Is this your message (Y/N)?          *****   ");
        OTPReader.close();
        command = sc.nextLine();

        // If correct, perform GPG commands in Unix Linux commandline and output the OTP to the user.
        if (command.toUpperCase().equals("Y")){
            
            // perform decryption        
            processBuilder.command("bash", "-c", "gpg --decrypt encmsg.txt");
    
            //Boiler plate initialization
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
                System.out.println("   *****               Decryption successful!            *****   ");
                return output.toString();

            } else {
                System.out.println("This shouldn't happen. Contact devs pls!");
                return null;

            }   
        } else {
            // user put wrong message returning to main
            System.out.println("   *****   ___________________________________________   *****   ");
            System.out.println("   *****                                                 *****   ");
            System.out.println("   *****            ... returning to menu ...            *****   ");
            return null;
        }

        }
        


       
}
