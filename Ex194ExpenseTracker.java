/*
Expense Tracker [Mini Project | Project]
Model Expense with category enum, amount and description; store in List. Add validation, category totals, 
largest expense, sorted reports and stream-based total/filter operations.
Done when: Negative/zero expenses are rejected and loop and stream calculations are cross-checked on a 
sample dataset.
*/


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

enum ExpenseCategory {
    Food, Transport, Shopping, Education
}

class Expense {
    int id;
    String description;
    ExpenseCategory category;
    double amount;
    
    Expense(int id, String description, ExpenseCategory category, double amount) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.amount = amount;
    }
}

class ExpenseTracker {
    List<Expense> expenses = new ArrayList<>();
    
    void addExpense(Expense expense) {
        if (expenses.stream().anyMatch(e -> e.id == expense.id)) {
            System.out.println("Expense ID already exists.");
            return;
        }
        
        if (expense.amount <= 0) {
            System.out.println("Expense amount must be positive.");
            return;
        }
        
        expenses.add(expense);
        
    }
    
    void categoryTotal(ExpenseCategory category) {
        double total = expenses.stream()
                               .filter(e -> e.category == category)
                               .mapToDouble(e -> e.amount)
                               .sum();
        
        System.out.println(category + " Total: " + total);
    }
    
    void largestExpense() {
        Expense largest = expenses.stream()
                                  .max(Comparator.comparingDouble(e -> e.amount))
                                  .orElse(null);
        
        if (largest != null) {
            System.out.println("\nLargest Expense: " + largest.amount + " - " + largest.description);
        }
    }
    
    void sortedReport() {
        System.out.println("\nExpenses: ");
        
        expenses.stream()
                .sorted(Comparator.comparingDouble((Expense e) -> e.amount).reversed())
                .forEach(e -> System.out.println("ID: " + e.id + " | Description: " + e.description + " | Category: " + e.category + " | Amount:" + e.amount));
    }
    
    double loopTotal() {
        double total = 0;
        
        for (Expense e: expenses) {
            total += e.amount;
        }
        
        return total;
    }
    
    double streamTotal() {
        return expenses.stream()
                       .mapToDouble(e -> e.amount)
                       .sum();
    }
    
    void compareTotals() {
        System.out.println("\nLoop Total: " + loopTotal());
        System.out.println("\nStream Total: " + streamTotal());
        
        System.out.println("Same Result: " + (loopTotal() == streamTotal()));
    }
}

public class Ex194ExpenseTracker {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        
        tracker.addExpense(new Expense(101, "Lunch", ExpenseCategory.Food, 100));
        tracker.addExpense(new Expense(102, "Car", ExpenseCategory.Transport, -120000));
        tracker.addExpense(new Expense(103, "Shirt", ExpenseCategory.Shopping, 800));
        tracker.addExpense(new Expense(104, "Book", ExpenseCategory.Education, 200));
        tracker.addExpense(new Expense(105, "Dinner", ExpenseCategory.Food, 150));
        tracker.addExpense(new Expense(103, "Pen", ExpenseCategory.Education, 10));

        tracker.categoryTotal(ExpenseCategory.Food);
        
        tracker.largestExpense();
        
        tracker.sortedReport();
        
        tracker.compareTotals();
    }
}