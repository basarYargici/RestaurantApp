import java.util.LinkedList;
import java.util.Scanner;

public class Waiter {
    //region Attributes
    private double count;
    private Menu menu;

    //Use List to be able to add or remove from elements
    private LinkedList<String> selectedItems = new LinkedList<>();

    //Scanner for taking input from customer
    Scanner scanner = new Scanner(System.in);
    //endregion

    //region Methods
    //Constructor
    public Waiter(Menu menu) {
        this.menu = menu;
    }

    //Set the count
    public void setCount(double count) {
        this.count = count;
    }

    //Return selectedItems
    public LinkedList<String> getSelectedItems() {
        return selectedItems;
    }

    //Set selectedItems
    public void setSelectedItems(LinkedList<String> selectedItems) {
        this.selectedItems = selectedItems;
    }

    //Ask what customer wants and get order
    public void getOrder() {
        String item;
        System.out.println("Please enter your wants one by one and finish your choices with writing 0");
        item = scanner.next();
        while (!item.equals("0")) {
            if (menu.getMenuList().containsKey(item)) {
                selectedItems.add(item);
                System.out.println("'" + item + "' taken. Please enter another item to order or press 0 to finish your order.");
            } else if (!item.equals("\n")) {
                System.out.println("Menu does not contains '" + item + "'. Please enter another item or press 0 to finish your order.");
            }
            item = scanner.next();
        }
        if (!selectedItems.isEmpty()) {
            System.out.println("Order taken");
        }
    }

    //Calculate the payment count over selectedItems
    public double calculateOrder() {
        for (String item : menu.getMenuList().keySet()) {
            if (selectedItems.contains(item)) {
                count += menu.getMenuList().get(item);
            }
        }
        return count;
    }

    //Print all items in menu
    public void printMenu() {
        menu.printMenu();
    }
    //endregion
}
