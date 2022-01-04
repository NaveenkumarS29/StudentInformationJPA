package io.springboot.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/hello/{id}")
	public String hello(@PathVariable String id) {
		return id;
	}

	@RequestMapping("/getStudentInfo")
	public List<Student> getList() {

		return studentService.getAllDetails();
	}

	@RequestMapping("/getStudentInfo/{id}")
	public Student getInfo(@PathVariable String id) {
		return studentService.getStudent(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addStudentInfo")
	public String addStudentDetail(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateStudentInfo/{id}")
	public String updateStudentDeatil(@PathVariable String id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteStudentInfo/{id}")
	public String deleteStudentDetail(@PathVariable String id) {
		return studentService.deleteStudent(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/countStudentInfo")
	public long countStudentDetail() {
		return studentService.countInformation();
	}

}
