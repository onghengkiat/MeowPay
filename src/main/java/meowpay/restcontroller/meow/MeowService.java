package meowpay.restcontroller.meow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class MeowService {
    @Autowired
    private MeowRepository meowRepository;

    public MeowService() {
    }

    public Queue<Meow> getMeow(){
        Queue<Meow> list = new LinkedList<>();
        for(Meow meow : meowRepository.findAll()){
            list.add(meow);
        }
        return list;
    }

    public Meow getMeowByID(int id){
        return meowRepository.findById(id).get();
    }

    public void addMeow(Meow meow){
        this.meowRepository.save(meow);
    }
}
