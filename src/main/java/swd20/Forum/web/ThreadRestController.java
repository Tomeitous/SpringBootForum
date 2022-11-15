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

import swd20.Forum.domain.Thread;
import swd20.Forum.domain.ThreadRepository;


@Controller
public class ThreadRestController {
	
	@Autowired
	private ThreadRepository arepository;
	
	// RESTful service to get all thread
    @RequestMapping(value="/threads", method = RequestMethod.GET)
    public @ResponseBody List<Thread> threadListRest() {	
        return (List<Thread>) arepository.findAll();
    }

	// RESTful service to get thread by id
    @RequestMapping(value="/threads/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Thread> findThreadRest(@PathVariable("id") Long threadId) {	
    	return arepository.findById(threadId);
    }      
    
    // RESTful service to save new thread
    @RequestMapping(value="/threads", method = RequestMethod.POST)
    public @ResponseBody Thread saveThreadRest(@RequestBody Thread thread) {	
    	return arepository.save(thread);
    }
    
    // RESTful service to delete thread
    @DeleteMapping("/threads/{id}")
    public @ResponseBody void deleteThread(@PathVariable("id") Long id) {
    	arepository.deleteById(id);
    }

}
