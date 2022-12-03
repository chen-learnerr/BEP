package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.TenderLog;
import beans.BidderLog;
import dao.TenderLogDao;
import dao.BidderLogDao;
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
		
		if(type.equals("bidder")) {
			BidderLogDao bidder_log_dao = new BidderLogDao();
			BidderLog bidder_log = null;
			try {
				bidder_log = bidder_log_dao.findBidderLog(acct);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(orig_pwd.equals(bidder_log.getBidder_pwd())) {
				if(new_pwd.equals(rpt_new_pwd)) {
					try {
						new_pwd = Tools.MD5(new_pwd);
						bidder_log_dao.updateTenderPwd(acct, new_pwd);
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
			TenderLogDao tender_log_dao = new TenderLogDao();
			TenderLog tender_log = null;
			try {
				tender_log = tender_log_dao.findTenderLog(acct);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(orig_pwd.equals(tender_log.getTender_pwd())) {
				if(new_pwd.equals(rpt_new_pwd)) {
					try {
						new_pwd = Tools.MD5(new_pwd);
						tender_log_dao.updateTenderPwd(acct, new_pwd);
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
