

import java.awt.*;
import java.util.ArrayList;
import java.util.List; 
import javax.swing.*;
import javax.swing.table.DefaultTableModel; 

public class ExpenseTrackerView extends JFrame{

  private JTable transactionsTable;
  private JButton addTransactionBtn;
  private JButton addFilterBtn;
  private JTextField amountField;
  private JTextField categoryField;
  private JTextField timeStamp;
  private DefaultTableModel model;
  private List<Transaction> transactions = new ArrayList<>();

  String[] times = {"Time", "Morning", "Evening", "Afternoon", "Night"};

  
  /** 
   * @return JTable
   */
  public JTable getTransactionsTable() {
    return transactionsTable;
  }

  
  /** 
   * @return double
   */
  public double getAmountField() {
    if(amountField.getText().isEmpty()) {
      return 0;
    }else {
    double amount = Double.parseDouble(amountField.getText());
    return amount;
    }
  }

  
  /** 
   * @param amountField
   */
  public void setAmountField(JTextField amountField) {
    this.amountField = amountField;
  }

  public String getCategoryField() {
    return categoryField.getText();
  }

  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }

  public JButton getFilteredBtn() {
    return addFilterBtn;
  }

  public DefaultTableModel getTableModel() {
    return model;
  }

  public JButton getTimeStamp(){
    return getTimeStamp();
  }

  public ExpenseTrackerView(DefaultTableModel model) {
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger
    this.model = model;

    addTransactionBtn = new JButton("Add Transaction");
    addFilterBtn = new JButton("filter");

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    amountField = new JTextField(10);
    
    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);
    transactionsTable = new JTable(model);

    JLabel timeLabel = new JLabel("Select a time");
    timeStamp = new JTextField(10);


    JComboBox<String> dropdown = new JComboBox<>(times);
  
    // Layout components

    JPanel topPanel = new JPanel();
    topPanel.add(amountLabel);
    topPanel.add(amountField);
    topPanel.add(categoryLabel); 
    topPanel.add(categoryField);
    topPanel.add(timeLabel);
    topPanel.add(dropdown);
    

    JPanel inputPanel = new JPanel();
    inputPanel.add(addTransactionBtn);
    inputPanel.add(addFilterBtn);
    
    JPanel buttonPane = new JPanel();
    buttonPane.add(addTransactionBtn);
    buttonPane.add(addFilterBtn);
  
    // Add panels to frame
    add(topPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER); 
    add(buttonPane, BorderLayout.SOUTH);
  
    // Set frame properties
    setSize(600, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  
  }

  public void refreshTable(List<Transaction> transactions) {
      // model.setRowCount(0);
      model.setRowCount(0);
      int rowNum = model.getRowCount();
      double totalCost=0;
      for(Transaction t : transactions) {
        totalCost+=t.getAmount();
      }
  
      // Add rows from transactions list
      for(Transaction t : transactions) {
        model.addRow(new Object[]{rowNum+=1,t.getAmount(), t.getCategory(), t.getTimestamp()});

      }
      Object[] totalRow = {"Total", null, null, totalCost};
      model.addRow(totalRow);
  
      // Fire table update
      transactionsTable.updateUI();
  
    }  

  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = getTransactions();
  
    // Pass to view
    refreshTable(transactions);
  
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }
  
  public void addTransaction(Transaction t) {
    transactions.add(t);
    getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();

  }
   
  
}
