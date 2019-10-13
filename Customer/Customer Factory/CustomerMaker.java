//Concrete Factory pattern implementation for Customers

public class CustomerMaker extends CustomerFactory{
  public Store store = null;
  public CustomerMaker(Store s){
    store = s;
  }
  public Customer createCustomer(String type, String name){
    if(type.equals("casual")){
      Customer c = new CasualCustomer(name, store);
      store.customers.add(c);
      return c;
    }
    else if(type.equals("business")){
      Customer c = new BusinessCustomer(name, store);
      store.customers.add(c);
      return c;
    }
    else if(type.equals("regular")){
      Customer c = new RegularCustomer(name, store);
      store.customers.add(c);
      return c;
    }
    return null;
  }
}