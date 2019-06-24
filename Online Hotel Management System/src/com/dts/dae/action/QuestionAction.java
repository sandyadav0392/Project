package com.dts.dae.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.dae.dao.ProfileDAO;
import com.dts.dae.model.Profile;

public class QuestionAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
String target="AddQuestionBase.jsp?status=Invalid";
	try{	

       String qdesc=request.getParameter("qbase");
		Profile aprofile =new Profile();
         aprofile.setSecretqans(qdesc);
         boolean flag=new ProfileDAO().addquestion(aprofile);
		if(flag)
			target="AddQuestionBase.jsp?status=Add Question Base Is Successful";	
		else
			target="AddQuestionBase.jsp?status=Add Question Base Is Fail";	
	}catch(Exception e){e.printStackTrace();}      
    RequestDispatcher rd = request.getRequestDispatcher(target);
    rd.forward(request,response);
	
	}

}
