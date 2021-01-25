package meowpay.restcontroller.comment;

import meowpay.restcontroller.entry.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public CommentService(){

    }


    public String getComment(){
        List<Comment> list = new LinkedList<>();
        for(Comment comment : commentRepository.findAll()){
            list.add(comment);
        }
        return list.toString();
    }



    public String getCommentByID(int id){
        return commentRepository.findById(id).get().toString();
    }

    public void addComment(Comment comment){
        this.commentRepository.save(comment);
    }

    public String getCommentByEntry(int entry_id){
        List<Comment> comments = new LinkedList<>();

        for(Comment comment : commentRepository.findByEntry(new Entry(entry_id))){
            comments.add(comment);
        }
        return comments.toString();
    }
}
