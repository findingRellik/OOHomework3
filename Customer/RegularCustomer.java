public class RegularCustomer extends Customer{
  public RegularCustomer(String n, Store s){
    type = "regular";
    name = n;
    store = s;
    minItem = 1;
    maxItem = 3;
    minNights = 3;
    maxNights = 5;
  }
}