package customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;

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

	public Notice getNotice(String seq, String hit) throws Exception {
		int hnum = Integer.parseInt(hit);
		hitupdate(seq, hnum);

		String sql = "select seq,title,writer,content," + "regdate,hit from notices where seq=" + seq;

		// dbcon
		Connection con = DBCon.getConnection();

		// 실행
		Statement stmt = con.createStatement();
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

	public Notice getNotice(String seq) throws Exception {
		String sql = "select seq,title,writer,content," + "regdate,hit from notices where seq=" + seq;

		// dbcon
		Connection con = DBCon.getConnection();

		// 실행
		Statement stmt = con.createStatement();
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

	public void update(Notice notice) throws Exception {
		String sql = "update notices " + "set title=?,content=? where seq=?";

		// dbcon
		Connection con = DBCon.getConnection();

		// 실행
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, notice.getTitle());
		pstmt.setString(2, notice.getContent());
		pstmt.setString(3, notice.getSeq());
		pstmt.executeUpdate();

		pstmt.close();
		con.close();

	}

	public void write(Notice n) throws Exception {
		String sql = "insert into notices values(" + "(select max(to_number(seq))+1 from notices)"
				+ ",?,'cj',?,sysdate,0)";

		// dbcon
		Connection con = DBCon.getConnection();

		// 실행
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, n.getTitle());
		pstmt.setString(2, n.getContent());
		pstmt.executeUpdate();

		pstmt.close();
		con.close();

	}

	public int delete(String seq) throws Exception {
		String sql = "delete from notices where seq=" + seq;

		// dbcon
		Connection con = DBCon.getConnection();

		// 실행
		PreparedStatement pstmt = con.prepareStatement(sql);
		int del = pstmt.executeUpdate();

		return del;
	}

}
