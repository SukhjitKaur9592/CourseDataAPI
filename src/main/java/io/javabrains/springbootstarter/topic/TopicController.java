package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins="*")
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	
	@RequestMapping("topics")
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();
	}
	
	@RequestMapping("topics/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		return topicService.getTopic(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="topics")
	public String addTopic(@RequestBody Topic topic)
	{
		return topicService.add(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="topics/{id}")
	public String updateTopic(@RequestBody Topic topic,@PathVariable String id)
	{
		
		return topicService.updateTopic(topic,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="topics/{id}")
	public String deleteTopic(@PathVariable String id)
	{
		return topicService.deleteTopic(id);
	}
	
}
