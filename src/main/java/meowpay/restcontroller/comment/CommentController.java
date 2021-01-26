package meowpay.restcontroller.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/comment")
    public ResponseEntity<List<Comment>> getAllComment(){
        return ResponseEntity.ok(commentService.getComment());
    }

    @RequestMapping("/comment/claim/{claim_id}")
    public ResponseEntity<List<Comment>> getAllCommentByClaim(@PathVariable int claim_id){
        return ResponseEntity.ok(commentService.getCommentByClaim(claim_id));
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
        return ResponseEntity.ok(commentService.addComment(comment));
    }

    @RequestMapping("/comment/{id}")
    public ResponseEntity<Comment> getCommentByID(@PathVariable int id){
        return ResponseEntity.ok(commentService.getCommentByID(id));
    }
}
