public class StockTradingPlatform {
    public static void main(String[] args) {

        Stock tcs = new Stock("TCS", "Tata Consultancy", 3500);
        Stock infy = new Stock("INFY", "Infosys", 1600);

        User user = new User("Vedant", 100000);

        System.out.println("Market Data");
        System.out.println(tcs.getSymbol() + " : ₹" + tcs.getPrice());
        System.out.println(infy.getSymbol() + " : ₹" + infy.getPrice());

        user.buy(tcs, 10);
        user.buy(infy, 5);

        user.showDetails();
    }
}