package io.javabrains.course;

import java.util.ArrayList;
import java.util.List;
import io.javabrains.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
  public List<Course> getAllCourses(String topicId){
	  //return topics;
	  List<Course> courses=new ArrayList<>();
	  courseRepository.findByTopicId(topicId).forEach(courses::add);
	  
	  return courses;
  }
  
 /* public Course getCourse(String id) {
	  //return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
	  return courseRepository.findOne(id);
  }*/

public void addCourse(Course course) {
	courseRepository.save(course);
}

public void updateCourse(Course course){
	courseRepository.save(course);
}

public void deleteCourse(String id) {
	courseRepository.delete(id);

}

public Course getCourse(String id) {
	// TODO Auto-generated method stub
	return  courseRepository.findOne(id);
}





}
