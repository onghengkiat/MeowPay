package meowpay.restcontroller.transaction;

import meowpay.restcontroller.meow.Meow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionService() {
    }

    public String getAllTransaction(){
        List<Transaction> list = new LinkedList<>();
        for(Transaction transaction : transactionRepository.findAll()){
            list.add(transaction);
        }
        return list.toString();
    }


    public String getTransactionByMeow(int meow_id){
        List<Transaction> list = new LinkedList<>();
        for(Transaction transaction : transactionRepository.findByCreditorOrDebitor(new Meow(meow_id), new Meow(meow_id))){
            list.add(transaction);
        }
        return list.toString();
    }


    public Transaction getTransactionByID(int id){
        return transactionRepository.findById(id).get();
    }

    public void addTransaction(Transaction transaction){
        this.transactionRepository.save(transaction);
    }

    public String updateStatus(int id, int status){
        Transaction transaction = this.getTransactionByID(id);
        transaction.setStatus(status);
        this.transactionRepository.save(transaction);
        return "Updated successfully";
    }
}