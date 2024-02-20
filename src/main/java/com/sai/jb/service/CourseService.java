package com.sai.jb.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.jb.entity.Course;
import com.sai.jb.repository.CourseRepository;
import com.sai.jb.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository; 

//	private List<Course> Courses = new ArrayList<>(Arrays.asList(
//			new Course("Spring","Spring Boot","Welcome to Spring Boot"),
//			new Course("Java","Core Java","Welcome to Core Java"),
//			new Course("React","React JS","Welcome to React JS")
//			));
	public List<Course> getAllCourses(String topicId)
	{
		//return Courses;
		List<Course> courses = new ArrayList<>();
		//courseRepository.findAll()
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		
		return courses;
	}
	
	public Optional<Course> getCourse(String id)
	{
		//return(Courses.stream().filter(t -> t.getId().equals(id)).findFirst().get());
		return((Optional<Course>) (courseRepository.findById(id)));
	}

	public String addCourse(Course course) 
	{
		//Courses.add(Course);
		courseRepository.save(course);
		return("Course Added");
	}

	public String updateCourse(String id,Course course) {
		
//		for(int i = 0;i < Courses.size(); i++)
//		{
//			Course t = Courses.get(i);
//			if(t.getId().equals(id))
//			{
//				Courses.set(i, Course);
//				return("Updated Course");
//			}
//		}
		Optional<Course> t = (Optional<Course>) (courseRepository.findById(id));
		//if(t.equals(Course.getId()))
		if(t.isPresent())
		{
			courseRepository.save(course);
			return("Updated Course");
		}
		
		return("Given Course not found");
	}

	public String deleteCourse(String id) {
		
//		if(Courses.removeIf(T -> T.getId().equals(id)))
//			return("Course deleted successfully");
		Optional<Course> t = (Optional<Course>) (courseRepository.findById(id));
		if(t.isPresent())
		{
			courseRepository.deleteById(id);
			return("Deleted Course");
		}
		return("Course not found");
	}

}
