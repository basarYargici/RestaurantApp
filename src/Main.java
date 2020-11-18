public class Main {
    public static void main(String[] args) {
        //Creating necessary objects
        Menu menu = new Menu();
        Table table = new Table(1);
        Waiter waiter = new Waiter(menu);
        Payment payment = new Payment(waiter);

        Customer ibrahim = new Customer("IBRAHIM", table, waiter, payment);
        Customer basar = new Customer("BASAR", table, waiter, payment);
        Customer yargici = new Customer("YARGİCİ", table, waiter, payment);

        //Adding item to the menu
        menu.addToMenu("RIBEYE", 235);
        menu.addToMenu("BEEF", 210);
        menu.addToMenu("SUCUK", 115);
        menu.addToMenu("SALMON", 105);
        menu.addToMenu("TUNA", 105);
        menu.addToMenu("WINE", 49);
        menu.addToMenu("YES", 75);
        menu.addToMenu("JASMIN", 60);
        menu.addToMenu("KONG", 90);
        menu.addToMenu("PICADOR", 40);

        //ibrahim and basar,who are customers, sit the tables
        ibrahim.sitTable();
        //basar will see that ibrahim's table is full now(0)(Task:when they leave; the table should be empty again)
        basar.sitTable();

        //ibrahim gives order and after eating, left the restaurant
        ibrahim.giveOrder();
        ibrahim.payCountAndLeave();

        //To show that after leaving of ibrahim, his table is empty(Task:when they leave; the table should be empty again)
        System.out.println("After ibrahim left available tables:");
        table.printTables();

        //basar gives order and after eating, left the restaurant
        basar.giveOrder();
        basar.payCountAndLeave();

        //While yargici wants to see all empty tables,
        //he will see that table of ibrahim and basar are empty now
        //because customer(ibrahim and basar) left the restaurant
        yargici.sitTable();


        //yargici gives order and after eating, left the restaurant
        yargici.giveOrder();
        yargici.payCountAndLeave();

        //finally to show the tables are empty(Task:when they leave; the table should be empty again)
        System.out.println("After customers left available tables:");
        table.printTables();
    }
}
