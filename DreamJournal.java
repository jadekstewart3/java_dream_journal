import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class DreamJournal {
  public static void  main(String[] args) {
    Scanner scanner = new Scanner(System.in); //read user input from keyboard
    File dreamFile = new File("dreams.txt"); //create a file object
    boolean running = true; //flag to control the loop

    while (running) {
      //menu display
      System.out.println("Welcome to your Dream Journal!");
      System.out.println("1. Write a new dream entry");
      System.out.println("2.Veiw all dreams in the clouds");
      System.out.println("3. EXIT");
      System.out.print("Enter your choice (1-3): ");

     String menuChoice = scanner.nextLine().trim(); //read user input

      if (menuChoice.equals("1")) {
        //handle writing a new dream entry
        System.out.println("Tell me your wildest dreams!");
        System.out.print(">");
        String dreamEntry = scanner.nextLine().trim(); //read dream entry
        //check if the dream entry is empty

        while (dreamEntry.isEmpty()){
          System.out.println ("Please enter some text! Dreams cant be empty!");
          System.out.print(">");
          dreamEntry = scanner.nextLine().trim(); //read dream entry
        }

      try{
        BufferedWriter writer = new BufferedWriter (new FileWriter("dreams.txt",true)); //open file in append mode
        writer.write("=== New Dream Entry ===\n");
        writer.write(dreamEntry + "\n"); //write the dream entry
        writer.write("Date: " + LocalDate.now() + "\n");
        writer.write("\n"); //header date and new line for formatting
        writer.close(); //save and close the file
        System.out.println("Your dream has been saved to the clouds!");
        System.out.println("\n"); //print a new line for formatting
      } catch (IOException e) {
        System.out.println("An error occurred while saving your dream.");
        e.printStackTrace(); //print the stack trace for debugging 
      }
      } else if (menuChoice.equals("2")) {
        //handle reading dreams from dreams.txt
        System.out.println("Here are all your dreams in the clouds:");

      } else if (menuChoice.equals("3")) {
        //handle exiting the program
        System.out.println("Goodbye!");
        running = false; //sets flag to exit the loop
      } else {
        //handle invalid input
        System.out.println("Invalid choice. Please try again.");
      }

    }
    scanner.close(); //close the scanner
  }
}

