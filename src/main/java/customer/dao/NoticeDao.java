package customer.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import customer.db.DBCon;
import customer.vo.Notice;

public class NoticeDao {

	public List<Notice> noticeSelAll(String field, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	public Notice getNotice(String seq, String hit) throws Exception{
		int hnum=Integer.parseInt(hit);
		hitupdate(seq,hnum);
		
		String sql="select seq,title,writer,content,"
				+ "regdate,hit from notices where seq="+seq;
		

		//dbcon
		Connection con = DBCon.getConnection();

		//실행
		Statement stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		
		Notice n = new Notice();
		n.setSeq(rs.getString("seq"));
		n.setTitle(rs.getString("title"));
		n.setWriter(rs.getString("writer"));
		n.setContent(rs.getString("content"));
		n.setRegdate(rs.getDate("regdate"));
		n.setHit(rs.getInt("hit"));
		
		rs.close(); 
		stmt.close(); 
		con.close();
		 
		return n;
	}

	private void hitupdate(String seq, int hnum) {
		// TODO Auto-generated method stub
		
	}

}
