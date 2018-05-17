package io.ramu.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

//our repository method will get all common crud operations from crudrepository
public interface TopicRepository extends CrudRepository<Topic, String>{
	//getAllTopis()
	//getTopic(String id)
	//updateTopic(String id)
	//deleteTopic(String id)
	

}
