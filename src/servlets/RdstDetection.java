package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.TenderLog;
import beans.BidderLog;
import dao.TenderLogDao;
import dao.BidderLogDao;
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
		TenderLogDao tender_log_dao = new TenderLogDao();
		BidderLogDao bidderlogdao = new BidderLogDao();
		List<TenderLog> tender_log = null;
		List<BidderLog> bidder_log = null;
		try {
			tender_log = tender_log_dao.findAllTenderLog();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bidder_log = bidderlogdao.findAllBidderLog();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String acct = request.getParameter("rdst_acct");
		String pwd = request.getParameter("rdst_pwd");
		String rpt_pwd = request.getParameter("rpt_pwd");
		String type = request.getParameter("type");
		
		if(tender_log.isEmpty()) {
			System.out.println("xxx");
		}
		if(type.equals("招标方注册")) {
			boolean isFind = false;
			for(int i = 0; i < tender_log.size(); i++) {
				if(acct.equals(tender_log.get(i).getTender_acct())) {
					isFind = true;
					out.print("注册失败，用户名重复！");
					break;
				}
			}
			if(!isFind) {
				if(pwd.equals(rpt_pwd)){
					try {
						pwd = Tools.MD5(pwd);
						tender_log_dao.insertTenderLog(acct, pwd);
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
			for(int i = 0; i < bidder_log.size(); i++) {
				if(acct.equals(bidder_log.get(i).getBidder_acct())) {
					isFind = true;
					out.print("注册失败，用户名重复!");
				}
			}
			if(!isFind) {
				if(pwd.equals(rpt_pwd)){
					try {
						pwd = Tools.MD5(pwd);
						bidderlogdao.insertBidderLog(acct, pwd);
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
