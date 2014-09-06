package com.studentTranscript.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * This Class holds the student transcript information. 
 * @XML notation specifies which elements will be used by JAXB to create the XML file
 * @author ameyavarma
 *
 */
@XmlRootElement(name="transcript")
public class StudentTranscriptInformationBean {
	
	//Instance Variables
	private String studentFirstName;
	private String studentLastName;
	private String degree;
	private String studentExternalID;
	private String semester;
	private String year;
	private String courseName;
	private String grade;
	private String degreeStartYear;
	private String graduationYear;
	private String senderId;
	private String userName;
	public String getStudentFirstName() {
		return studentFirstName;
	}
	@XmlElement
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	@XmlElement
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	public String getDegree() {
		return degree;
	}
	@XmlElement
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getStudentExternalID() {
		return studentExternalID;
	}
	@XmlElement
	public void setStudentExternalID(String studentExternalID) {
		this.studentExternalID = studentExternalID;
	}
	public String getSemester() {
		return semester;
	}
	@XmlElement
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getYear() {
		return year;
	}
	@XmlElement
	public void setYear(String year) {
		this.year = year;
	}
	public String getCourseName() {
		return courseName;
	}
	@XmlElement
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getGrade() {
		return grade;
	}
	@XmlElement
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDegreeStartYear() {
		return degreeStartYear;
	}
	@XmlElement
	public void setDegreeStartYear(String degreeStartYear) {
		this.degreeStartYear = degreeStartYear;
	}
	public String getGraduationYear() {
		return graduationYear;
	}
	@XmlElement
	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	

}
