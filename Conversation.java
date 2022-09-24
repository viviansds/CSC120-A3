import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.List;
class Conversation {

  public static void main(String[] arguments) {
    //create a scanner that takes input from user
    Scanner input1 = new Scanner(System.in);
    //prompt
    System.out.print("How many rounds? ");
    int numRounds = input1.nextInt();
    //create an array of response
    String[] bot_response = {"Interesting", "Got it", "What do you mean?","Tell me more..."
    };
    //create an array of words to mirror and an array of replacements
    // * I -> you
    // * me -> you
    // * am -> are
    // * you -> I
    // * my -> your
    // * your -> my
    String[] toMirror= {"I","me","am","you","are","my","your"};
    String[] replacement={"you","you","are","I","am","your","my"};
    // String userInput = "";
    //start rounds
    System.out.println("Hi there!");
    for(int i = 0; i<numRounds; i++){
      Scanner input2 = new Scanner(System.in);
      String userInput = input2.nextLine();
      // System.out.println(userInput);
      String[] splitted_userInput = userInput.split("\\s");
      String[] copy_userInput = splitted_userInput.clone();
      Boolean hasMirror=false;
      // System.out.print("user-input: "+splitted_userInput.length+" copy-input: "+copy_userInput.length);
      for(int j = 0; j<splitted_userInput.length;j++){
       inner: for (int k=0; k<toMirror.length;k++){
          // System.out.print("j="+j+" "+"k="+k);
          if (splitted_userInput[j].equals(toMirror[k])){
            // System.out.print("j="+j+"k="+k);
            copy_userInput[j] = replacement[k];
            // System.out.println("new replacement="+copy_userInput[j]);
            hasMirror=true;
            // System.out.println(hasMirror);
            // System.out.println("Yes I did it");
            break inner;
          }
        }
      };
      if(hasMirror){
        //put splitted_userInput back together
        List<String> list_userInput = Arrays.asList(copy_userInput);
        // String hasMirror_reply = String.join(" ", splitted_userInput); 
        String answer = String.join(" ", list_userInput);
        System.out.println(answer+"?");
      }else{
      //create a random generator to select an array
        Random generator = new Random();
        int randomIndex = generator.nextInt(bot_response.length);
        String reply = bot_response[randomIndex];
        // System.out.println(Arrays.toString(splitted_userInput));
        System.out.println(reply);
        // if(splitted_userInput[j].equals("I")){
        //   splitted_userInput[j] = "you";
        //   hasMirror = true;
        // }
    
      
      }
  }System.out.println("Thank you and bye!");
}
}