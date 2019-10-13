//Observer code inspired by slides/textbook
//This is the third pattern used in this code, observer pattern.

import java.util.Observer;
import java.util.Observable;

public class StoreKeeper implements Observer{
  private Store store = null;
  public StoreKeeper(Store s){
    store = s;
  }
  public void update(Observable obs, Object obj){
    if(obs == store){
      System.out.println(store.getValue());
    }
  }
}