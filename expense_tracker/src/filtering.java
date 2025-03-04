
import java.util.List;

public class filtering extends InputValidation{

    private List<Transaction> transactions;
    
        public filtering(double amount, String category, List<Transaction> transactions) {
            super(amount, category);
            this.transactions = transactions;
        
    }
    
    public Object[] filterBy() {

        return transactions.stream()
                .filter(transaction -> transaction.getAmount() == getAmount() && transaction.getCategory().equals(getCategory())).toArray();
    }
    
}
