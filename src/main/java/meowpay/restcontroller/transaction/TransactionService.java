package meowpay.restcontroller.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionService() {
    }

    public Queue<Transaction> getTransaction(){
        Queue<Transaction> list = new LinkedList<>();
        for(Transaction transaction : transactionRepository.findAll()){
            list.add(transaction);
        }
        return list;
    }

    public Transaction getTransactionByID(String id){
        return transactionRepository.findById(id).get();
    }

    public void addTransaction(Transaction transaction){
        this.transactionRepository.save(transaction);
    }
}