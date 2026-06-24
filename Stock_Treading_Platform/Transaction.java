public class Transaction {
    private String type; // BUY or SELL
    private String stockSymbol;
    private int quantity;
    private double price;

    public Transaction(String type, String stockSymbol,
                       int quantity, double price) {
        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return type + " " + quantity + " shares of "
                + stockSymbol + " @ " + price;
    }
}