package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.StuInfo;
import dao.StuInfoDao;

/**
 * Servlet implementation class AdminStuInfoQuery
 */
@WebServlet("/AdminStuInfoQuery")
public class AdminStuInfoQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminStuInfoQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		String name = request.getParameter("stu_name");
		String num = request.getParameter("stu_num");
		String grd = request.getParameter("stu_grd");
		StuInfoDao stuinfodao = new StuInfoDao();
		List<StuInfo> stu_info = null;
		try {
			stu_info = stuinfodao.findCondStuInfo(num, name, grd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("stu_list", stu_info);
		request.getRequestDispatcher("admin_stu_info.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
