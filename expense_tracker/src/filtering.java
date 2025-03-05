
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class filtering extends ExpenseTrackerView{

    public filtering(DefaultTableModel model) {
        super(model);
    }

    public void filterBy(String category){
         List<Transaction> filteredTransactions = getTransactions();
         Arrays.asList(filteredTransactions).stream().anyMatch(x -> x.equals(category));
        refreshTable(filteredTransactions);
    }
    
}
