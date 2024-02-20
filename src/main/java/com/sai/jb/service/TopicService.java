package com.sai.jb.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.jb.entity.Topic;
import com.sai.jb.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository; 

//	private List<Topic> topics = new ArrayList<>(Arrays.asList(
//			new Topic("Spring","Spring Boot","Welcome to Spring Boot"),
//			new Topic("Java","Core Java","Welcome to Core Java"),
//			new Topic("React","React JS","Welcome to React JS")
//			));
	public List<Topic> getAllTopics()
	{
		//return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		
		return topics;
	}
	
	public Optional<Topic> getTopic(String id)
	{
		//return(topics.stream().filter(t -> t.getId().equals(id)).findFirst().get());
		return((Optional<Topic>) (topicRepository.findById(id)));
	}

	public String addTopic(Topic topic) 
	{
		//topics.add(topic);
		topicRepository.save(topic);
		return("Topic Added");
	}

	public String updateTopic(String id, Topic topic) {
		
//		for(int i = 0;i < topics.size(); i++)
//		{
//			Topic t = topics.get(i);
//			if(t.getId().equals(id))
//			{
//				topics.set(i, topic);
//				return("Updated topic");
//			}
//		}
		Optional<Topic> t = (Optional<Topic>) (topicRepository.findById(id));
		//if(t.equals(topic.getId()))
		if(t.isPresent())
		{
			topicRepository.save(topic);
			return("Updated Topic");
		}
		
		return("Given topic not found");
	}

	public String deleteTopic(String id) {
		
//		if(topics.removeIf(T -> T.getId().equals(id)))
//			return("Topic deleted successfully");
		Optional<Topic> t = (Optional<Topic>) (topicRepository.findById(id));
		if(t.isPresent())
		{
			topicRepository.deleteById(id);
			return("Deleted Topic");
		}
		return("Topic not found");
	}

}
