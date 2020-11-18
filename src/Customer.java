import java.util.Scanner;

public class Customer {
    //region Attributes
    private String name;
    private int selectedTable;
    private Table table;
    private Waiter waiter;
    private Payment payment;
    //Scanner for taking input
    private Scanner scanner = new Scanner(System.in);
    //endregion

    //region Methods
    //Constructor
    public Customer(String name, Table table, Waiter waiter, Payment payment) {
        this.name = name;
        this.table = table;
        this.waiter = waiter;
        this.payment = payment;
    }

    //Return name
    public String getName() {
        return name;
    }


    /* Print the tables over table object,
     * shows it as 0 if someone sat on table.
     * Finally select table to sit
     */
    public void sitTable() {
        System.out.println("Available tables:");
        table.printTables();
        System.out.println("Which table do you want to sit?");
        boolean validInput = false;
        while (!validInput) {
            if (scanner.hasNextInt()) {
                selectedTable = scanner.nextInt();
                if (selectedTable > 0 && selectedTable < 17) {
                    if (table.getSelectedTables().contains(selectedTable)) {
                        System.out.println("That table is full! please select non-zero tables!");
                    } else {
                        validInput = true;
                        System.out.println();
                    }
                } else {
                    System.out.println("Please enter a num between 0 and 16!");
                    validInput = false;
                }
            } else if (scanner.hasNext()) {
                scanner.next();
                System.out.println("Please enter a num between 0 and 16!");
                validInput = false;
            }
        }
        table.getSelectedTables().add(selectedTable);
    }

    //Prints the menu over waiter and gives order to waiter
    public void giveOrder() {
        waiter.printMenu();
        waiter.getOrder();
    }

    //Pays count over cashier and leaves the restaurant
    public void payCountAndLeave() {
        Cashier cashier = new Cashier(this, payment);
        cashier.getPayment();
        cashier.sendOffTheCostumer();
        if (table.getSelectedTables().contains(selectedTable)) {
            table.getSelectedTables().remove((Integer) selectedTable);
        }
    }
    //endregion
}
