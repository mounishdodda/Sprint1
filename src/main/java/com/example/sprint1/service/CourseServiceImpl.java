package com.example.sprint1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.sprint1.bean.CourseEntity;
import com.example.sprint1.dto.CourseOutputDto;
import com.example.sprint1.exception.CourseNotFoundException;
import com.example.sprint1.exception.DuplicateRecordException;
import com.example.sprint1.repository.ICourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	ICourseRepository courseRepo;

	// Add Course
	@Override
	public String add(CourseEntity course) {
		Optional<CourseEntity> opt = courseRepo.findById(course.getId());
		if (opt.isPresent()) {
			throw new DuplicateRecordException("Duplicate Record Entered with id->" + course.getId());
		} else {
			courseRepo.save(course);
			return "Course Added Successfully";
		}
	}

	// Update Course
	@Override
	public CourseEntity update(CourseEntity course) {
		Optional<CourseEntity> opt = courseRepo.findById(course.getId());
		if (!opt.isPresent()) {
			throw new CourseNotFoundException("Could not find the Course with id->" + course.getId());
		} else {
			courseRepo.save(course);
			return course;
		}
	}

	// Delete Course
	@Override
	public CourseEntity delete(CourseEntity course) {
		Optional<CourseEntity> opt = courseRepo.findById(course.getId());
		if (!opt.isPresent()) {
			throw new CourseNotFoundException("Could not find the Course with id->" + course.getId());
		} else {
			courseRepo.delete(course);
			return course;
		}
	}

	// Find Course By Name
	@Override
	public CourseEntity findByName(String name) {
		CourseEntity course = courseRepo.findByName(name);
		if (course != null) {
			return course;
		} else {
			throw new CourseNotFoundException("Could not find the Course with name->" + name);
		}
	}

	// Find Course By Id
	@Override
	public CourseEntity findById(long id) {

		Optional<CourseEntity> opt = courseRepo.findById(id);
		if (!opt.isPresent()) {
			throw new CourseNotFoundException("Could not find the Course with id->" + id);
		} else {
			return opt.get();
		}
	}

	// Delete Course By Id
	@Override
	public CourseEntity deleteById(long id) {
		Optional<CourseEntity> opt = courseRepo.findById(id);
		if (!opt.isPresent()) {
			throw new CourseNotFoundException("Could not find the Course with id->" + id);
		}
		courseRepo.deleteById(id);
		return opt.get();
	}

	// Delete Course By Name
	@Override
	public CourseEntity deleteByName(String name) {
		CourseEntity course = courseRepo.findByName(name);
		if (course != null) {
			courseRepo.delete(course);
			return course;
		} else {
			throw new CourseNotFoundException("Could not find the Course with name->" + name);
		}
	}

	// Get All Courses
	@Override
	public List<CourseEntity> getAllCourses() {
		List<CourseEntity> courseList = courseRepo.findAll();
		return courseList;
	}

	// Update Course Name By Id
	@Override
	public CourseEntity updateNameById(long id, String name) {
		Optional<CourseEntity> opt = courseRepo.findById(id);
		if (!opt.isPresent()) {
			throw new CourseNotFoundException("Could not find the Course with id->" + id);
		}
		CourseEntity course = opt.get();
		course.setName(name);
		courseRepo.save(course);
		return course;

	}

	// Add Course Dto
	@Override
	public CourseOutputDto addDto(CourseEntity course) {

		Optional<CourseEntity> c1 = courseRepo.findById(course.getId());

		if (c1.isPresent()) {
			throw new DuplicateRecordException("Duplicate Record Entered with id->" + course.getId());
		} else {

			CourseEntity c2 = courseRepo.save(course);
			CourseOutputDto res = new CourseOutputDto();
			res.setName(c2.getName());
			return res;

		}

	}
	
	public Page<CourseEntity> getAllCoursesWithPagination(int offset, int pageSize) {
		Page<CourseEntity> courses = courseRepo.findAll(PageRequest.of(offset, pageSize));
		return courses;
	}
}