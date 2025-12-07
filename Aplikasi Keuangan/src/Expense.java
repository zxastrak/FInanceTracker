public class Expense {
    String date;
    double amount;
    String description;

    public Expense(String date, double amount, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    @Override
    public String toString() {
        return date + " | Pengeluaran | " + amount + " | " + description;
    }
}
