package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController {
	/*public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String passwd = "";
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");

		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		mav.setViewName("result");
		return mav;
	}*/
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String passwd = "";
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");
		String viewName=getViewName(request);
		
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		//mav.setViewName("result");
		mav.setViewName(viewName);
		System.out.println("---------------------");
	    System.out.println("ViewName:"+viewName);
	    System.out.println("---------------------");
		return mav;
	}
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		System.out.println("---------------------");
	    System.out.println("ViewName:"+viewName);
	    System.out.println("---------------------");
		return new ModelAndView(viewName);

	}

	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
	    ModelAndView mav=new ModelAndView();
	    String id=request.getParameter("id");
	    String pwd=request.getParameter("pwd");
	    String name=request.getParameter("name");
	    String email=request.getParameter("email");
	    String viewName=getViewName(request);

	    mav.addObject("id",id);
	    mav.addObject("pwd",pwd);
	    mav.addObject("name",name);
	    mav.addObject("email",email);
		mav.setViewName(viewName);
		System.out.println("---------------------");
	    System.out.println("ViewName:"+viewName);
	    System.out.println("---------------------");
	    return mav;
	}
	
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName=getViewName(request);
		System.out.println("---------------------");
	    System.out.println("ViewName:"+viewName);
	    System.out.println("---------------------");
		return new ModelAndView(viewName);
	}
	

    private  String getViewName(HttpServletRequest request) throws Exception {
        // request 객체에서 URL요청명을 가져와 .do를 제외한 요청을 구한다.
       String contextPath = request.getContextPath();
       System.out.println("contexPath : " + contextPath);
        
       
       String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
       System.out.println("uri : " + uri);        
       
       
       if(uri == null || uri.trim().equals("")) {
           uri = request.getRequestURI();
        }

       System.out.println("uri : " + uri);   
       
       int begin = 0;
       if(!((contextPath==null)||("".equals(contextPath)))){
            begin = contextPath.length();
           System.out.println("begin : " + begin);   
        }

       int end;
       if(uri.indexOf(";")!=-1){
           end=uri.indexOf(";");
        }else if(uri.indexOf("?")!=-1){
           end=uri.indexOf("?");
        }else{
           end=uri.length();
        }
       
        System.out.println("end : " + end);   


        String fileName=uri.substring(begin,end);
        if(fileName.indexOf(".")!=-1){
           fileName=fileName.substring(0,fileName.lastIndexOf("."));
        }
        if(fileName.lastIndexOf("/")!=-1){
           fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length());
        }
        
          System.out.println("fileName : " + fileName);   
          return fileName;
        }

	
}
