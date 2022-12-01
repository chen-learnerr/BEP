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
@WebServlet("/HistProjQuery")
public class HistProjQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistProjQuery() {
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
		IeProgDao projdao = new IeProgDao();
		List<IeProg> hisproj_info = null;
		Date cur_date = new Date();
		java.sql.Date sd;
		sd = new java.sql.Date(cur_date.getTime());
		try {
			hisproj_info = projdao.histProgQuery(sd,name,school,country);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("historypro_list", hisproj_info);
		if(request.getParameter("isAdmin") != null) {
			request.getRequestDispatcher("admin_history.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("stu_history.jsp").forward(request, response);
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
