public class Cash extends IPaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid in cash");
    }
}