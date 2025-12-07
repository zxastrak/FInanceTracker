import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Income> incomes = new ArrayList<>();
    static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {

        Database.load(incomes, expenses); // Load database

        Scanner sc = new Scanner(System.in);
        int menu;

        do {
            System.out.println("\n=== Finance Tracker ===");
            System.out.println("1. Input Income");
            System.out.println("2. Input Expence");
            System.out.println("3. Lihat Mutasi");
            System.out.println("4. Balance");
            System.out.println("5. Leave");
            System.out.println("6. Reset");
            System.out.print("Choose (input number): ");

            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1 -> addIncome(sc);
                case 2 -> addExpense(sc);
                case 3 -> showAll();
                case 4 -> showBalance();
                case 5 -> Database.save(incomes, expenses);
                case 6 -> resetDatabase();
                default -> System.out.println("Menu invalid.");
            }

        } while (menu != 6);

        System.out.println("Data has been saved. Program ended.");
    }
    
//    MASUK KE JOBDESK PEMASUKAN

    static void addIncome(Scanner sc) {
        System.out.print("Date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Note: ");
        String desc = sc.nextLine();

        incomes.add(new Income(date, amount, desc));
        System.out.println("Income have been added.");
    }

//    MASUK KE JOBDESK PENGELUARANC
    
    static void addExpense(Scanner sc) {
        System.out.print("Date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Note: ");
        String desc = sc.nextLine();

        expenses.add(new Expense(date, amount, desc));
        System.out.println("Expense have been added.");
    }

    static void showAll() {
        System.out.println("\n=== MUTATION ===");

        for (Income i : incomes) System.out.println(i);
        for (Expense e : expenses) System.out.println(e);
    }

    static void showBalance() {
        double total = 0;

        for (Income i : incomes) total += i.amount;
        for (Expense e : expenses) total -= e.amount;

        System.out.println("\nBalance: " + total);
    }
    static void resetDatabase() {
    incomes.clear();
    expenses.clear();

    // Kosongkan file database juga
    Database.save(incomes, expenses);

    System.out.println("All data has been successfully reset, starting from zero.");
    }

}
