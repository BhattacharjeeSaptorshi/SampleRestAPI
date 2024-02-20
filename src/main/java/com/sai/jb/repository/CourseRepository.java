package com.sai.jb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sai.jb.entity.Course;
//import com.sai.jb.entity.Topic;

public interface CourseRepository extends CrudRepository<Course,String>{

	//just an example
	public List<Course> findByName(String name);
	
	public List<Course> findByTopicId(String topicId);
}
