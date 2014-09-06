package com.studentTranscript.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentTranscript.model.StudentCourseDegreeInformation;

@Repository("studentCourseDegreeDAO")
public class StudentCourseDegreeDAOImpl implements StudentCourseDegreeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	*/

	@Override
	public List<StudentCourseDegreeInformation> getStudentCourseDegreeInformation(
			String studentExternalId) {
		
		Session session = sessionFactory.openSession( );
		Query query = session.getNamedQuery("findByStudentTranscriptExtIdhql");
		query.setParameter("studentExtID", studentExternalId);
		
		List<StudentCourseDegreeInformation> studentCourseDegreeInformation =
				query.list( );
		
		
		return studentCourseDegreeInformation;
	}

}
