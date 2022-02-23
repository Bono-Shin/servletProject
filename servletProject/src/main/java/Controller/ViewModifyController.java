package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import vo.BoardVO;

/**
 * Servlet implementation class ViewModifyController
 */
@WebServlet("/viewModify.do")
public class ViewModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String bidx = request.getParameter("bidx");
		
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = boardDAO.selectOne(bidx);
	
		request.setAttribute("vo", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/viewModify.jsp");
	
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		System.out.println("수정페이지에서 post로 들어옴");
		
		request.setCharacterEncoding("UTF-8");
		
		BoardVO vo = new BoardVO();
		
		vo.setBidx(Integer.parseInt(request.getParameter("bidx")));
		
		vo.setWriter(request.getParameter("writer"));
		vo.setContent(request.getParameter("content"));
		vo.setSubject(request.getParameter("subject"));
		
		System.out.println(vo.getBidx());
		
		BoardDAO boardDAO = new BoardDAO();
		int result = boardDAO.update(vo);
		
		response.sendRedirect(request.getContextPath()+"/view.do?bidx="+vo.getBidx());
		
		/*
		String bidx = request.getParameter("bidx");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String subject = request.getParameter("subject");
		
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO vo = boardDAO.update(bidx,writer,content,subject);
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view.do");
		
		rd.forward(request, response);
		*/
	}

}
