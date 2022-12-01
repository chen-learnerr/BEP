package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StuInfoDao;

/**
 * Servlet implementation class StuInfoChange
 */
@WebServlet("/StuInfoChange")
public class StuInfoChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuInfoChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 编码
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// 输出
		PrintWriter out = response.getWriter();
		
		// 获取acct
		HttpSession session = request.getSession(true);
		String stu_acct=session.getAttribute("acct").toString();
		
		// 获取参数
		String stunum=request.getParameter("stu_num");
		String stuname=request.getParameter("stu_name");
		String stumajor=request.getParameter("stu_major");
		String stuid=request.getParameter("stu_id");
		String stunation=request.getParameter("stu_nation");
		String stupol=request.getParameter("stu_pol");
		String stuemail=request.getParameter("stu_email");
		String stusex=request.getParameter("stu_sex");
		String stugrade=request.getParameter("stu_grade");
		String stucall=request.getParameter("stu_call");
		String stuyear=request.getParameter("stu_year");
		String stubirth=request.getParameter("stu_birth");
		
		//新建Dao
		StuInfoDao stu_info_dao = new StuInfoDao();
		
		try  {
			if(stu_info_dao.dispStuInfo(stu_acct) != null) {
				stu_info_dao.updateInfo(stunum,stu_acct,stuname,stuid,stusex,stupol,stumajor,stucall,stuemail,stunation,stugrade,stubirth,stuyear);
				out.print("ok");
			}
			else {
				if(stunum.isEmpty()) {
					out.print("请输入执照编号");
				}
				else {
					try {
						stu_info_dao.insertStuInfo(stunum,stu_acct,stuname,stuid,stusex,stupol,stumajor,stucall,stuemail,stunation,stugrade,stubirth,stuyear);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					out.print("ok");
				}
			}
		} 
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
