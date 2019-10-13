//Created "by customer" and is held by Store

import java.util.ArrayList;

public class RentalRecord{
  public int numDays = 0;
  public int rentalDaysRemaining = 0;
  public double cost = 0.0;
  public ArrayList<Tool> tools = new ArrayList<Tool>();
  public Customer renter = null;
  public RentalRecord(int days, double c, ArrayList<Tool> t, Customer cu){
    rentalDaysRemaining = days;
    numDays = days;
    cost = c;
    tools = t;
    renter = cu;
  }
}