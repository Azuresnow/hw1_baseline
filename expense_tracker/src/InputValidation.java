import java.util.Arrays;
import javax.swing.JOptionPane;

public class InputValidation extends Transaction{
    
    public InputValidation(double amount, String category) {
        super(amount, category);

    }

    protected boolean checkAmount(){
        double amount = getAmount();
        if(amount < 0 || amount > 1000) {
            JOptionPane.showMessageDialog(null, "Amount has to be between 0 and 1000 you entered: " + amount, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    protected boolean checkCategory(){
        String category = getCategory();
        String[] categories = {"food", "travel", "bills", "entertainment", "other"};
        if(!Arrays.stream(categories).anyMatch(x -> x.equals(category))){
            JOptionPane.showMessageDialog(null, "Incorrect category must be food, travel, bills, entertainmentm, or others", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
}