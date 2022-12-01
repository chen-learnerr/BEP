package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.StuInfo;
import dao.StuInfoDao;

/**
 * Servlet implementation class stuInfoFind
 */
@WebServlet("/StuInfoFind")
public class StuInfoFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuInfoFind() {
        super();
        // TODO Auto-generated constructor stub。
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String stu_acct = session.getAttribute("acct").toString();
		StuInfoDao stu_info_dao = new StuInfoDao();
		StuInfo stu_info = null;
		try {
			stu_info = stu_info_dao.dispStuInfo(stu_acct);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("stu_info", stu_info);
		request.getRequestDispatcher("stu_info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

