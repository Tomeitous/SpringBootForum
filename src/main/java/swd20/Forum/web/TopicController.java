package swd20.Forum.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;	
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd20.Forum.domain.Topic;
import swd20.Forum.domain.TopicRepository;










@Controller
public class TopicController {


	@Autowired
	private TopicRepository topicrepository; 
			
	@RequestMapping(value="/topiclist", method = RequestMethod.GET)
	public String topiclist(Model model) {
		model.addAttribute("topic", topicrepository.findAll());
		return "topiclist";
	}
	
	@RequestMapping(value = "/addtopic")
    public String addTopic(Model model){
    	model.addAttribute("topic", new Topic());
        return "addtopic";
    }     
	
	  @RequestMapping(value = "/savetopic", method = RequestMethod.POST)
	    public String save(@Valid Topic topic, BindingResult result, Model model){  
	        if (result.hasErrors()) {
	    		model.addAttribute("makers", topicrepository.findAll());
	    		return "addtopic";
	    	}
	        topicrepository.save(topic);
	        return "redirect:/topiclist";
	    }    
    
    @GetMapping("/deletetopic/{id}")
    public String deleteTopic(@PathVariable("id") Long id, Topic topic) {
    	topicrepository.deleteById(id);
        return "redirect:/topiclist";
    }
    @RequestMapping(value = "/edittopic/{id}")
	public String editTopic(@PathVariable("id") Long id, Model model) {
		model.addAttribute("topic", topicrepository.findById(id));
		
		return "edittopic";   
    
} 
}


