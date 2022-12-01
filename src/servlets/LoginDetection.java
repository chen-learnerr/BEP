package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AdminLog;
import beans.StuInfo;
import beans.StuLog;
import dao.AdminLogDao;
import dao.ModProjNotifyDao;
import dao.NewProjInfoDao;
import dao.RevChangeNotifyDao;
import dao.StuInfoDao;
import dao.StuLogDao;
import tools.Tools;

/**
 * Servlet implementation class LoginDetetion
 */
@WebServlet("/LoginDetection")
public class LoginDetection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDetection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//输出内容
		PrintWriter out = response.getWriter();
		
		//新建Dao
		NewProjInfoDao notify_dao = new NewProjInfoDao();
		StuInfoDao stu_info_dao = new StuInfoDao();
		AdminLogDao admin_log_dao = new AdminLogDao();
		ModProjNotifyDao del_proj_info_dao = new ModProjNotifyDao();
		RevChangeNotifyDao rev_notify_dao = new RevChangeNotifyDao();
		
		List<AdminLog> admin_log = null;
		try {
			admin_log = admin_log_dao.findAllAdminLog();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StuLogDao stu_log_dao = new StuLogDao();
		List<StuLog> stu_log = null;
		try {
			stu_log = stu_log_dao.findAllStuLog();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String acct = request.getParameter("login_acct");
		String pwd = request.getParameter("login_pwd");
		pwd = Tools.MD5(pwd);
		String type = request.getParameter("type");

		System.out.println(type);
		if(type.equals("招标方登录")) {
			boolean isFind = false;
			for(int i=0; i<admin_log.size(); i++) {
				if(acct.equals(admin_log.get(i).getAdmin_acct())) {
					isFind = true;
					if(pwd.equals(admin_log.get(i).getAdmin_pwd())) {
						HttpSession session = request.getSession();
						// 手动设置session的有效期为30分钟
						String sessionId = session.getId();
						Cookie cookie = new Cookie("JSESSIONID", sessionId);
						cookie.setMaxAge(60 * 30);
						cookie.setPath(request.getContextPath());
						response.addCookie(cookie);
						// 登录成功后要存入用户的登录状态，key是用户对象的String形式value就是用户对象(model)！！别的页面应该能用到
						session.setAttribute("acct", admin_log.get(i).getAdmin_acct());
						out.print("admin_ok");
						break;
					}
					else {
						out.print("密码不正确");
						break;
					}
				}
			}
			if(!isFind) {
				out.print("用户名不存在");
			}
		}
		else {
			boolean isFind = false;
			for(int i=0; i<stu_log.size(); i++) {
				if(acct.equals(stu_log.get(i).getStu_acct())) {
					isFind = true;
					if(pwd.equals(stu_log.get(i).getStu_pwd())) {
						HttpSession session = request.getSession();
						// 手动设置session的有效期为30分钟
						String sessionId = session.getId();
						Cookie cookie = new Cookie("JSESSIONID", sessionId);
						cookie.setMaxAge(60 * 30);
						cookie.setPath(request.getContextPath());
						response.addCookie(cookie);
						// 登录成功后要存入用户的登录状态，key是用户对象的String形式value就是用户对象(model)！！别的页面应该能用到
						session.setAttribute("acct", stu_log.get(i).getStu_acct());
						StuInfo stu_info = null;
						String stu_num = null;
						try {
							stu_info = stu_info_dao.dispStuInfo(acct);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if(stu_info == null) {
							stu_num = "";
						} else {
							stu_num = stu_info.getStu_num();
						}
						
						List<String> new_notify_list = null;
						List<String> del_notify_list = null;
						List<String> rev_notify_list = null;
						try {
							new_notify_list = notify_dao.findNewProjNotify(stu_num);
							del_notify_list = del_proj_info_dao.findModProjNotify(stu_num);
							rev_notify_list = rev_notify_dao.findRevChangeNotify(stu_num);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						session.setAttribute("new_proj_notify", new_notify_list);
						session.setAttribute("del_notify_list", del_notify_list);
						session.setAttribute("rev_notify_list", rev_notify_list);
						out.print("stu_ok");
						break;
					}
					else {
						out.print("密码不正确");
						break;
					}
				}
			}
			if(!isFind) {
				out.print("用户名不存在");
			}
		}
	}

}
