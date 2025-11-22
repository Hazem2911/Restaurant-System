public class Order implements ISubject {
    public string ID;
    public List<OrderItem> Items;
    public string Customer;
    public string OrderType;
    public float subTotal;
    public float tax;
    public float discount;
    public float total;

    public Order(string id, string customer, string orderType) {
        this.ID = id;
        this.Items = new List<OrderItem>();
        this.Customer = customer;
        this.OrderType = orderType;
        this.subTotal = 0.0f;
        this.tax = 0.0f;
        this.discount = 0.0f;
        this.total = 0.0f;
    }
    void calculateTotals() {
        this.subTotal = 0.0f;
        foreach (OrderItem item in this.Items) {
            this.subTotal += item.Price * item.Quantity;
        }
        this.tax = this.subTotal * 0.07f; // Assuming a tax rate of 7%
        this.total = this.subTotal + this.tax - this.discount;
    }
    void placeOrder() {

    }
    void notifyObservers() {

    }
}