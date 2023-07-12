package customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.notice.NoticeDetailController;

public class MyDispatcher extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("http 신호");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();

		String com = uri.substring(conPath.length());
		System.out.println(com);



		Controller controller = null;
		
		try {
			if (com.equals("/customer/noticeDetail.do")) {
				controller=new NoticeDetailController();
			}
			controller.execute(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
