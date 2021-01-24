package meowpay.restcontroller.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/comment")
    public String getAllCLaim(){
        return commentService.getComment().toString();
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return "Added successfully";
    }

    @RequestMapping("/comment/{id}")
    public String getCommentByID(@PathVariable int id){
        return commentService.getCommentByID(id).toString();
    }
}
