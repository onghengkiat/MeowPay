package meowpay.restcontroller.transaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/transaction")
    public String getAllTransaction(){
        return transactionService.getTransaction().toString();
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public String addTransaction(@RequestBody Transaction transaction){
        transactionService.addTransaction(transaction);
        return "Added successfully";
    }

    @RequestMapping("/transaction/{id}")
    public String getTransactionByID(@PathVariable String id){
        return transactionService.getTransactionByID(id).toString();
    }

}
