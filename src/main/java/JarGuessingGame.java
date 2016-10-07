public class JarGuessingGame{
  public static void main(String[] args){
    Game game = new Game();
    Prompter prompter = new Prompter(game);
    prompter.play();
  }
}