package JavaGUI;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private List<Transaction> incomeList;
    private List<Transaction> expenseList;
    
    public TransactionManager() {
        // Load data dari file saat pertama kali
        incomeList = DataStorage.loadIncome();
        expenseList = DataStorage.loadExpense();
    }
    
    // ========== INCOME METHODS ==========
    
    // Tambah Income
    public boolean addIncome(String name, String date, double amount, String category, String note) {
        int newId = incomeList.size() + 1;
        Transaction t = new Transaction(newId, name, date, amount, category, note, "Income");
        incomeList.add(t);
        return DataStorage.saveIncome(incomeList);
    }
    
    // Get All Income
    public List<Transaction> getAllIncome() {
        return new ArrayList<>(incomeList);
    }
    
    // Delete Income by ID
    public boolean deleteIncome(int id) {
        boolean removed = incomeList.removeIf(t -> t.getId() == id);
        if (removed) {
            return DataStorage.saveIncome(incomeList);
        }
        return false;
    }
    
    // Update Income
    public boolean updateIncome(int id, String name, String date, double amount, String category, String note) {
        for (Transaction t : incomeList) {
            if (t.getId() == id) {
                t.setName(name);
                t.setDate(date);
                t.setAmount(amount);
                t.setCategory(category);
                t.setNote(note);
                return DataStorage.saveIncome(incomeList);
            }
        }
        return false;
    }
    
    // ========== EXPENSE METHODS ==========
    
    // Tambah Expense
    public boolean addExpense(String name, String date, double amount, String category, String note) {
        int newId = expenseList.size() + 1;
        Transaction t = new Transaction(newId, name, date, amount, category, note, "Expense");
        expenseList.add(t);
        return DataStorage.saveExpense(expenseList);
    }
    
    // Get All Expense
    public List<Transaction> getAllExpense() {
        return new ArrayList<>(expenseList);
    }
    
    // Delete Expense by ID
    public boolean deleteExpense(int id) {
        boolean removed = expenseList.removeIf(t -> t.getId() == id);
        if (removed) {
            return DataStorage.saveExpense(expenseList);
        }
        return false;
    }
    
    // Update Expense
    public boolean updateExpense(int id, String name, String date, double amount, String category, String note) {
        for (Transaction t : expenseList) {
            if (t.getId() == id) {
                t.setName(name);
                t.setDate(date);
                t.setAmount(amount);
                t.setCategory(category);
                t.setNote(note);
                return DataStorage.saveExpense(expenseList);
            }
        }
        return false;
    }
    
    // ========== BALANCE & TRANSACTION HISTORY ==========
    
    // Get All Transactions (Income + Expense)
    public List<Transaction> getAllTransactions() {
        List<Transaction> all = new ArrayList<>();
        all.addAll(incomeList);
        all.addAll(expenseList);
        return all;
    }
    
    // Hitung Total Income
    public double getTotalIncome() {
        return incomeList.stream().mapToDouble(Transaction::getAmount).sum();
    }
    
    // Hitung Total Expense
    public double getTotalExpense() {
        return expenseList.stream().mapToDouble(Transaction::getAmount).sum();
    }
    
    // Hitung Saldo
    public double getBalance() {
        return getTotalIncome() - getTotalExpense();
    }
    
    // Get Balance Array [totalIncome, totalExpense, saldo]
    public double[] getBalanceArray() {
        double totalIncome = getTotalIncome();
        double totalExpense = getTotalExpense();
        double saldo = totalIncome - totalExpense;
        return new double[]{totalIncome, totalExpense, saldo};
    }
}