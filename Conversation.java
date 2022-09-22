import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;


class Conversation {

  public static void main(String[] arguments) {
    //create a scanner that takes input from user
    Scanner input = new Scanner(System.in);
    //prompt
    System.out.print("How many rounds? ");
    int numRounds = input.nextInt();
    //create an array of response
    String[] bot_response = {"Interesting", "Got it", "What do you mean?"
    };
    // String userInput = "";
    //start rounds
    System.out.println("Hi there!");
    for(int i = 0; i<numRounds; i++){
      String userInput = input.next();
      String[] splitted_userInput = userInput.split("\\s+");
      //create a random generator to select an array
      Random generator = new Random();
      int randomIndex = generator.nextInt(bot_response.length);
      String reply = bot_response[randomIndex];
      System.out.println(Arrays.toString(splitted_userInput));
      System.out.println(reply);
    };
    
    System.out.println("Thank you and bye!");

  }
}
// split string into words