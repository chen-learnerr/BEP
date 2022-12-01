package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AdminLog;
import beans.StuLog;
import dao.AdminLogDao;
import dao.StuLogDao;
import tools.Tools;

/**
 * Servlet implementation class PwdChange
 */
@WebServlet("/PwdChange")
public class PwdChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String orig_pwd = request.getParameter("orig_pwd");
		orig_pwd = Tools.MD5(orig_pwd);
		String new_pwd = request.getParameter("new_pwd");
		String rpt_new_pwd = request.getParameter("rpt_new_pwd");
		String type = request.getParameter("type");
		HttpSession session = request.getSession(true);
		String acct = session.getAttribute("acct").toString();
		
		if(type.equals("stu")) {
			StuLogDao stu_log_dao = new StuLogDao();
			StuLog stu_log = null;
			try {
				stu_log = stu_log_dao.findStuLog(acct);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(orig_pwd.equals(stu_log.getStu_pwd())) {
				if(new_pwd.equals(rpt_new_pwd)) {
					try {
						new_pwd = Tools.MD5(new_pwd);
						stu_log_dao.updateAdminPwd(acct, new_pwd);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					out.print("密码修改成功！");
				}
				else {
					out.print("两次输入的密码不同！");
				}
			}
			else {
				out.print("原密码错误！");
			}
		}
		else {
			AdminLogDao admin_log_dao = new AdminLogDao();
			AdminLog admin_log = null;
			try {
				admin_log = admin_log_dao.findAdminLog(acct);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(orig_pwd.equals(admin_log.getAdmin_pwd())) {
				if(new_pwd.equals(rpt_new_pwd)) {
					try {
						new_pwd = Tools.MD5(new_pwd);
						admin_log_dao.updateAdminPwd(acct, new_pwd);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					out.print("密码修改成功！");
				}
				else {
					out.print("两次输入的密码不同！");
				}
			}
			else {
				out.print("两次输入的密码不同！");
			}
		}
	}
}
