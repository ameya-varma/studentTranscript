package com.studentTranscript.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


/**
 *-- CREATE STUDENT_COURSE_INFORMATION
CREATE TABLE STUDENT_COURSE_DEGREE_INFORMATION 
   ( 
            STUDENT_COURSE_DEGREE_ID BIGINT NOT NULL AUTO_INCREMENT, 
            STUDENT_EXT_ID VARCHAR(50) NOT NULL,
			STUDENT_FIRST_NAME VARCHAR(50) NOT NULL,
			STUDENT_LAST_NAME VARCHAR(50) NOT NULL,
			COURSE_GRADE VARCHAR (1),
			COURSE_NAME VARCHAR(128) NOT NULL,
			DEGREE_NAME VARCHAR(128) NOT NULL,
            COURSE_SEMESTER VARCHAR (10) NOT NULL,
            COURSE_YEAR YEAR (4),
            DEGREE_START_YEAR YEAR (4) NOT NULL,
			DEGREE_GRADUATION_YEAR YEAR(4),
            PRIMARY KEY (STUDENT_COURSE_DEGREE_ID)
 * This class is mapped to the above table in the database.  
 * Look up individual annotations for more details.  Named query is a custom created query
 *
 * * @author ameyavarma
 *
 */
@NamedQueries({@NamedQuery(
		name="findByStudentTranscriptExtIdhql",
		query = "from StudentCourseDegreeInformation si where si.studentExtID = :studentExtID"
				+ " order by si.studentCourseDegreeId")})


@Entity
@Table(name="STUDENT_COURSE_DEGREE_INFORMATION", uniqueConstraints={
        @UniqueConstraint(columnNames = "STUDENT_COURSE_DEGREE_ID") })
public class StudentCourseDegreeInformation implements Serializable {
	
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STUDENT_COURSE_DEGREE_ID", unique=true, nullable=false)
	private Long studentCourseDegreeId;
	
	@Column(name="STUDENT_EXT_ID", nullable=false)
	private String studentExtID;
	
	@Column(name="STUDENT_FIRST_NAME", nullable=false)
	private String firstName;
	
	@Column(name="STUDENT_LAST_NAME", nullable=false)
	private String lastName;
	
	@Column(name="COURSE_GRADE")
	private String courseGrade;
	
	@Column(name="COURSE_NAME", nullable=false)
	private String courseName;
	
	@Column(name="DEGREE_NAME", nullable=false)
	private String degreeName;
	
	@Column(name="COURSE_SEMESTER", nullable=false)
	private String courseSemester;
	
	@Column(name="COURSE_YEAR", nullable=false)
	private String courseYear;
	
	@Column(name="DEGREE_START_YEAR", nullable=false)
	private String degreeStartYear;
	
	@Column(name="DEGREE_GRADUATION_YEAR")
	private String degreeGraduationYear;

	public Long getStudentCourseDegreeId() {
		return studentCourseDegreeId;
	}

	public void setStudentCourseDegreeId(Long studentCourseDegreeId) {
		this.studentCourseDegreeId = studentCourseDegreeId;
	}

	public String getStudentExtID() {
		return studentExtID;
	}

	public void setStudentExtID(String studentExtID) {
		this.studentExtID = studentExtID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public String getCourseSemester() {
		return courseSemester;
	}

	public void setCourseSemester(String courseSemester) {
		this.courseSemester = courseSemester;
	}

	public String getCourseYear() {
		return courseYear;
	}

	public void setCourseYear(String courseYear) {
		this.courseYear = courseYear;
	}

	public String getDegreeStartYear() {
		return degreeStartYear;
	}

	public void setDegreeStartYear(String degreeStartYear) {
		this.degreeStartYear = degreeStartYear;
	}

	public String getDegreeGraduationYear() {
		return degreeGraduationYear;
	}

	public void setDegreeGraduationYear(String degreeGraduationYear) {
		this.degreeGraduationYear = degreeGraduationYear;
	}

	

}
