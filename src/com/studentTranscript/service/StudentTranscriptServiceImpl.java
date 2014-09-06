package com.studentTranscript.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.studentTranscript.dao.StudentCourseDegreeDAO;
import com.studentTranscript.model.StudentCourseDegreeInformation;

@Service("studentTranscriptService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class StudentTranscriptServiceImpl implements StudentTranscriptService {

	@Override
	public List<StudentCourseDegreeInformation> getStudentInformationByExtId(
			String stuExtId) 
	{
		return studentCourseDegreeDAO.getStudentCourseDegreeInformation(stuExtId);
	}
	
	@Autowired
	private StudentCourseDegreeDAO studentCourseDegreeDAO;

	/**
	public StudentCourseDegreeDAO getStudentCourseDegreeDAO() {
		return studentCourseDegreeDAO;
	}

	public void setStudentCourseDegreeDAO(
			StudentCourseDegreeDAO studentCourseDegreeDAO) {
		this.studentCourseDegreeDAO = studentCourseDegreeDAO;
	}
	*/
	
	

}
