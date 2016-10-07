public class Game {
  private String mItemName;
  private int mItemTotal;
  private int mRandomItemCount;
  
  public Game(){
    mItemName = "";
    mItemTotal = 0;
  }
  
  public Game(String itemName, int itemTotal){
    mItemName = itemName;
    mItemTotal = itemTotal;
  }
  
  public String getItemName(){
    return mItemName;  
  }
  
  public int getItemTotal(){
    return mItemTotal;
  }
  
  public void setItemName(String itemName){
    mItemName = itemName;
  }
  
  public void setItemTotal(int itemTotal){
    mItemTotal = itemTotal;
  }
  
  public void setRandomItemCount(int randomItemCount){
    mRandomItemCount = randomItemCount;
  }
  
  public int getRandomItemCount(){
    return mRandomItemCount;
  }
  
}
