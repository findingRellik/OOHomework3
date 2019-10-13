import java.util.Random;
import java.util.ArrayList;

interface CustomerInterface{
  void decideIfGoToStore();
}

abstract class Customer implements CustomerInterface{
  public ArrayList<Tool> tools = new ArrayList<Tool>();
  public String type = "";
  protected Random r = new Random();
  protected Store store = null;
  protected int go = 0;
  protected String name = "";
  protected int minItem = 0;
  protected int maxItem = 0;
  protected int minNights = 0;
  protected int maxNights = 0;
  protected int numNights = 0;
  protected Tool addTool(){ //DECORATOR PATTERN FOUND HERE
    int newItemInt = r.nextInt(store.tools.size());
    Tool newItem = store.tools.remove(newItemInt);
    int additions = r.nextInt(7);
    for(int j = 0; j < additions; j ++){
      int additionType = r.nextInt(3);
      if(additionType == 0){
        newItem = new ExtensionCord(newItem);
      }
      else if(additionType == 1){
        newItem = new AccessoryKit(newItem);
      }
      else{
        newItem = new ProtectiveGear(newItem);
      }
    }
    tools.add(newItem);
    return newItem;
  }
  protected void goToStore(){
    ArrayList<Tool> rrTools = new ArrayList<Tool>();
    numNights = 0;
    numNights += minNights;
    numNights += r.nextInt(maxNights - minNights + 1);
    for(int i = 0; i < minItem; i ++){
      rrTools.add(addTool());
    }
    for(int i = minItem; i < maxItem; i ++){
      if(store.tools.size() >= 1){
        int wantNewItem = r.nextInt(1);
        if(wantNewItem == 0){
          rrTools.add(addTool());
        }
      }
    }
    double totalCost = 0.0;
    for(int i = 0; i < rrTools.size(); i ++){
      totalCost += rrTools.get(i).cost();
    }
    RentalRecord rr = new RentalRecord(numNights, totalCost, rrTools, this);
    store.moneyMade += totalCost;
    store.records.add(rr);
  }
  public void decideIfGoToStore(){
    go = r.nextInt(6);
    if(go == 0 && store.tools.size() >= minItem){
      store.activeRentals += 1;
      goToStore();
    }
  }
}