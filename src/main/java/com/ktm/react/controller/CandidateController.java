package com.ktm.react.controller;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ktm.react.bean.UserBean;
import com.ktm.react.entity.DesignationEntity;
import com.ktm.react.entity.InterviewrRoundEntity;
import com.ktm.react.entity.NcandidateEntity;
import com.ktm.react.dao.CandidateDao;
import com.ktm.react.dao.UserDao;

@RequestMapping("candidate")
@RestController
public class CandidateController {
	    
	@Autowired
	private CandidateDao candidatedao;
	@Autowired
	private UserDao userdao;
	
	@PostMapping("index")
    public int login(HttpServletRequest request, HttpServletResponse response,
    		UserBean user) {	
    	return userdao.loginUser(request, user);
    } 
	
	@GetMapping("addDesignations")
    public List<DesignationEntity> addDesignation(HttpServletRequest request, HttpServletResponse response) {
			   return candidatedao.getaddDesignation();
			
	    
    }
	
    @PostMapping("addCandidates")
    public String setaddCandidates(HttpServletRequest request, HttpServletResponse response
    	) {	
    	NcandidateEntity user=new NcandidateEntity();
    	System.out.println("addcandidates");
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
    	try{
    	System.out.println(request.getPart("ncandidate_designation"));
    	Part part =request.getPart("ncandidate_resume");
    	user.setNcandidate_age(Integer.parseInt(request.getParameter("ncandidate_age")));
    	user.setNcandidate_name(request.getParameter("ncandidate_name"));
    	user.setNcandidate_emailid(request.getParameter("ncandidate_emailid"));
    	user.setNcandidate_designation(request.getParameter("ncandidate_designation"));
    	user.setNcandidate_phoneno(request.getParameter("ncandidate_phoneno"));
    	user.setNcandidate_qualification(request.getParameter("ncandidate_qualification"));
    	user.setNcandidate_address(request.getParameter("ncandidate_address"));
    	user.setCreated_by(Integer.parseInt(request.getParameter("hr_id")));
		user.setCreated_date(date);
		// getting filename
    	String fileName = extractFileName(part);
		System.out.println(fileName);
		File f = new File(fileName);
		// getting savepath
		String savepath = "E:\\react\\hrmanage\\src\\img\\" + f.getName();
		// writing savepath in images folder
		part.write(savepath + File.separator);
		user.setNcandidate_resume(f.getName());
		user.setNcandidate_filepath(savepath);
		System.out.println(user.toString());
    	}catch(Exception e){
    		System.out.println(e);
    	}
    	//System.out.println(user.toString());
    	return candidatedao.setaddCandidates(request, user);
    }  
    
   
    @PostMapping("addDomain")
    public String setaddDesignation(@RequestParam String designation_name,@RequestParam int hr_id,HttpServletRequest request, HttpServletResponse response) {	
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
	    System.out.println("addDesignation");
	    DesignationEntity user=new DesignationEntity();
	    user.setDesignation_name(designation_name);
    	user.setCreated_by(hr_id);
		user.setCreated_date(date);
	    System.out.println(user.toString());
    	return candidatedao.setaddDesignation(request, user);
    }  
    
    @PostMapping("addInterviewrounds")
    public String setaddInterviewrounds(@RequestParam String round_name,@RequestParam int hr_id,HttpServletRequest request, HttpServletResponse response) {	
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateobj = new Date();
	    String date=df.format(dateobj);
	    System.out.println("add Interview round");
	    InterviewrRoundEntity user=new InterviewrRoundEntity();
	    user.setRound_name(round_name);
    	user.setCreated_by(hr_id);
		user.setCreated_date(date);
	    System.out.println(user.toString());
    	return candidatedao.setaddInterviewrounds(request, user);
    }  

    @GetMapping("addInterviewround")
    public List<InterviewrRoundEntity> addInterviewround(HttpServletRequest request, HttpServletResponse response) {
			   return candidatedao.getaddInterviewround();
	}
    
	@GetMapping("viewCandidates")
	public List<NcandidateEntity> viewCandidates(HttpServletRequest request, HttpServletResponse response) {	
		return candidatedao.viewCandidateDetails();
	}
	
	@GetMapping("searchCandidates")
	public List<NcandidateEntity> search(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String search) {
		return candidatedao.searchDetails(search);
	}

	@GetMapping("candidateDetail")
	public NcandidateEntity getCandidateProfile(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
		return candidatedao.getCandidateProfileDetails(candidate_id);				
	}
	
//	@GetMapping("files")
//	public ModelAndView files(@RequestParam int candidate_id,HttpServletRequest request, HttpServletResponse response) {
//	ModelAndView mdv=new ModelAndView();
//	// Check User has logged on
//	HttpSession session = request.getSession();
//	UserEntity loginedUser = Myutils.getLoginedUser(session);
//	
//	if(loginedUser == null){
//		System.out.println("Files Illegal access....");
//		mdv.addObject("errorString", "Please Login...");
//		mdv.setViewName("index");
//	}else{
//		mdv = candidatedao.fileDetails(candidate_id);
//	}
//	return mdv;
//	}
	
	// extarctiting filename from the request header
			private String extractFileName(Part p) {
				// TODO Auto-generated method stub
				System.out.println("its in extractfilename");
				String contnt = p.getHeader("Content-Disposition");
				System.out.println(contnt);
				String[] items = contnt.split(";");
				for (String s : items) {
					
					if (s.trim().startsWith("filename")) {
						return s.substring(s.indexOf("=") + 2, s.length() - 1);
					}
				}
				return "str";
			}

}

