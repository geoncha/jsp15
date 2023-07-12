package customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import customer.db.DBCon;
import customer.vo.Notice;

public class NoticeDao {

	public List<Notice> noticeSelAll(String field, String query) throws Exception {
		Connection con = DBCon.getConnection();
		String sql = "select * from notices where " + field + " like ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + query + "%");
		ResultSet rs = pstmt.executeQuery();
		List<Notice> list = new ArrayList<>();

		while (rs.next()) {
			Notice n = new Notice();

			n.setSeq(rs.getString("seq"));
			n.setTitle(rs.getString("title"));
			n.setWriter(rs.getString("writer"));
			n.setContent(rs.getString("content"));
			n.setRegdate(rs.getDate("regdate"));
			n.setHit(rs.getInt("hit"));

			list.add(n);
		}

		return list;
	}

	public Notice getNotice(String seq, String hit) {
		// TODO Auto-generated method stub
		return null;
	}

}
