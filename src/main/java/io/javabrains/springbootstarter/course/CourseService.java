package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRespository;
	
	public List<Course> getAllCourses(String topicId)
	{
		List<Course> courses = new ArrayList<>();
		courseRespository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id)
	{
		List<String> list = new ArrayList<String>();
		list.add(id);
		Iterable findAllById = courseRespository.findAllById(list);
		if (null != findAllById) {
			Iterator iterator = findAllById.iterator();
			while (iterator.hasNext()) {
				Course course = (Course) iterator.next();
				return course;
			}
		}
		return null;
		
	}

	public void add(Course course) {
		courseRespository.save(course);
	}

	public void updateCourse(Course course, String id) {
		List<String> list = new ArrayList<String>();
		list.add(id);
		Iterable findAllById = courseRespository.findAllById(list);
		if (null != findAllById) {
			Iterator iterator = findAllById.iterator();
			while (iterator.hasNext()) {
				Course course1 = (Course) iterator.next();
				course1.setId(course.getId());
				course1.setName(course.getName());
				course1.setDescription(course.getDescription());
				courseRespository.save(course1);
			}
		}
	
	}

	public void deleteCourse(String id) {
		courseRespository.deleteById(id);
	}
}
