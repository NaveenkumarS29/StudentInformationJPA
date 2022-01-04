package io.springboot.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllDetails() {
		List<Student> list = new ArrayList<>();
		studentRepository.findAll().forEach(list :: add);
		
		return list;		
	}

	public Student getStudent(String id) {
		return studentRepository.findById(id).orElse(null);
	}

	public String addStudent(Student student) {
		try {
			studentRepository.save(student);
		} catch(Exception e) {
			return "Invalid Entry.....!" + "\n" +"Please Check the Information you have provided";
		}
		return "Student Information Successfully added";
	}

	public String updateStudent(String id, Student student) {
		try {
			studentRepository.save(student);
		} catch(Exception e) {
			return "Invalid Entry.....!" + "\n" +"Please Check the Information you have provided";
		}
		return "Student Information Successfully Updated";
	}
	
	public String deleteStudent (String id) {
		try{
			studentRepository.deleteById(id);
		} catch (Exception e) {
			return "Invalid Entry.....!" + "\n" +"Please Check the Information you have provided";
		}
		return "Successfully Deleted";
	}

	public long countInformation() {
		return studentRepository.count();
	}

}
