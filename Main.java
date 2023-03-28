import java.util.ArrayList;
import java.util.Scanner;
class Item {
  String name;
  String serial;
  Integer value; 
}

class Inventory {
  ArrayList<Item> inventory = new ArrayList();
  Scanner input = new Scanner(System.in);
  void addItem(){
    Item newItem = new Item();
    System.out.println("Enter the name:");
    newItem.name = input.nextLine();
    System.out.println("Enter the serial number:");
    newItem.serial = input.nextLine();
    System.out.println("Enter the value in dollars (whole number):");
    newItem.value = input.nextInt();
    input.nextLine();
    inventory.add(newItem);
  }
  void removeItem(){
    System.out.println("Enter serial of item you want remove");
    String serial=input.nextLine();
    for(int i = 0; i < inventory.size(); i++){
      if(inventory.get(i).serial.equals(serial)){
        inventory.remove(i);
        break;
      }
    }
  }
  void updateItem(){
    System.out.println("Enter serial number of item to change:");
    String serial=input.nextLine();
    for(int i = 0; i < inventory.size(); i++){
      if(inventory.get(i).serial.equals(serial)){
        System.out.println("Enter the new name:");
        inventory.get(i).name=input.nextLine();
        System.out.println("Enter the new value in dollars (whole number):");
        inventory.get(i).value=input.nextInt();
        input.nextLine();
        break;
      }
    }
  }
  void showInventory(){
    for(int i = 0; i < inventory.size(); i++){
      System.out.println(inventory.get(i).name +","+ inventory.get(i).serial +","+ inventory.get(i).value);
    }
  }

  void menu(){
    boolean notDone = true;
    while(notDone){
      System.out.println("Press 1 to add an item.");
      System.out.println("Press 2 to delete an item.");
      System.out.println("Press 3 to update an item.");
      System.out.println("Press 4 to show all the items.");
      System.out.println("Press 5 to quit the program.");
      int theCase = input.nextInt();
      input.nextLine();
      switch(theCase){
        case 1:
          addItem();
          break;
        case 2:
          removeItem();
          break;
        case 3:
          updateItem();
          break;
        case 4:
          showInventory();
          break;
        case 5:
          notDone = false;
          break;
      }
    }
    input.close();
  }
  
}

public class Main {
	public static void main(String[] args) {
    Inventory inv1 = new Inventory();
    inv1.menu();
	}
}