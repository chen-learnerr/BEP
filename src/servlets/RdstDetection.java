package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AdminLog;
import beans.StuLog;
import dao.AdminLogDao;
import dao.StuLogDao;
import tools.Tools;

/**
 * Servlet implementation class RdstDetection
 */
@WebServlet("/RdstDetection")
public class RdstDetection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RdstDetection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		AdminLogDao admin_log_dao = new AdminLogDao();
		StuLogDao stulogdao = new StuLogDao();
		List<AdminLog> admin_log = null;
		List<StuLog> stu_log = null;
		try {
			admin_log = admin_log_dao.findAllAdminLog();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stu_log = stulogdao.findAllStuLog();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String acct = request.getParameter("rdst_acct");
		String pwd = request.getParameter("rdst_pwd");
		String rpt_pwd = request.getParameter("rpt_pwd");
		String type = request.getParameter("type");
		
		if(admin_log.isEmpty()) {
			System.out.println("xxx");
		}
		if(type.equals("招标方注册")) {
			boolean isFind = false;
			for(int i = 0; i < admin_log.size(); i++) {
				if(acct.equals(admin_log.get(i).getAdmin_acct())) {
					isFind = true;
					out.print("注册失败，用户名重复！");
					break;
				}
			}
			if(!isFind) {
				if(pwd.equals(rpt_pwd)){
					try {
						pwd = Tools.MD5(pwd);
						admin_log_dao.insertAdminLog(acct, pwd);
						out.print("注册成功！");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					out.print("两次输入的密码不一致！");
				}
			}	
		}
		else {		
			boolean isFind = false;
			for(int i = 0; i < stu_log.size(); i++) {
				if(acct.equals(stu_log.get(i).getStu_acct())) {
					isFind = true;
					out.print("注册失败，用户名重复!");
				}
			}
			if(!isFind) {
				if(pwd.equals(rpt_pwd)){
					try {
						pwd = Tools.MD5(pwd);
						stulogdao.insertStuLog(acct, pwd);
						out.print("注册成功！");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else {
					out.print("两次输入的密码不一致！");
				}
			}
		}
	}

}
