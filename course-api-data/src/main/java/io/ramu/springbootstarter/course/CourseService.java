package io.ramu.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	/*List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring FRamework", "Spring Framework Description"),
			new Topic("java", "Java 8", "Lamda Expressions"),
			new Topic("savascript", "JS", "Javascript Description")
			));*/ // removing hard coded list, because we are using derby database
	
	public List<Course> getAllCourses(String topicId){
		//return topics;
		//findall is a iterable so we need to convert to list
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Optional<Course> getCourse(String id) {
		//lambda expression to look into list and check the id is present in the topics
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
		
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}

	public void updateCourse( Course course) {
		/*for(int i=0;i<topics.size();i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/
		//same save() method is used for insertion and delete because if topic present it will update else it will enter a new record. 
 		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		//return;
		courseRepository.deleteById(id);
	}
	
}
