package Login;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class LoginCom {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner loginSC = new Scanner(System.in);
        ProcessBuilder processBuilder = new ProcessBuilder();
        

        // email, public key
        HashMap<String, String> users = new HashMap<>();

        // Simple "database" to illustrate only email and public key is needed
        // when creating a user.
        users.put("jonkr.alice@itu.dk", "-----BEGIN PGP PUBLIC KEY BLOCK-----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emn2-----END PGP PUBLIC KEY BLOCK-----");
        File bob_pub = new File("bob_pub.key");
        Scanner bobReader = new Scanner(bob_pub);
        String bob_pubkey = "";
        while (bobReader.hasNext()) {
            bob_pubkey += bobReader.next();
        }
        users.put("jonkr.bob@itu.dk", bob_pubkey);
        // Send to user's email if in database:
        System.out.println("Type in username:");
        String userInput = loginSC.nextLine();
        if (users.containsKey(userInput)) {
            // Generate pseudorandom OTP
            String OTP = generate();
            // System.out.println("OTP is: " + OTP);
            String outputForEmail = "test";

            // Encrypt OTP using Alice public key
            String command = "echo \"" + OTP + "\" | gpg -u Login.com -esar " + userInput;
            // System.out.println("command is: " + command);
            processBuilder.command("bash", "-c", command );
    
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
                // System.out.println(output);
            }

            // Send to email
            try {
                // In practice it writes to the file in the parent folder "encmsg.txt"
                FileWriter sendEmail = new FileWriter("encmsg.txt");
                outputForEmail = output.toString();
                // System.out.println(outputForEmail);
                sendEmail.write(outputForEmail);
                sendEmail.close();
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }

            // Prompt user and start timer for max 60 seconds
            long startTime = System.currentTimeMillis();
            System.out.println("Type in decrypted OTP");
            userInput = loginSC.nextLine();
            long endTime = System.currentTimeMillis()-startTime;
            if (endTime >= 20000) System.out.println("Time limit exceeded! Authentication failed!");
            else if (userInput.equals(OTP)) System.out.println("Authentication complete!");
            else System.out.println("Authentication failed!");

            
        } else {
        // No information leak if user exists or not

        long startTime = System.currentTimeMillis();
        System.out.println("Type in decrypted OTP");
        userInput = loginSC.nextLine();
        long endTime = System.currentTimeMillis()-startTime;
        if (endTime >= 20000) System.out.println("Time limit exceeded! Authentication failed!");
        else if (userInput.equals(generate()));
        System.out.println("Authentication failed!");
        }
    }

    // Helper method for random OTP
    public static String generate(){
        SecureRandom sr = new SecureRandom();
        //random integer
        String pass = "";
        for (int i = 0; i < 32; i++) {
            // from 33 dec. to 126 dec. in ASCII Table
            int OTP = sr.nextInt(9)+48;
            pass += (char) OTP;
        }

        return pass;
    }

    // TODO: Create account
    // TODO: Add timer if user is not fast enough
    // TODO: Account retrieval by email/revoke keys
    // TODO: Clean up code
    
}
