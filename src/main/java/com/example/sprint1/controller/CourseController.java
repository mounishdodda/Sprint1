package com.example.sprint1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprint1.bean.CourseEntity;
import com.example.sprint1.dto.CourseOutputDto;
import com.example.sprint1.service.ICourseService;

@RestController
public class CourseController {

	@Autowired
	ICourseService courseServ;

	// Add Course
	@PostMapping("/addCourse/")
	ResponseEntity<String> add(@RequestBody CourseEntity course) {
		String response = courseServ.add(course);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// Update Course
	@PutMapping("/updateCourse")
	ResponseEntity<CourseEntity> update(@RequestBody CourseEntity course) {
		CourseEntity updatedCourse = courseServ.update(course);
		return new ResponseEntity<>(updatedCourse, HttpStatus.OK); // 200 Ok
	}

	// Update Course Name
	@PutMapping("/updateNameById/{id}")
	ResponseEntity<CourseEntity> updateNameById(@PathVariable("id") long id, @RequestBody String name) {
		CourseEntity updatedCourse = courseServ.updateNameById(id, name);
		return new ResponseEntity<>(updatedCourse, HttpStatus.OK); // 200 Ok
	}

	// Delete Course
	@DeleteMapping("/deleteCourse")
	ResponseEntity<CourseEntity> delete(@RequestBody CourseEntity course) {
		CourseEntity deletedCourse = courseServ.delete(course);
		return new ResponseEntity<>(deletedCourse, HttpStatus.OK); // 200 Ok
	}

	// Get Course By Name
	@GetMapping("/courseByName/{name}")
	ResponseEntity<CourseEntity> findByName(@PathVariable("name") String name) {
		CourseEntity course = courseServ.findByName(name);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	// Get Course By Primary Key
	@GetMapping("/courseById/{id}")
	ResponseEntity<CourseEntity> findById(@PathVariable("id") long id) {
		CourseEntity course = courseServ.findById(id);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@GetMapping("/courses/pagination/{offset}/{pageSize}")
	ResponseEntity<Page<CourseEntity>> getAllCoursesWithPagination(@PathVariable("offset") int offset,
			@PathVariable("pageSize") int pageSize) {
		Page<CourseEntity> courses = courseServ.getAllCoursesWithPagination(offset, pageSize);
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	// Delete Course By Id
	@DeleteMapping("/courseById/{id}")
	ResponseEntity<CourseEntity> deleteById(@PathVariable("id") long id) {
		CourseEntity deletedCourse = courseServ.deleteById(id);
		return new ResponseEntity<>(deletedCourse, HttpStatus.OK); // 200 Ok
	}

	// Delete Course By Name
	@DeleteMapping("/courseByName/{name}")
	ResponseEntity<CourseEntity> deleteByName(@PathVariable("name") String name) {
		CourseEntity deletedCourse = courseServ.deleteByName(name);
		return new ResponseEntity<>(deletedCourse, HttpStatus.OK); // 200 Ok
	}

	// Get All Courses
	@GetMapping("/courses")
	ResponseEntity<List<CourseEntity>> getAllCourses() {
		List<CourseEntity> course = courseServ.getAllCourses();
		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	// Output Dto
	@PostMapping("/addDto")
	ResponseEntity<CourseOutputDto> addDto(@RequestBody CourseEntity course) {
		CourseOutputDto course1 = courseServ.addDto(course);
		return new ResponseEntity<>(course1, HttpStatus.OK);
	}

}
