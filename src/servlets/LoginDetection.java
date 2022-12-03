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

import beans.TenderLog;
import beans.BidderInfo;
import beans.BidderLog;
import dao.TenderLogDao;
import dao.ModProjNotifyDao;
import dao.NewProjInfoDao;
import dao.RevChangeNotifyDao;
import dao.BidderInfoDao;
import dao.BidderLogDao;
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
		BidderInfoDao bidder_info_dao = new BidderInfoDao();
		TenderLogDao tender_log_dao = new TenderLogDao();
		ModProjNotifyDao del_proj_info_dao = new ModProjNotifyDao();
		RevChangeNotifyDao rev_notify_dao = new RevChangeNotifyDao();
		
		List<TenderLog> tender_log = null;
		try {
			tender_log = tender_log_dao.findAllTenderLog();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BidderLogDao bidder_log_dao = new BidderLogDao();
		List<BidderLog> bidder_log = null;
		try {
			bidder_log = bidder_log_dao.findAllBidderLog();
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
			for(int i=0; i<tender_log.size(); i++) {
				if(acct.equals(tender_log.get(i).getTender_acct())) {
					isFind = true;
					if(pwd.equals(tender_log.get(i).getTender_pwd())) {
						HttpSession session = request.getSession();
						// 手动设置session的有效期为30分钟
						String sessionId = session.getId();
						Cookie cookie = new Cookie("JSESSIONID", sessionId);
						cookie.setMaxAge(60 * 30);
						cookie.setPath(request.getContextPath());
						response.addCookie(cookie);
						// 登录成功后要存入用户的登录状态，key是用户对象的String形式value就是用户对象(model)！！别的页面应该能用到
						session.setAttribute("acct", tender_log.get(i).getTender_acct());
						out.print("tender_ok");
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
			for(int i=0; i<bidder_log.size(); i++) {
				if(acct.equals(bidder_log.get(i).getBidder_acct())) {
					isFind = true;
					if(pwd.equals(bidder_log.get(i).getBidder_pwd())) {
						HttpSession session = request.getSession();
						// 手动设置session的有效期为30分钟
						String sessionId = session.getId();
						Cookie cookie = new Cookie("JSESSIONID", sessionId);
						cookie.setMaxAge(60 * 30);
						cookie.setPath(request.getContextPath());
						response.addCookie(cookie);
						// 登录成功后要存入用户的登录状态，key是用户对象的String形式value就是用户对象(model)！！别的页面应该能用到
						session.setAttribute("acct", bidder_log.get(i).getBidder_acct());
						BidderInfo bidder_info = null;
						String bidder_num = null;
						try {
							bidder_info = bidder_info_dao.dispBidderInfo(acct);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if(bidder_info == null) {
							bidder_num = "";
						} else {
							bidder_num = bidder_info.getBidder_num();
						}
						
						List<String> new_notify_list = null;
						List<String> del_notify_list = null;
						List<String> rev_notify_list = null;
						try {
							new_notify_list = notify_dao.findNewProjNotify(bidder_num);
							del_notify_list = del_proj_info_dao.findModProjNotify(bidder_num);
							rev_notify_list = rev_notify_dao.findRevChangeNotify(bidder_num);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						session.setAttribute("new_proj_notify", new_notify_list);
						session.setAttribute("del_notify_list", del_notify_list);
						session.setAttribute("rev_notify_list", rev_notify_list);
						out.print("bidder_ok");
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
