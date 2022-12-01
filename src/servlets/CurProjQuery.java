package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.IeProg;
import dao.IeProgDao;

/**
 * Servlet implementation class AdminStuInfoQuery
 */
@WebServlet("/CurProjQuery")
public class CurProjQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurProjQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		String name = request.getParameter("proj_name");
		String school = request.getParameter("proj_school");
		String country = request.getParameter("proj_country");
		String stu_num = request.getParameter("stu_num");
		IeProgDao projdao = new IeProgDao();
		List<IeProg> proList = null;
		Date cur_date = new Date();
		System.out.print(cur_date);
		java.sql.Date sd;
		sd = new java.sql.Date(cur_date.getTime());
		try {
			proList = projdao.curProgQuery(sd,name,school,country);
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		request.setAttribute("proinfo_list", proList);
		request.setAttribute("stu_num", stu_num);
		if(request.getParameter("isAdmin") != null) {
			request.getRequestDispatcher("admin_proj_list.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("stu_proj_list.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
