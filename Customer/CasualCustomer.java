public class CasualCustomer extends Customer{
  public CasualCustomer(String n, Store s){
    type = "casual";
    name = n;
    store = s;
    minItem = 1;
    maxItem = 2;
    minNights = 1;
    maxNights = 2;
  }
}