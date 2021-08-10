import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Headerz {


    public static void printPGL(){
        try {
            File PGL = new File("Header.txt");
            Scanner sc = new Scanner(PGL);
            // Print PGL-logo
            while (sc.hasNextLine()) System.out.println(sc.nextLine());

        } catch (FileNotFoundException e) {
            System.out.println("No pickle for you!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        printPGL();
    }
    
}
