package swd20.Forum.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd20.Forum.domain.ThreadRepository;
import swd20.Forum.domain.TopicRepository;
import swd20.Forum.domain.Thread;











@Controller
public class ThreadController {


	@Autowired
	private ThreadRepository threadrepository; 
	@Autowired
	private TopicRepository topicrepository; 
			
	@RequestMapping(value="/threadlist", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("thread", threadrepository.findAll());
		return "threadlist";
	}
    @GetMapping(value="/topic_threads/{id}")
    public String apparelMaker(@PathVariable("id") Long id, Model model) {	
    	model.addAttribute("topic", topicrepository.findByTopicId(id));
       	model.addAttribute("thread", threadrepository.findAll());

        return "topic_threads";
    }
    
	@RequestMapping(value = "/addthread")
    public String addthread(Model model){
	    model.addAttribute("thread", new Thread()); 
    	model.addAttribute("topic", topicrepository.findAll());
        return "addthread";
    }     
    
    @RequestMapping(value = "/savethread", method = RequestMethod.POST)
    public String save(Thread thread){
    	threadrepository.save(thread);
        return "redirect:/threadlist";
    }    
    @GetMapping("/deletethread/{id}")
    public String deleteThread(@PathVariable("id") Long id, Thread thread) {
    	threadrepository.deleteById(id);
        return "redirect:/threadlist";
    }
    @RequestMapping(value = "/editthread/{id}")
	public String editThread(@PathVariable("id") Long id, Model model) {
		model.addAttribute("thread", threadrepository.findById(id));
		
		return "editthread";   
    
} 
}


