package io.javabrains.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.topic.Topic;
import io.javabrains.topic.TopicService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TopicService topicService;
	
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllcourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getTopic(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addTopic(@RequestBody Course course,@PathVariable String topicId) {
		Topic topi=topicService.getTopic(topicId);
		course.setTopic(new Topic(topi.getId(),topi.getName(),topi.getDescription()));
		courseService.addCourse(course);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateTopic(@RequestBody Course course, @PathVariable String topicId,@PathVariable String id) {
		Topic topi=topicService.getTopic(topicId);
		course.setTopic(new Topic(topi.getId(),topi.getName(),topi.getDescription()));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
