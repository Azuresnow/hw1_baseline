import java.util.InputMismatchException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp{

  
  /** 
   * @param args
   */
  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    

    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
      view.getAddTransactionBtn().addActionListener(e -> {
        
        // Get transaction data from view
        double amount = view.getAmountField(); 
        String category = view.getCategoryField();
        

        // Create transaction object
        Transaction t = new Transaction(amount, category);
        InputValidation value = new InputValidation(amount, category);

        try{
          value.errorHandle();
          view.addTransaction(t);
        }catch(InputMismatchException f){
          if(!value.checkAmount()) {
           JOptionPane.showMessageDialog(null, "Amount has to be between 0 and 1000 you entered: " + amount, "Error", JOptionPane.ERROR_MESSAGE);
          } else {
          JOptionPane.showMessageDialog(null, "Incorrect category must be food, travel, bills, entertainment, or others", "Error", JOptionPane.ERROR_MESSAGE);
          }
        }

        // Call controller to add transaction
      
      });
  
  }
}