package io.ramu.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//our repository method will get all common crud operations from crudrepository
public interface CourseRepository extends CrudRepository<Course, String>{
	//getAllTopis()
	//getTopic(String id)
	//updateTopic(String id)
	//deleteTopic(String id)
	//if you declare a method starting with find then we do not have to implement it.
	//Check 31 spring boot lecture in java brains for better understanding
	
	public List<Course> findByTopicId(String topicId);

}
