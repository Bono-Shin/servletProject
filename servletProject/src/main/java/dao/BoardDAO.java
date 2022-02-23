package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DBManager;
import vo.BoardVO;

public class BoardDAO {

	public ArrayList<BoardVO> list() {
		ArrayList<BoardVO> alist = new ArrayList<BoardVO>();
		
		//DB연결
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			String sql = "select * from board";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setSubject(rs.getString("subject"));
				vo.setWriter(rs.getString("writer"));
				vo.setBidx(rs.getInt("bidx"));
				alist.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(psmt, conn, rs);
		}
		return alist;
	}
	
	public BoardVO selectOne(String bidx) {
		BoardVO vo = new BoardVO();
		
		//DB연결
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			String sql = "select * from board where bidx = "+bidx;
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setBidx(rs.getInt("bidx"));
				vo.setWriter(rs.getString("writer"));
				vo.setSubject(rs.getString("subject"));
				vo.setContent(rs.getString("content"));
				vo.setWriteday(rs.getString("writeday"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(psmt, conn, rs);
		}
		return vo;
	}
	
	public int update(BoardVO vo) {
		int result = 0;
		
		//DB연결
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			String sql = "update board set " 
						+ "writer = ?, content = ?, "
						+ "subject = ? "
						+ "where bidx = "+vo.getBidx();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getWriter());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getSubject());
			
			psmt.executeUpdate();
						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(psmt, conn, rs);
		}
		return result;
	}
	
	public void insert(BoardVO vo) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			String sql = "insert into board(BIDX,subject,writer,content,midx,hit) values(BIDX_SEQ.NEXTVAL,?,?,?,27,0)";
						
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getSubject());
			psmt.setString(2, vo.getWriter());
			psmt.setString(3, vo.getContent());
			
			psmt.executeUpdate();
						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(psmt, conn, rs);
		}
	}
	
	public void delete(String bidx) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			String sql = "delete from board where bidx="+bidx;
						
			psmt = conn.prepareStatement(sql);
			
			psmt.executeUpdate();
						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(psmt, conn, rs);
		}
	}
	
	
}
