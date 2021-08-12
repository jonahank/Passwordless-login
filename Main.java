import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    boolean running = true;
    String command = "";
    String currentUser = "[please set local user]";
    String OTP = "[choose 'Decrypt password-less']";

    // Print front page
    Headerz.printPGL();

    // Tutorial

    System.out.println("             *****                                                 *****   ");
    System.out.println("             *****           Welcome to your PGL-session!          *****   ");
    System.out.println("             *****   -------------------------------------------   *****   ");
    System.out.println("             *****       Write your commands in the terminal       *****   ");
    System.out.println("             *****   Follow the directions and write 'Q' to QUIT   *****   ");
    
    while (running) {
        // menu screen
        System.out.println("             *****   -------------------------------------------   *****   ");
        System.out.println("                     OTP: " + OTP + "  ");
        System.out.println("             *****   -------------------------------------------   *****   ");
        System.out.println("             *****                                                 *****   ");
        System.out.println("             *****   1 -> Decrypt password-less                    *****   ");
        System.out.println("             *****   2 -> Create new local key-pair                *****   ");
        System.out.println("             *****   Q -> QUIT                                     *****   ");
        System.out.println("             *****                                                 *****   ");
        System.out.println("             *****   -------------------------------------------   *****   ");
        System.out.println("             *****             .. awaiting command ...             *****   ");
        
        // checking user input
        command = sc.nextLine();
        if (command.toUpperCase().equals("Q")) {
            System.out.println("             *****                                                 *****   ");
            System.out.println("             *****                 ... quitting ...                *****   ");
            System.out.println("             *****                                                 *****   ");
            System.out.println("             *****   -------------------------------------------   *****   ");
            break;
        }
        try {
            String tmp;
            switch (command) {

                case "1":
                    tmp = Decryptz.decrypt();
                    OTP = (tmp == null)? "[choose 'Decrypt password-less']" : tmp;
                    break;

                case "2":
                    tmp = Createz.create();
                    currentUser = (tmp == null)? "[please set local user]" : tmp;
                    break;

                default:
                    System.out.println("             *****            ... wrong input try again ...        *****   ");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    sc.close();
    }

}