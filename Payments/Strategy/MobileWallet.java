public class MobileWallet extends IPaymentStrategy {
    private String mobileNumber;
    private String pin;

    public MobileWallet(String mobileNumber, String pin) {
        this.mobileNumber = mobileNumber;
        this.pin = pin;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using mobile wallet");
    }
}