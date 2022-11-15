package swd20.Forum.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swd20.Forum.domain.Comment;
import swd20.Forum.domain.CommentRepository;


@Controller
public class CommentRestController {
	
	@Autowired
	private CommentRepository arepository;
	
	// RESTful service to get all comment
    @RequestMapping(value="/comments", method = RequestMethod.GET)
    public @ResponseBody List<Comment> commentListRest() {	
        return (List<Comment>) arepository.findAll();
    }

	// RESTful service to get comment by id
    @RequestMapping(value="/comments/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Comment> findCommentRest(@PathVariable("id") Long commentId) {	
    	return arepository.findById(commentId);
    }      
    
    // RESTful service to save new comment
    @RequestMapping(value="/comments", method = RequestMethod.POST)
    public @ResponseBody Comment saveCommentRest(@RequestBody Comment comment) {	
    	return arepository.save(comment);
    }
    
    // RESTful service to delete comment
    @DeleteMapping("/comments/{id}")
    public @ResponseBody void deleteComment(@PathVariable("id") Long id) {
    	arepository.deleteById(id);
    }

}
