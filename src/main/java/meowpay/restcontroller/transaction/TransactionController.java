package meowpay.restcontroller.transaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/transaction")
    public String getAllTransaction(){
        return transactionService.getAllTransaction();
    }

    @RequestMapping("/transaction/meow/{meow_id}")
    public String getAllTransactionByMeowId(@PathVariable int meow_id){
        return transactionService.getTransactionByMeow(meow_id);
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public String addTransaction(@RequestBody Transaction transaction){
        transactionService.addTransaction(transaction);
        return "Added successfully";
    }

    @RequestMapping("/transaction/{id}")
    public String getTransactionByID(@PathVariable int id){
        return transactionService.getTransactionByID(id).toString();
    }

    @RequestMapping("/transaction/{id}/update/{status}")
    public String updateTransactionByID(@PathVariable int id, @PathVariable int status){
        return transactionService.updateStatus(id, status);
    }

}
