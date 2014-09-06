package com.studentTranscript.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.studentTranscript.bean.StudentTranscriptInformationBean;
import com.studentTranscript.bean.StudentTranscriptInformationBeanList;
import com.studentTranscript.model.StudentCourseDegreeInformation;
import com.studentTranscript.service.StudentTranscriptService;



@Controller
public class StudentSearchController {
	
	@Autowired
	private StudentTranscriptService studentTranscriptService;

	
	/**
	 * This method is used to route to the login page
	 * @author ameyavarma
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String welcome(ModelMap model)
	{
		return "login";
	
	}
	
	/**
	 * This mehtod is used for failed login attempts. Error message is displayed in case
	 * of incorrect login and user is rerouted to the login page.
	 * @author ameyavarma
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/loginfailed",  method = RequestMethod.GET)
	public String loginFailed(Model model)
	{
		model.addAttribute("error", "true");
		return "login";
	}

	
	/**
	 * This method handles the view after the user has successfully logged in
	 * It routes user to search for the student
	 * Attribute student information is added
	 * @author ameyavarma
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value="/searchStudent", method=RequestMethod.GET)
	public ModelAndView loginSuccess(Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName( );
		
		StudentTranscriptInformationBean studentInformation=new StudentTranscriptInformationBean();
		
		studentInformation.setUserName(userName);
		
		model.addAttribute("studentInformation", studentInformation);
		
		return new ModelAndView("searchStudent");
	}
		
	
	/**
	 * This method handles requests to render student transcript on a JSP
	 * page.  The username is retreved from spring security.  If the list is 
	 * empty user is rerouted to the search student page.  For successful resuts the user
	 * is routed to the transcript JSP page 
	 * 
	 * @author ameyavarma
	 * @param studentTranscript
	 * @param result
	 * @param studentExternalID
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ModelAndView searchStudentTrsanscript(@ModelAttribute(
			value="studentInformation")StudentTranscriptInformationBean
			studentTranscript,
			BindingResult result,
			@RequestParam("studentExternalID")String studentExternalID,
			HttpSession session)
			{
		
		Authentication auth = 
				SecurityContextHolder.getContext().getAuthentication( );
		String userName = auth.getName();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("studentInformation", prepareTranscriptBean(studentTranscriptService.getStudentInformationByExtId(studentExternalID)
				, userName));
		if(!studentTranscriptService.
				getStudentInformationByExtId(studentExternalID).isEmpty( ))
		{
			return new ModelAndView("studentTranscript", model);
			
		}
		else return new ModelAndView("searchStudent", "studentInformation", studentTranscript );
			
			
			}
	
	
	/**
	 * This method processes the requests to display XML request.
	 * studentTranscriptlist is marshalled by JAXB
	 * 
	 * @author ameyavarma
	 * @param studentTranscript
	 * @param result
	 * @param studentExternalID
	 * @param session
	 * @return
	 */
	
	@RequestMapping(value="/send", produces=MediaType.TEXT_XML_VALUE,
			method=RequestMethod.GET)
	public ModelAndView sendTranscriptXML(@ModelAttribute(
			value="studentInformation")StudentTranscriptInformationBean studentTranscript,
			BindingResult result,
			@RequestParam("studentExternalID")String studentExternalID,
			HttpSession session)
			{
				List<StudentTranscriptInformationBean> studentTranscriptbean = prepareTranscriptBean(studentTranscriptService.getStudentInformationByExtId(studentExternalID), null);
				StudentTranscriptInformationBeanList studentTranscriptList = new StudentTranscriptInformationBeanList(studentTranscriptbean);		
		
				return new ModelAndView("sendTranscript", "studentTranscriptlist", studentTranscriptList);
			}
	

	
	
	/**
	 * This method prepares a list of studentCourseDegreeInformation BEAN 
	 * @param studentCourseDegreeInformation
	 * @param userName
	 * @return
	 */
	private List<StudentTranscriptInformationBean> prepareTranscriptBean(
			List<StudentCourseDegreeInformation> studentCourseDegreeInformation,
			String userName)
			{
		List<StudentTranscriptInformationBean> transcriptbeans=null;
		if(studentCourseDegreeInformation != null &&
				!studentCourseDegreeInformation.isEmpty( ) )
		{
			transcriptbeans = new ArrayList<StudentTranscriptInformationBean>();
			StudentTranscriptInformationBean transcriptBean=null;
			for(StudentCourseDegreeInformation stuinfo : studentCourseDegreeInformation)
			{
				transcriptBean = new StudentTranscriptInformationBean();
				transcriptBean.setCourseName(stuinfo.getCourseName( ) );
				transcriptBean.setDegree(stuinfo.getDegreeName( ) );
				transcriptBean.setDegreeStartYear(stuinfo.getDegreeStartYear( ) );
				transcriptBean.setGrade(stuinfo.getCourseGrade( ));
				transcriptBean.setGraduationYear(stuinfo.getDegreeGraduationYear( ) );
				transcriptBean.setSemester(stuinfo.getCourseSemester( ) );
				transcriptBean.setYear(stuinfo.getCourseYear());
				transcriptBean.setStudentExternalID(stuinfo.getStudentExtID( ) );
				transcriptBean.setStudentFirstName(stuinfo.getFirstName( ) );
				transcriptBean.setStudentLastName(stuinfo.getLastName( ) );
				transcriptBean.setUserName(userName);
				transcriptbeans.add(transcriptBean);
			}
		}
		
		return transcriptbeans;
		}
	
	
	/**
	public StudentTranscriptService getStudentTranscriptService() {
		return studentTranscriptService;
	}

	public void setStudentTranscriptService(
			StudentTranscriptService studentTranscriptService) {
		this.studentTranscriptService = studentTranscriptService;
	}
	*/
	

	
}
