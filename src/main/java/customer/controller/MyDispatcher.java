package customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.notice.NoticeController;

public class MyDispatcher extends HttpServlet {
	private Controller controller;
	
	public MyDispatcher() {
		controller=null;
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		String ctxPath=request.getContextPath();
		String com=uri.substring(ctxPath.length());
		
		System.out.println(com);	//	확인용
		
		switch(com) {
		case "/customer/notice.do":
			controller=new NoticeController();
			break;
		case "/customer/noticeReg.do":
			controller=new NoticeController();
			break;
		}
		
		try {
			controller.execute(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
