import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    // creating processbuilder   
    ProcessBuilder processBuilder = new ProcessBuilder();

    // Run a shell command
    // processBuilder.command("bash", "-c", "gpg --help");
    Scanner sc = new Scanner(System.in);
    boolean running = true;
    String command = "";

    // Tutorial
    System.out.println("Welcome to the PGP-console-UI");
    System.out.println("Write your commands in the Linux shell");
    System.out.println("Follow the directions and write 'Q' to QUIT");
    
    while (running) {
        System.out.println("... awaiting command ...");
        command = sc.nextLine();
        if (command.toUpperCase().equals("Q")) {
            System.out.println("... quitting ...");
            break;
        }

        try {
            processBuilder.command("bash", "-c", command);

    
            //Boiler plate initialization
            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
    
            //Creating output string
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
    
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println(output);
            } else {
                System.out.println("Wrong command");
                //abnormal...
            }
    
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    }

}