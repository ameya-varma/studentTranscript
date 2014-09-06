package com.studentTranscript.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class is used as a wrapper class for the studentTranscriptInforamtionBean class
 * 
 * @author ameyavarma
 *
 */

@XmlRootElement(name="studentTranscriptList")
public class StudentTranscriptInformationBeanList {
	
	private int count;
	private List<StudentTranscriptInformationBean> studentTranscriptInformationList;
	
	public StudentTranscriptInformationBeanList()
	{
		
	}
	public StudentTranscriptInformationBeanList(
			List<StudentTranscriptInformationBean> studentTranscriptInformationList)
			{
		this.studentTranscriptInformationList=studentTranscriptInformationList;
		this.count=studentTranscriptInformationList.size();
		
			}
	//getters and setters
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<StudentTranscriptInformationBean> getStudentTranscriptInformationList() {
		return studentTranscriptInformationList;
	}
	@XmlElement(name="studentTranscript")
	public void setStudentTranscriptInformationList(
			List<StudentTranscriptInformationBean> studentTranscriptInformationList) {
		this.studentTranscriptInformationList = studentTranscriptInformationList;
	}


}
