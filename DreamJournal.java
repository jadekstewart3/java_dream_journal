import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class DreamJournal {
  public static void  main(String[] args) {
    Scanner scanner = new Scanner(System.in); //read user input from keyboard
    boolean running = true; //flag to control the loop

    while (running) {
      displayMenu(); //call the display menu method
      String menuChoice = scanner.nextLine().trim(); //read user input
      running = handlMenuChoice(menuChoice, scanner); //call the handle menu choice method
    }
    scanner.close(); //close the scanner
  }

  //menu display method
  public static void displayMenu() { 
  System.out.println("Welcome to your Dream Journal!");
  System.out.println("1. Write a new dream entry");
  System.out.println("2.Veiw all dreams in the clouds");
  System.out.println("3. EXIT");
  System.out.print("Enter your choice (1-3): ");
  }

  public static boolean handlMenuChoice(String menuChoice, Scanner scanner) {
    switch (menuChoice) {
      case "1":
        writeDream(scanner); //handle writing a new dream entry
        break;
      case "2":
        readDreams(); //handle reading dreams from dreams.txt
        break;
      case "3":
        System.out.println("Goodbye!"); //handle exiting the program
        return false; //sets flag to exit the loop
      default:
        //handle invalid input
        System.out.println("Invalid choice. Please try again.");
    }
    return true; //continue the loop
  }

  //method to write a new dream entry
  public static void writeDream(Scanner scanner) {
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
  }

  //handle reading dreams from dreams.txt
  public static void readDreams() {
    System.out.println("Here are all your dreams in the clouds:");

      File dreamFile = new File("dreams.txt"); //create a file 
      //check if the file exists
      if (!dreamFile.exists()){
        System.out.println("No dreams found in the clouds. Start dreaming!");
      } else {
        try {
          BufferedReader reader = new BufferedReader(new FileReader(dreamFile)); //open the file for reading
          String line; //string to hold each line

          while (( line = reader.readLine()) != null) { //read each line until the end of the file
            System.out.println(line); //print the line
          }
          reader.close(); //close the file
        } catch (IOException e) {
          System.out.println("An error occurred while reading your dreams.");
          e.printStackTrace(); //print the stack trace for debugging
        }
      }
    }
}

