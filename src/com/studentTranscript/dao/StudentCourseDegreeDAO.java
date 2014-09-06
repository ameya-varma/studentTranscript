package com.studentTranscript.dao;

import java.util.List;

import com.studentTranscript.model.StudentCourseDegreeInformation;


public interface StudentCourseDegreeDAO {
	
	public List<StudentCourseDegreeInformation> getStudentCourseDegreeInformation(
			String studentExternalId);

}
