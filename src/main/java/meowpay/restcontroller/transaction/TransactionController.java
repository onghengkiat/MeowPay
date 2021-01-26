package meowpay.restcontroller.transaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/transaction")
    public ResponseEntity<List<Transaction>> getAllTransaction(){
        return ResponseEntity.ok(transactionService.getAllTransaction());
    }

    @RequestMapping("/transaction/meow/{meow_id}")
    public ResponseEntity<List<Transaction>> getAllTransactionByMeowId(@PathVariable int meow_id){
        return ResponseEntity.ok(transactionService.getTransactionByMeow(meow_id));
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction){
        return ResponseEntity.ok(transactionService.addTransaction(transaction));
    }

    @RequestMapping("/transaction/{id}")
    public ResponseEntity<Transaction> getTransactionByID(@PathVariable int id){
        return ResponseEntity.ok(transactionService.getTransactionByID(id));
    }

    @RequestMapping("/transaction/{id}/update/{status}")
    public ResponseEntity<Transaction> updateTransactionByID(@PathVariable int id, @PathVariable int status){
        return ResponseEntity.ok(transactionService.updateStatus(id, status));
    }

}
