import java.util.Scanner;

class Conversation {

  public static void main(String[] arguments) {
    // You will start the conversation here.
    Scanner input = new Scanner(System.in);
    System.out.print("How many rounds? ");
    int numRounds = input.nextInt();
    // String userInput = "";
    //start rounds
    System.out.println("Hi there!");
    for(int i = 0; i<numRounds; i++){
      String userInput = input.next();
        System.out.println(userInput);
    }
    System.out.println("Thank you and bye!");

  }
}
// split string into words