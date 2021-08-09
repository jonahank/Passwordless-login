import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    boolean running = true;
    String command = "";
    String currentUser = "[please set local user]";

    // Tutorial
    System.out.println("   ***********************************************************   ");
    System.out.println("   ***********************************************************   ");
    System.out.println("   *****                                                 *****   ");
    System.out.println("   *****          Welcome to the PGP-console-UI          *****   ");
    System.out.println("   *****   -------------------------------------------   *****   ");
    System.out.println("   *****      Write your commands in the Linux shell     *****   ");
    System.out.println("   *****   Follow the directions and write 'Q' to QUIT   *****   ");
    
    while (running) {
        // menu screen
        System.out.println("   *****   -------------------------------------------   *****   ");
        System.out.println("           Current local user: " + currentUser + "      ");
        System.out.println("   *****   -------------------------------------------   *****   ");
        System.out.println("   *****                                                 *****   ");
        System.out.println("   *****   1 -> Decrypt password-less                    *****   ");
        System.out.println("   *****   2 -> Set current local user                   *****   ");
        System.out.println("   *****   3 -> Create new local key-pair                *****   ");
        System.out.println("   *****   4 -> Advanced settings                        *****   ");
        System.out.println("   *****   Q -> QUIT                                     *****   ");
        System.out.println("   *****                                                 *****   ");
        System.out.println("   *****   -------------------------------------------   *****   ");
        System.out.println("   *****              .. awaiting command ...            *****   ");
        
        // checking user input
        command = sc.nextLine();
        if (command.toUpperCase().equals("Q")) {
            System.out.println("   *****   -------------------------------------------   *****   ");
            System.out.println("   *****                                                 *****   ");
            System.out.println("   *****                 ... quitting ...                *****   ");
            System.out.println("   *****                                                 *****   ");
            System.out.println("   *****   -------------------------------------------   *****   ");
            break;
        }
        try {
            String tmp;
            switch (command) {
                // Decrypting message
                case "1":
                    Decryptz.decrypt();
                    break;

                case "2":
                    tmp = SetUserz.setUser();
                    currentUser = (tmp == null)?"[please set local user]" : tmp ;
                    break;
                
                case "3":
                    tmp = Createz.create();
                    currentUser = (tmp == null)? "[please set local user]" : tmp;
                    break;

                case "4":
                    System.out.println("   *****             ... not implemented yet ...         *****   ");
                    break;

                default:
                    System.out.println("   *****            ... wrong input try again ...        *****   ");
                    break;
            }


            // processBuilder.command("bash", "-c", command);

    
            //Boiler plate initialization
            /* Process process = processBuilder.start();
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
     */
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // close the scanner
    sc.close();


    }

}