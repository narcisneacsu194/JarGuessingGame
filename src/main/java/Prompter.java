import java.io.Console;
import java.util.Random;
import java.util.Scanner;

public class Prompter{

  private Scanner scanner;
  private Game jarGuessingGame;
  
  public Prompter(Game game){
    scanner = new Scanner(System.in);
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
    System.out.print("Name of items in the jar:  ");
    String itemName = scanner.nextLine();
    jarGuessingGame.setItemName(itemName);
  }
  
  public void specifyItemTotal(){
      System.out.print("Maximum number of " +
              jarGuessingGame.getItemName() +
              " in the jar:  ");
      String itemTotalString = scanner.nextLine();
      System.out.println();
      int itemTotal = Integer.parseInt(itemTotalString);
      jarGuessingGame.setItemTotal(itemTotal);
  }
  
  public void setRandomNumber(int itemTotal){
    Random random = new Random();
    jarGuessingGame.setRandomItemCount(random.nextInt(itemTotal) + 1);
  }
  
  public void tryToGuess(){
    int guess = 0;
    int numberOfGuesses = 0;
    while(true){
      numberOfGuesses = numberOfGuesses + 1;
      System.out.print("Guess:  ");
      guess = Integer.parseInt(scanner.nextLine());
      
      if(guess == jarGuessingGame.getRandomItemCount()){
        System.out.printf("%nCongratulations - you guess that there are " +
                jarGuessingGame.getRandomItemCount() + " " +
                jarGuessingGame.getItemName()  + " in the jar! It took you " +
                numberOfGuesses + " guess(es) to get it right.");

        return;
      }
      
      if(Math.abs(jarGuessingGame.getRandomItemCount() - guess) < 5){
        System.out.printf("You're getting closer to your number. Keep up!%n");
      }
      else{
        System.out.printf("You're kind of far from your number. Don't give up!%n");
      }
    }
  }
}