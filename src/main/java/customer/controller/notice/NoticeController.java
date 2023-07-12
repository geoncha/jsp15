package customer.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.Controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeController!!!!!!!!!!");
		//search
		String field=request.getParameter("f");
		if (field==null || field.equals("")) {
			field="title";
		}
		//검색창에 작성한게 저장됨
		System.out.println("field : "+field);
		String query=request.getParameter("q");
		if (query==null) {
			query="";
		}
		System.out.println("query : "+query);
		
		
		
		
		NoticeDao dao=new NoticeDao();
		List<Notice> list=dao.noticeSelAll(field,query); //모든 데이터 셀렉트
		
		
		
		//forward처리 
		//List<Notice> 를  requset에 저장 ""안에있는 list로 저장하는것 그냥 list는 value값임
		request.setAttribute("list", list);
		request.setAttribute("query", query);
		request.getRequestDispatcher("notice.jsp").forward(request, response);
		
		
	}
	
}
	

