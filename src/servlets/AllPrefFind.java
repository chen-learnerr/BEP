package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.StuInfo;
import beans.StuPref;
import dao.StuInfoDao;
import dao.StuPrefDao;

/**
 * Servlet implementation class AllPrefFind
 */
@WebServlet("/AllPrefFind")
public class AllPrefFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllPrefFind() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		StuInfoDao stu_info_dao = new StuInfoDao();
		HttpSession session = request.getSession(true);
		String stu_acct = session.getAttribute("acct").toString();
		StuInfo stu_info = null;
		try {
			stu_info = stu_info_dao.dispStuInfo(stu_acct);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(stu_info == null) {
			request.getRequestDispatcher("stu_pref_error.jsp").forward(request, response);
		}
		else {
			StuPrefDao stu_pref_dao = new StuPrefDao();
			List<StuPref> stuPreflist = null;
			try {
				stuPreflist = stu_pref_dao.findAllStuPref(stu_info.getStu_num());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("stuPreflist", stuPreflist);
			request.getRequestDispatcher("stu_personal_pref.jsp").forward(request, response);
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
