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
    //create an array of words to mirror and an array of replacements
    String[] toMirror= {"I","am","you","are"};
    String[] replacement={"you","are","I","am"};
    // String userInput = "";
    //start rounds
    System.out.println("Hi there!");
    for(int i = 0; i<numRounds; i++){
      String userInput = input.next();
      String[] splitted_userInput = userInput.split(" ");
      //mirror words
      Boolean hasMirror=false;
      for(int j = 0; j<splitted_userInput.length;j++){
        inner:for (int k=0; k<toMirror.length;k++){
          if (splitted_userInput[j].equals(toMirror[k])){
            System.out.print("j="+j+"k="+k);
            splitted_userInput[j] = replacement[k];
            System.out.println("new replacement="+splitted_userInput[j]);
            hasMirror=true;
            System.out.println(hasMirror);
            break inner;
          }
          if(hasMirror){
            //put splitted_userInput back together
            String hasMirror_reply = String.join(" ", splitted_userInput);
            System.out.println("bug "+hasMirror_reply);
          }
        }
        
      //   else{
      //     //create a random generator to select an array
      //   Random generator = new Random();
      //   int randomIndex = generator.nextInt(bot_response.length);
      //   String reply = bot_response[randomIndex];
      //   // System.out.println(Arrays.toString(splitted_userInput));
      //   System.out.println(reply);
      // };
        // if(splitted_userInput[j].equals("I")){
        //   splitted_userInput[j] = "you";
        //   hasMirror = true;
        // }
      }
      
      }
      
  
    // * I -> you
    // * me -> you
    // * am -> are
    // * you -> I
    // * my -> your
    // * your -> my
    System.out.println("Thank you and bye!");

  }
}