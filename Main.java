//Main fills our program with our Tool and Customer objects.
//You can see two patterns insitiated here, the third is a decorator pattern which is made and used in Customer, which decorates tools.

import java.io.PrintStream;
import java.io.FileNotFoundException;

class Main {
  public static void main(String[] args) {
    try { //This is to get the output streamed to a file
      PrintStream fileOut = new PrintStream("./output.txt");
      System.setOut(fileOut);
    } catch (FileNotFoundException e) {
      System.out.println("Wah");
    }

    Store store = new Store("");
    StoreKeeper storeKeeper = new StoreKeeper(store); //Observer pattern
    store.addObserver(storeKeeper);


    //Fill our Tools using a factory
    ToolFactory toolMaker = new ToolMaker(store); //Factory pattern
    Tool painting1 = toolMaker.createTool("painting", "Brush");
    Tool painting2 = toolMaker.createTool("painting", "Red paint");
    Tool painting3 = toolMaker.createTool("painting", "Blue paint");
    Tool painting4 = toolMaker.createTool("painting", "Purple paint");
    Tool painting5 = toolMaker.createTool("painting", "Gren paint");
    Tool painting6 = toolMaker.createTool("painting", "White paint");
    Tool painting7 = toolMaker.createTool("painting", "Black paint");
    Tool concrete1 = toolMaker.createTool("concrete", "Wet Concrete");
    Tool concrete2 = toolMaker.createTool("concrete", "Concrete Mixer");
    Tool concrete3 = toolMaker.createTool("concrete", "Concrete Truck");
    Tool plumbing1 = toolMaker.createTool("plumbing", "Pipes");
    Tool plumbing2 = toolMaker.createTool("plumbing", "Plunger");
    Tool plumbing3 = toolMaker.createTool("plumbing", "Plumbing Tool Kit");
    Tool woodwork1 = toolMaker.createTool("woodwork", "Woodchipper");
    Tool woodwork2 = toolMaker.createTool("woodwork", "Saw");
    Tool woodwork3 = toolMaker.createTool("woodwork", "Buzzsaw");
    Tool woodwork4 = toolMaker.createTool("woodwork", "Wood Carving Tools");
    Tool woodwork5 = toolMaker.createTool("woodwork", "Tree-Crane");
    Tool woodwork6 = toolMaker.createTool("woodwork", "Mini-Saw");
    Tool woodwork7 = toolMaker.createTool("woodwork", "Giant-Saw");
    Tool yardwork1 = toolMaker.createTool("yardwork", "Electric Lawn Mower");
    Tool yardwork2 = toolMaker.createTool("yardwork", "Riding Lawn Mower");
    Tool yardwork3 = toolMaker.createTool("yardwork", "Weed Wacker");
    Tool yardwork4 = toolMaker.createTool("yardwork", "Shovel");


    //Fill our Customers using a factory
    CustomerFactory customerMaker = new CustomerMaker(store); //Factory pattern
    Customer customer1 = customerMaker.createCustomer("casual", "Bobby B");
    Customer customer2 = customerMaker.createCustomer("regular", "Ned Stark");
    Customer customer3 = customerMaker.createCustomer("regular", "Catlyn Stark");Customer customer4 = customerMaker.createCustomer("business", "Jamie Lannister");
    Customer customer5 = customerMaker.createCustomer("business", "Cercie Lannister");
    Customer customer6 = customerMaker.createCustomer("business", "Theon Grayjoy");
    Customer customer7 = customerMaker.createCustomer("business", "Robb Stark");
    Customer customer8 = customerMaker.createCustomer("casual", "HODOR");
    Customer customer9 = customerMaker.createCustomer("business", "Olena Tyrell");
    Customer customer10 = customerMaker.createCustomer("casual", "Sansa Stark");
    Customer customer11 = customerMaker.createCustomer("casual", "Jon Snow");
    Customer customer12 = customerMaker.createCustomer("casual", "Ramsay Snow");

    //Run the store for 35 days and print final statement
    for(int i = 0; i < 35; i ++){
      store.runADay();
    }

    store.endOfDays();
  }
}