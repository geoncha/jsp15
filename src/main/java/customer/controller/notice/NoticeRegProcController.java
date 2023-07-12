package customer.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.Controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeRegProcController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeRegProcController!!!!!!!!!");
		
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		Notice n = new Notice();
		n.setTitle(title);
		n.setContent(content);

		NoticeDao dao = new NoticeDao();
		dao.write(n);
		
		// 목록으로 이동
		response.sendRedirect("notice.jsp");
		
	}

}
