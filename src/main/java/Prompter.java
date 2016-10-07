import java.io.Console;
import java.util.Random;
public class Prompter{
  
  private Game jarGuessingGame;
  
  public Prompter(Game game){
    jarGuessingGame = game;
  }
  
  public void play(){
    System.out.println("ADMINISTRATOR SETUP");
    System.out.println("=====================");
    specifyItemName();
    specifyItemTotal();
    setRandomNumber(jarGuessingGame.getItemTotal());
    
    System.out.println("PLAYER");
    System.out.println("========================");
    System.out.println("Your goal is to guess how many " +
                       jarGuessingGame.getItemName() +
                       " are in the jar. Your guess should be between 1 and " +
                       jarGuessingGame.getItemTotal());
    System.out.println();
    
    tryToGuess();
  }
  
  public void specifyItemName(){
      Console console = System.console();
      String itemName = console.readLine("Name of items in the jar:  ");
      jarGuessingGame.setItemName(itemName);
  }
  
  public void specifyItemTotal(){
      Console console = System.console();
      String itemTotalString = console.readLine("Maximum number of " +
                                                jarGuessingGame.getItemName() +
                                                " in the jar:  ");
      console.printf("%n");
      int itemTotal = Integer.parseInt(itemTotalString);
      jarGuessingGame.setItemTotal(itemTotal);
  }
  
  public void setRandomNumber(int itemTotal){
    Random random = new Random();
    jarGuessingGame.setRandomItemCount(random.nextInt(itemTotal) + 1);
  }
  
  public void tryToGuess(){
    Console console = System.console();
    int guess = 0;
    int numberOfGuesses = 0;
    while(true){
      numberOfGuesses = numberOfGuesses + 1;
      guess = Integer.parseInt(console.readLine("Guess:  "));
      
      if(guess == jarGuessingGame.getRandomItemCount()){
        console.printf("%nCongratulations - you guess that there are " + 
                      jarGuessingGame.getRandomItemCount() + " " +
                      jarGuessingGame.getItemName()  + " in the jar! It took you " + 
                        numberOfGuesses + " guess(es) to get it right.");
        return;
      }
      
      if(Math.abs(jarGuessingGame.getRandomItemCount() - guess) < 5){
        console.printf("You're getting closer to your number. Keep up!%n");
      }
      else{
        console.printf("You're kind of far from your number. Don't give up!%n");
      }
    }
  }
}