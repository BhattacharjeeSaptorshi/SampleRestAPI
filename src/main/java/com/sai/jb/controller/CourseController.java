package com.sai.jb.controller;

//import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sai.jb.entity.Course;
import com.sai.jb.entity.Topic;
import com.sai.jb.service.CourseService;
//import com.sai.jb.service.courseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id)
	{
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id)
	{
		return(courseService.getCourse(id));
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public String addCourse(@RequestBody Course course, @PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId,"",""));
		return(courseService.addCourse(course));
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public String updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId,"",""));
		return(courseService.updateCourse(id,course));
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public String deleteCourse(@PathVariable String id)
	{
		return(courseService.deleteCourse(id));
	}
}
