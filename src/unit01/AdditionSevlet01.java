package unit01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unit01.dao.TitleDaoImpl;
import unit01.dto.Title;

/**
 * Servlet implementation class AdditionSevlet01
 */
@WebServlet("/AdditionSevlet01")
public class AdditionSevlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TitleDaoImpl dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = TitleDaoImpl.getInstance();
	}
	
	
    public AdditionSevlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int num1 = Integer.parseInt(request.getParameter("num1"));
//		int num2 = Integer.parseInt(request.getParameter("num2"));
//		int add = num1 + num2;
//		int no = Integer.parseInt(request.getParameter("no"));
//		String name = request.getParameter("name");
//		Title newTitle = new Title(no, name);
		
//		dao.insertTitle(newTitle);
//		for(Title t : dao.selectTitleByAll()) {
//			System.out.println(t);
//		}
		
//		
//		List<Title> list = TitleDaoImpl.getInstance().selectTitleByAll();
//		list.stream().forEach(System.out::println);
		
		
		List<Title> list = dao.selectTitleByAll();
		for(Title t : list) {
			System.out.println(t);
		}
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int add = num1 + num2;
		
		request.setAttribute("num1",  num1);
		request.setAttribute("num2",  num2);
		request.setAttribute("add",  add);
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
		dispatcher.forward(request, response);
//		response.getWriter()
//		.append("<html> 한글 입니다. <br>")
//		
//		.append("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
