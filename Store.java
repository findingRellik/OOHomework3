//Observable code inspired by slides/textbook

import java.util.*;
import java.util.ArrayList;

public class Store extends Observable{
  public ArrayList<Tool> tools = new ArrayList<Tool>();
  public ArrayList<RentalRecord> records = new ArrayList<RentalRecord>();
  public ArrayList<Customer> customers = new ArrayList<Customer>();

  public int day = 1;
  public int activeRentals = 0;
  public int completedRentals = 0;
  public double moneyMade = 0.0;
  public double totalMoney = 0.0;

  private String announce = "";
  public Store(String s){
    announce = s;
  }
  public void setMessage(String s){
    announce = s;
    setChanged();
    notifyObservers();
  }
  public String getValue(){
    return announce;
  }
  public void runADay(){
    for(int i = 0; i < records.size(); i++){
      if(records.get(i).rentalDaysRemaining > 0){
        records.get(i).rentalDaysRemaining -= 1;
        if(records.get(i).rentalDaysRemaining == 0){
          for(int j = 0; j < records.get(i).tools.size(); j ++){
            tools.add(records.get(i).tools.get(j).returnTool());
          }
          completedRentals += 1;
          activeRentals -= 1;
        }
      }
    }
    for(int i = 0; i < customers.size(); i ++){
      customers.get(i).decideIfGoToStore();
    }

    setMessage("||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    setMessage("Day number: " + day);

    setMessage("===");
    setMessage("Total Completed Rentals: " + completedRentals);
    for(int i = 0; i < records.size(); i++){
      if(records.get(i).rentalDaysRemaining == 0){
        setMessage("---");
        setMessage("Renter: " + records.get(i).renter.name + " for " + records.get(i).numDays + " day(s).");
        setMessage("Tools:");
        ArrayList<Tool> t = records.get(i).tools;
        double totalCost = 0;
        for(int j = 0; j < t.size(); j ++){
          setMessage("Item(s): " + t.get(j).getName());
          double c = Math.round(t.get(j).cost() * 100.0) / 100.0;
          setMessage("Cost: " + c);
          totalCost += c;
        }
        setMessage("Total Fee: " + Math.round(totalCost * 100.0) / 100.0);
      }
    }

    setMessage("===");
    setMessage("Total Active Rentals: " + activeRentals);
    for(int i = 0; i < records.size(); i++){
      if(records.get(i).rentalDaysRemaining > 0){
        setMessage("---");
        setMessage("Renter: " + records.get(i).renter.name + " for " + records.get(i).numDays + " day(s).");
        ArrayList<Tool> t = records.get(i).tools;
        for(int j = 0; j < t.size(); j ++){
          setMessage("Tool: " + t.get(j).getToolName());
        }
      }
    }

    setMessage("===");
    setMessage("Tools left in store: " + tools.size());
    for(int i = 0; i < tools.size(); i ++){
      setMessage(" - " + tools.get(i).name);
    }

    setMessage("===");
    setMessage("Money made: " + (Math.round(moneyMade * 100.0) / 100.0));

    day += 1;
    totalMoney += moneyMade;
    moneyMade = 0.0;
  }
  public void endOfDays(){
    setMessage(" ");
    setMessage("===");
    setMessage("END OF DAYS");
    setMessage("Total rentals: " + records.size());
    int casualCount = 0;
    int businessCount = 0;
    int regularCount = 0;
    for(int i = 0; i < records.size(); i ++){
      if(records.get(i).renter.type == "casual"){
        casualCount += 1;
      }
      else if(records.get(i).renter.type == "business"){
        businessCount += 1;
      }
      else if(records.get(i).renter.type == "regular"){
        regularCount += 1;
      }
    }
    setMessage("Total Casual Customer Rentals: " + casualCount);
    setMessage("Total Business Customer Rentals: " + businessCount);
    setMessage("Total Regular Customer Rentals: " + regularCount);
    setMessage("Total Money: " + Math.round(totalMoney * 100.0) / 100.0);
  }
}