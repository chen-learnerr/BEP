package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.IeProg;
import dao.IeProgDao;

/**
 * Servlet implementation class AdminStuInfoDtl
 */
@WebServlet("/ProjInfoDtl")
public class ProjInfoDtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjInfoDtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int proj_no = Integer.parseInt(request.getParameter("proj_no"));
		System.out.println(proj_no);
		IeProgDao projinfodao = new IeProgDao();
		IeProg proj_info = null;
		try {
			proj_info =  projinfodao.dispProjDetail(proj_no);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("proinfo_list", proj_info);
		request.getRequestDispatcher("admin_proj_info_dtl.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}