public class Income {
    String date;
    double amount;
    String description;

    public Income(String date, double amount, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    @Override
    public String toString() {
        return date + " | Pemasukan | " + amount + " | " + description;
    }
}
