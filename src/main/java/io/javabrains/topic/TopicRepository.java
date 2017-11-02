package io.javabrains.topic;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import io.javabrains.course.Course;


public interface TopicRepository extends CrudRepository<Topic, String> {
	
	@Modifying(clearAutomatically = true)
	@Transactional
    @Query("UPDATE Topic t SET t.name = :name, t.description= :description WHERE t.id = :id")
	public void updateByTopicId(@Param("id") String id, @Param("name") String name,@Param("description") String description);




	
}
