package JavaGUI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private static final String INCOME_FILE = "income_data.dat";
    private static final String EXPENSE_FILE = "expense_data.dat";
    
    // Simpan Income
    public static boolean saveIncome(List<Transaction> incomeList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(INCOME_FILE))) {
            oos.writeObject(incomeList);
            return true;
        } catch (IOException e) {
            System.out.println("Error menyimpan income: " + e.getMessage());
            return false;
        }
    }
    
    // Load Income
    @SuppressWarnings("unchecked")
    public static List<Transaction> loadIncome() {
        File file = new File(INCOME_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(INCOME_FILE))) {
            return (List<Transaction>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading income: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    
    // Simpan Expense
    public static boolean saveExpense(List<Transaction> expenseList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EXPENSE_FILE))) {
            oos.writeObject(expenseList);
            return true;
        } catch (IOException e) {
            System.out.println("Error menyimpan expense: " + e.getMessage());
            return false;
        }
    }
    
    // Load Expense
    @SuppressWarnings("unchecked")
    public static List<Transaction> loadExpense() {
        File file = new File(EXPENSE_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(EXPENSE_FILE))) {
            return (List<Transaction>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading expense: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}