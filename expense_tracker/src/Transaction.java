

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction{

  private double amount;
  private String category;
  private String timestamp;

  public Transaction(double amount, String category) {
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  
  /** 
   * @return double
   */
  public double getAmount() {
    return amount;
  }

  
  /** 
   * @param amount
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  
  /** 
   * @return String
   */
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category; 
  }
  
  public String getTimestamp() {
    return timestamp;
  }

  private String generateTimestamp() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
    return sdf.format(new Date());
  }

}