import java.util.ArrayList;

public class User {
    private String name;
    private double balance;
    private Portfolio portfolio;
    private ArrayList<Transaction> transactions;

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        portfolio = new Portfolio();
        transactions = new ArrayList<>();
    }

    public void buy(Stock stock, int qty) {
        if (stock == null) {
            System.out.println("Invalid stock!");
            return;
        }

        if (qty <= 0) {
            System.out.println("Quantity must be positive!");
            return;
        }

        double cost = stock.getPrice() * qty;

        if (balance >= cost) {
            balance -= cost;
            portfolio.buyStock(stock.getSymbol(), qty);

            transactions.add(
                new Transaction("BUY",
                        stock.getSymbol(),
                        qty,
                        stock.getPrice())
            );

            System.out.println("Purchase successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void showDetails() {
        System.out.println("\nBalance: ₹" + balance);
        portfolio.displayPortfolio();

        System.out.println("\nTransactions:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}