package com.studentTranscript.service;

import java.util.List;

import com.studentTranscript.model.StudentCourseDegreeInformation;

public interface StudentTranscriptService {
	
	public List<StudentCourseDegreeInformation> getStudentInformationByExtId(String stuExtId);

}
