package io.ramu.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;

	/*List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring FRamework", "Spring Framework Description"),
			new Topic("java", "Java 8", "Lamda Expressions"),
			new Topic("savascript", "JS", "Javascript Description")
			));*/ // removing hard coded list, because we are using derby database
	
	public List<Topic> getAllTopics(){
		//return topics;
		//findall is a iterable so we need to convert to list
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		//lambda expression to look into list and check the id is present in the topics
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);
		
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		/*for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/
		//same save() method is used for insertion and delete because if topic present it will update else it will enter a new record. 
 		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		//return;
		topicRepository.deleteById(id);
	}
	
}
