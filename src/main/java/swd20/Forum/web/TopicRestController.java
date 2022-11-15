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

import swd20.Forum.domain.Topic;
import swd20.Forum.domain.TopicRepository;


@Controller
public class TopicRestController {
	
	@Autowired
	private TopicRepository arepository;
	
	// RESTful service to get all topic
    @RequestMapping(value="/topics", method = RequestMethod.GET)
    public @ResponseBody List<Topic> topicListRest() {	
        return (List<Topic>) arepository.findAll();
    }

	// RESTful service to get topic by id
    @RequestMapping(value="/topics/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Topic> findTopicRest(@PathVariable("id") Long topicId) {	
    	return arepository.findById(topicId);
    }      
    
    // RESTful service to save new topic
    @RequestMapping(value="/topics", method = RequestMethod.POST)
    public @ResponseBody Topic saveTopicRest(@RequestBody Topic topic) {	
    	return arepository.save(topic);
    }
    
    // RESTful service to delete topic
    @DeleteMapping("/topics/{id}")
    public @ResponseBody void deleteTopic(@PathVariable("id") Long id) {
    	arepository.deleteById(id);
    }

}
