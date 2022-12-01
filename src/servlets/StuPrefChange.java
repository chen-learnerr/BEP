package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StuInfoDao;
import dao.StuPrefDao;

/**
 * Servlet implementation class StuPrefChange
 */
@WebServlet("/StuPrefChange")
public class StuPrefChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuPrefChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应和请求编码
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		StuInfoDao stu_info_dao = new StuInfoDao();
		List<String> typeList = new ArrayList<String>();
		List<String> nameList = new ArrayList<String>();
		
		//获取信息
		int pref_num = Integer.parseInt(request.getParameter("pref_num"));
		for(int i = 0; i < pref_num; i++) {
			typeList.add(request.getParameter("pref"+i+"type"));
			nameList.add(request.getParameter("pref"+i+"name"));
		}
		
		StuPrefDao stu_pref_dao = new StuPrefDao();
		HttpSession session = request.getSession(true);
		String stu_acct = session.getAttribute("acct").toString();
		String stu_num = null;
		try {
			stu_num = stu_info_dao.dispStuInfo(stu_acct).getStu_num();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stu_pref_dao.delStuPref(stu_num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < pref_num; i++) {
			try {
				stu_pref_dao.insertStuPref(stu_num, typeList.get(i), nameList.get(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		out.print("更新成功");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
