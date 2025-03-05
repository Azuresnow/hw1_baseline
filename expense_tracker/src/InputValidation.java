import java.util.Arrays;
import java.util.InputMismatchException;

public class InputValidation extends Transaction{
    
    public InputValidation(double amount, String category) {
        super(amount, category);

    }

    protected boolean checkAmount(){
        double amount = getAmount();
        return !(amount < 0 || amount > 1000);
    }

    protected boolean checkCategory(){
        String category = getCategory();
        String[] categories = {"food", "travel", "bills", "entertainment", "other"};
        return Arrays.stream(categories).anyMatch(x -> x.equals(category.toLowerCase()));
    }

    public void errorHandle(){
        if(!checkAmount()){
            throw new InputMismatchException("Amount must be 0 - 1000");
        }

        if(!checkCategory()){
            throw new InputMismatchException("Invalid category");
        }
    }
    
}