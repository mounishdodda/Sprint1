package com.example.sprint1.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.sprint1.bean.CourseEntity;

@SpringBootTest
class CourseServiceTest {

	@Autowired
	ICourseService courseServ;
	
	@Test
	void addCourse() {
		CourseEntity course=new CourseEntity(93,"Python","Python is a Programming Language");
		String s=courseServ.add(course);
		assertEquals("Course Added Successfully",s);
	}
	
	@Test
	void updateCourse() {
		CourseEntity course=new CourseEntity(122,"Cricket","Cricket is a Sport");
		CourseEntity result=courseServ.update(course);
		assertEquals("Cricket",result.getName());
	}
	
	@Test
	void updateNameById() {
		CourseEntity course=courseServ.updateNameById(122,"Android");
		assertEquals("Cricket is a Sport",course.getDescription());
		assertEquals("Android",course.getName());
		
	}
	
	@Test
	void deleteCourse() {
		CourseEntity course=new CourseEntity(122,"Android","Cricket is a Sport");
		CourseEntity result=courseServ.delete(course);
		assertEquals("Android",result.getName());
		assertEquals("Cricket is a Sport",result.getDescription());
		
	}
	
	@Test
	void getByName() {
		CourseEntity course=courseServ.findByName("CSS");
        assertEquals(121,course.getId());
	}
	
	@Test
	void getById() {
		CourseEntity course=courseServ.findById(121);
        assertEquals("CSS",course.getName());
	}
	
	@Test
	void deleteByName() {
		CourseEntity course=courseServ.deleteByName("Cricket");
        assertEquals(104,course.getId());
	}
	
	@Test
	void deleteById() {
		CourseEntity course=courseServ.deleteById(103);
        assertEquals("HTML",course.getName());
	}
	
	@Test
	void getAllCourses() {
		List<CourseEntity> courseList=courseServ.getAllCourses();
		assertEquals(4,courseList.size());
	}
	
}
