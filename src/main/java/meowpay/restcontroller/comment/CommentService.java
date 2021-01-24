package meowpay.restcontroller.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public CommentService(){

    }


    public Queue<Comment> getComment(){
        Queue<Comment> list = new LinkedList<>();
        for(Comment comment : commentRepository.findAll()){
            list.add(comment);
        }
        return list;
    }

    public Comment getCommentByID(int id){
        return commentRepository.findById(id).get();
    }

    public void addComment(Comment comment){
        this.commentRepository.save(comment);
    }

}
