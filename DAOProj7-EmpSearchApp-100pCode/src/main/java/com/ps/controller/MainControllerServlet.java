package com.ps.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ps.config.AppConfig;
import com.ps.service.EmployeeMgmtService;
import com.ps.service.EmployeeMgmtServiceImpl;

@WebServlet("/searchurl")
public class MainControllerServlet extends HttpServlet {
	private ApplicationContext ctx=null;
	
	@Override
	public void init() throws ServletException {
		//create IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
	}
	@Override
	public void destroy() {
		//close container
		((AbstractApplicationContext) ctx).close();
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String[] desgs=null;
		List<Map<String,Object>> listMap=null;
		EmployeeMgmtService service=null;
		RequestDispatcher rd=null;
		
		//get request parameter value
		desgs=req.getParameterValues("job");
		System.out.println(Arrays.deepToString( desgs));
		//get bean of service class
		service=ctx.getBean("empService", EmployeeMgmtServiceImpl.class);
		try {
			listMap=service.fetchEmployeeByDesg(desgs);
			//Keep list object in request scope
			req.setAttribute("listEmps", listMap);
			//forward to result.jsp
			rd=req.getRequestDispatcher("/result_page.jsp");
			rd.forward(req, res);
		}
		catch(Exception e) {
			e.printStackTrace();
			//Keep error message to request scope
			req.setAttribute("errorMsg", e.getMessage());
			//forward to error.jsp
			rd=req.getRequestDispatcher("/error_page.jsp");
			rd.forward(req, res);
		}
					
	}
	
@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
}
