package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.StuInfo;
import dao.StuInfoDao;

/**
 * Servlet implementation class AdminStuInfoDtl
 */
@WebServlet("/AdminStuInfoDtl")
public class AdminStuInfoDtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminStuInfoDtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String stu_num = request.getParameter("stu_num");
		System.out.println(stu_num);
		StuInfoDao stuinfodao = new StuInfoDao();
		StuInfo stu_info = null;
		try {
			stu_info = stuinfodao.dispStuDetail(stu_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("stu_list", stu_info);
		request.getRequestDispatcher("admin_stu_info_dtl.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}