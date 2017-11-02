package io.javabrains.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
  public List<Topic> getAllTopics(){
	  //return topics;
	  List<Topic> topics=new ArrayList<>();
	  topicRepository.findAll().forEach(topics::add);
	  
	  return topics;
  }
  
  public Topic getTopic(String id) {
	  //return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
	  return topicRepository.findOne(id);
  }

public void addTopic(Topic topic) {
	topicRepository.save(topic);
}


public void updateTopic(String id, Topic topic) {
	
	topicRepository.updateByTopicId(id, topic.getName(), topic.getDescription());
	
}

public void deleteTopic(String id) {
	topicRepository.delete(id);

}



}