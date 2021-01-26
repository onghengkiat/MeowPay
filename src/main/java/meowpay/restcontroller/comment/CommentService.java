package meowpay.restcontroller.comment;

import meowpay.restcontroller.claim.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public CommentService(){

    }


    public List<Comment> getComment(){
        List<Comment> list = new LinkedList<>();
        for(Comment comment : commentRepository.findAll()){
            list.add(comment);
        }
        return list;
    }



    public Comment getCommentByID(int id){
        return commentRepository.findById(id).get();
    }

    public Comment addComment(Comment comment){
        return this.commentRepository.save(comment);
    }

    public List<Comment> getCommentByClaim(int claim_id){
        List<Comment> comments = new LinkedList<>();

        for(Comment comment : commentRepository.findByClaim(new Claim(claim_id))){
            comments.add(comment);
        }
        return comments;
    }
}
