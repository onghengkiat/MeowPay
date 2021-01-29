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

    public List<Transaction> getAllTransaction(){
        List<Transaction> list = new LinkedList<>();
        for(Transaction transaction : transactionRepository.findAll()){
            list.add(transaction);
        }
        return list;
    }


    public List<Transaction> getTransactionByMeow(int meow_id){
        List<Transaction> list = new LinkedList<>();
        for(Transaction transaction : transactionRepository.findByCreditorOrDebitor(new Meow(meow_id), new Meow(meow_id))){
            list.add(transaction);
        }
        return list;
    }


    public Transaction getTransactionByID(int id){
        return transactionRepository.findById(id).get();
    }

    public Transaction updateStatus(int id, int status){
        Transaction transaction = this.getTransactionByID(id);
        transaction.setStatus(status);
        return this.transactionRepository.save(transaction);
    }
}