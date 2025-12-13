package JavaGUI;

import java.io.Serializable;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    private String date;
    private double amount;
    private String category;
    private String note;
    private String type; // "Income" atau "Expense"
    
    // Constructor kosong
    public Transaction() {}
    
    // Constructor lengkap
    public Transaction(int id, String name, String date, double amount, String category, String note, String type) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.note = note;
        this.type = type;
    }
    
    // Getter dan Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}