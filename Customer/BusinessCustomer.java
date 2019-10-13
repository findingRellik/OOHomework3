public class BusinessCustomer extends Customer{
  public BusinessCustomer(String n, Store s){
    type = "business";
    name = n;
    store = s;
    minItem = 3;
    maxItem = 3;
    minNights = 7;
    maxNights = 7;
  }
}