package swd20.Forum.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import swd20.Forum.domain.Comment;
import swd20.Forum.domain.CommentRepository;
import swd20.Forum.domain.ThreadRepository;
import swd20.Forum.domain.Topic;
import swd20.Forum.domain.UserRepository;

import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import java.security.Principal;
import java.time.LocalDateTime;  



@Controller
public class CommentController {
	
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	   LocalDateTime now = LocalDateTime.now();
	   
	@Autowired
	private CommentRepository repository; 
	
	@Autowired
	private ThreadRepository threadrepository;
	
	@Autowired
	private UserRepository urepository;
	
	// etusivulle
	@GetMapping(value="/")
    public String etusivu() {	
        return "home";
    }
	
    @GetMapping(value="/commentlist")
    public String commentList(Model model) {	
        model.addAttribute("comment", repository.findAll());
        return "commentlist";
    }
    
    @GetMapping(value="/thread_comments/{id}")
    public String apparelMaker(@PathVariable("id") Long id, Model model) {	
    	model.addAttribute("thread", threadrepository.findByThreadId(id));
       	model.addAttribute("comment", repository.findAll());

        return "thread_comments";
    }
    
    @RequestMapping(value = "/add")
    public String addComment(Model model){
    	model.addAttribute("comment", new Comment());
    	model.addAttribute("thread", threadrepository.findAll());
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	model.addAttribute("user", urepository.findByUsername(authentication.getName()));
        return "addcomment";
    }     
    

	/*
	 * @RequestMapping(value = "/save", method = RequestMethod.POST) public String
	 * save(@Valid Long id, Comment comment,BindingResult result, Model model){ if
	 * (result.hasErrors()) { model.addAttribute("thread",
	 * threadrepository.findAll()); return "addcomment"; } repository.save(comment);
	 * 
	 * return "redirect:threadlist/"; }
	 */
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Comment comment, BindingResult result, Model model){
    	if (result.hasErrors()) {
    	   	model.addAttribute("comment", new Comment());
    		model.addAttribute("thread", threadrepository.findAll());
    		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        	model.addAttribute("user", urepository.findByUsername(authentication.getName()));
    		return "addcomment";
    	}
        repository.save(comment);
        return "redirect:/threadlist";
    }    
        
    @RequestMapping(value = "/edit/{id}")
	public String editComment(@PathVariable("id") Long commentId, Model model) {
		model.addAttribute("comment", repository.findById(commentId));
		model.addAttribute("thread", threadrepository.findAll());
	   	model.addAttribute("user", urepository.findAll());

		return "editcomment";   
    
} 
    @GetMapping("/delete/{id}")
    public String deleteComment(@PathVariable("id") Long commentId, Model model) {
    	repository.deleteById(commentId);
        return "redirect:/commentlist";
    }
    }
