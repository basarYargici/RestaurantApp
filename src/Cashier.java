public class Cashier {
    //region Attributes
    private Payment payment;
    private Customer customer;
    //endregion

    //region Methods
    //Constructor
    public Cashier(Customer customer,Payment payment) {
        this.payment = payment;
        this.customer = customer;
    }

    //Print count over payment
    public void getPayment() {
        payment.printCount();
    }

    //Send off the customer and thanks
    public void sendOffTheCostumer() {
        System.out.println("Thank you " + customer.getName() + "!\n");
    }
    //endregion
}
