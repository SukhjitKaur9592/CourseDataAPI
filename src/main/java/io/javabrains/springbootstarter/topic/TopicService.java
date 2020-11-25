package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRespository;
	
	public List<Topic> getAllTopics()
	{
		List<Topic> topics = new ArrayList<>();
		topicRespository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id)
	{
		List<String> list = new ArrayList<String>();
		list.add(id);
		Iterable findAllById = topicRespository.findAllById(list);
		if (null != findAllById) {
			Iterator iterator = findAllById.iterator();
			while (iterator.hasNext()) {
				Topic topic1 = (Topic) iterator.next();
				return topic1;
			}
		}
		return null;	
	}

	public String add(Topic topic) {
		topicRespository.save(topic);
		String response = topic.getId()+" has been added successfully";
		return response;
	}

	public String updateTopic(Topic topic, String id) {
		List<String> list = new ArrayList<String>();
		list.add(id);
		Iterable findAllById = topicRespository.findAllById(list);
		if (null != findAllById) {
			Iterator iterator = findAllById.iterator();
			while (iterator.hasNext()) {
				Topic topic1 = (Topic) iterator.next();
				topic1.setId(topic.getId());
				topic1.setName(topic.getName());
				topic1.setDescription(topic.getDescription());
				topicRespository.save(topic1);
				return topic.getId()+" has been updated successfully";
			}
		}
		return "";
	}

	public String deleteTopic(String id) {
		topicRespository.deleteById(id);
		return id+" has been deleted successfully";
	}
}
