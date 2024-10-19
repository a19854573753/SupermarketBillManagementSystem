package com.test.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.entity.Bill;
import com.test.entity.Provider;
import com.test.entity.User;
import com.test.service.BillService;
import com.test.service.ProviderService;


public class SelectContBillServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置字符集
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// 获得用户在浏览器中输入的注册信息
		String billId = req.getParameter("billId");

		
		//String userSex = req.getParameter("userSex");
		//String userAge = req.getParameter("userAge");
		//String userTel = req.getParameter("userTel");
		//String userLoc = req.getParameter("userLoc");
		//String userRole = req.getParameter("userRole");
		
		// 将查询条件封装到UserMessage实体类对象中
		//User userMessage = new User();
		//userMessage.setUserId(userId);
		//userMessage.setUserName(userName);
		//userMessage.setUserSex(userSex);
		//userMessage.setUserAge(userAge);
		//userMessage.setUserTel(userTel);
		//userMessage.setUserLoc(userLoc);
		//userMessage.setUserRole(userRole);

		try {
			// 在当前类调用UserMessageService类中名为selectUserMessages()方法，查询满足条件的信息，并获得查询结果
			BillService service = new BillService();
			Bill bill = service.selectContBill(billId);
			//HttpSession session = req.getSession(true);
			
			//session.setAttribute("userId",userId);
			//session.setAttribute("userName",userName);
			//session.setAttribute("userSex",userSex);
			//session.setAttribute("userAge",userAge);
			//session.setAttribute("userTel",userTel);
			//session.setAttribute("userLoc",userLoc);
			//session.setAttribute("userRole",userRole);
			// 将查询结果以List的名字存入request
			req.setAttribute("bill", bill);
			// 跳转到pages/image.jsp页面，显示查询结果
			req.getRequestDispatcher("pages/admin_bill_cont.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect(resp.encodeRedirectURL("/supermarket/error.html"));
		}

	}

}
