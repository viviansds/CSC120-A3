import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* The Conversation program implements a chatbot that builds a simple
* back-and-forth dialogue with the user. It will first prompt the user to input
* an integer representing the number of rounds of conversation. Then it
* will print messages responding to the user and accepting responses until the
* number of rounds requested is reached. The bot will either mirror the user
* input base on a series of mirror words or generate a random response. Finally,
* it will say its final goodbye before printing a transcript of the entire
* conversation.
*
* @author  Vivian Wei
* @version 1.0
* @since   2022-9-20
*/

class Conversation {

  public static void main(String[] arguments) {
    //initialize chatbot
    System.out.println("Welcome to the Java ChatBot!");
    //create a scanner that takes input from user
    try (Scanner input1 = new Scanner(System.in)) {
    //prompt user to enter number of rounds of conversation
    System.out.print("How many rounds? ");
    int numRounds = input1.nextInt();
    //create an array of random response
    String[] bot_response = {"Interesting", 
                            "Got it", 
                            "What do you mean?",
                            "Tell me more...",
                            "I'm not sure about that...",
                            "Sure!"
                            };
    //create an array of words to mirror and an array of replacements
    String[] toMirror= {"I","me","am","you","are","my","your","you.","I'm","myself"};
    String[] replacement={"you","you","are","I","am","your","my","me","You're","yourself"};
    //create an arraylist that can store all conversation and print out later
    ArrayList<String> Transcript = new ArrayList<String>();
    Transcript.add("Transcript:");
    System.out.println("Hi there! What's on your mind?");
    Transcript.add("Hi there! What's on your mind?");
    
    //start rounds
    for(int i = 0; i<numRounds; i++){
      //create a different scanner for user input during the rounds
      Scanner input2 = new Scanner(System.in);
      String userInput = input2.nextLine();
      Transcript.add(userInput);
      //split up the user input to check mirror
      String[] splitted_userInput = userInput.split("\\s");
      //create a copy of array to replace mirror words
      String[] copy_userInput = splitted_userInput.clone();
      Boolean hasMirror=false;

      //create a nested loop to check for mirror words and add replacement
      for(int j = 0; j<splitted_userInput.length;j++){
        for (int k=0; k<toMirror.length;k++){
        //If the splitted user input matches one of the mirror words, change the
        //word to its corresponding replacement
          if (splitted_userInput[j].equals(toMirror[k])){
            copy_userInput[j] = replacement[k];
            hasMirror=true;
          }
        }
      }
      //Using boolean to decide what kind of response to print
      if(hasMirror){
        //put splitted_userInput back together and add it to transcript
        List<String> list_userInput = Arrays.asList(copy_userInput);
        String answer = String.join(" ", list_userInput);
        System.out.println(answer+"?");
        Transcript.add(answer+"?");
      }else{
      //create a random generator to select an array
        Random generator = new Random();
        int randomIndex = generator.nextInt(bot_response.length);
        String reply = bot_response[randomIndex];
        // System.out.println(Arrays.toString(splitted_userInput));
        System.out.println(reply);
        Transcript.add(reply);
      }
    }
    //end round and print transcript
    System.out.println("Thank you and bye!");
    Transcript.add("Thank you and bye!");
    String Final_Transcript = String.join("\n",Transcript);
    System.out.println("\n"+Final_Transcript);
   }
  }
}
