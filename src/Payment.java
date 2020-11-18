import java.util.LinkedList;

public class Payment {
    //region Attributes
    private Waiter waiter;
    //endregion

    //region Methods
    //Constructor
    public Payment(Waiter waiter) {
        this.waiter = waiter;
    }

    //Print the count which is come over waiter
    public void printCount() {
        if (!waiter.getSelectedItems().isEmpty()) {
            System.out.print("You ate : ");
            for (String o : waiter.getSelectedItems()) {
                System.out.print(o + " ");
            }
            System.out.println("\nThe count = " + waiter.calculateOrder());
            waiter.setCount(0);
            waiter.setSelectedItems(new LinkedList<>());
        } else {
            System.out.println("You did not eat anything. The count = 0");
        }
    }
    //endregion
}
