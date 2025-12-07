import java.io.*;
import java.util.ArrayList;

public class Database {

    private static final String FILE_NAME = "database.txt";

    // SAVE
    public static void save(ArrayList<Income> incomes, ArrayList<Expense> expenses) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {

            // Simpan pemasukan
            for (Income i : incomes) {
                pw.println("IN;" + i.date + ";" + i.amount + ";" + i.description);
            }

            // Simpan pengeluaran
            for (Expense e : expenses) {
                pw.println("EX;" + e.date + ";" + e.amount + ";" + e.description);
            }

        } catch (Exception ex) {
            System.out.println("Gagal menyimpan database: " + ex.getMessage());
        }
    }

    // LOAD
    public static void load(ArrayList<Income> incomes, ArrayList<Expense> expenses) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");

                if (data[0].equals("IN")) {
                    incomes.add(new Income(data[1], Double.parseDouble(data[2]), data[3]));
                } else if (data[0].equals("EX")) {
                    expenses.add(new Expense(data[1], Double.parseDouble(data[2]), data[3]));
                }
            }

        } catch (Exception e) {
            System.out.println("Database baru atau kosong.");
        }
    }
}
