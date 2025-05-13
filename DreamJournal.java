import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class DreamJournal {
  public static void  main(String[] args) {
    Scanner scanner = new Scanner(System.in); //read user input from keyboard
    File dreamFile =new File("dreams.txt"); //create a file object
    boolean running = true; //flag to control the loop

    while (running) {
      System.out.println("Welcome to your Dream Journal!");
      System.out.println("1. Write a new dream entry");
      System.out.println("2.Veiw all dreams in the clouds");
      System.out.println("3. EXIT");
      System.out.print("Enter your choice (1-3): ");

      String choice = scanner.nextline(); //read user input

    }
    scanner.close(); //close the scanner
  }
}

