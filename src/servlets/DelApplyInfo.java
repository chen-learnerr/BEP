package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BidderApply;
import dao.FileInfoDao;
import dao.BidderApplyDao;
import dao.BidderInfoDao;

/**
 * Servlet implementation class DelApplyInfo
 */
@WebServlet("/DelApplyInfo")
public class DelApplyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelApplyInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//设置输出
		PrintWriter out = response.getWriter();
		
		//获得账号
		HttpSession session = request.getSession(true);
		String bidder_acct = session.getAttribute("acct").toString();
		
		//新建Dao
		BidderInfoDao bidder_info_dao = new BidderInfoDao();
		BidderApplyDao bidder_apply_dao = new BidderApplyDao();
		FileInfoDao file_info_dao = new FileInfoDao();
		
		//获得参数
		int proj_no = Integer.parseInt(request.getParameter("proj_no"));
		
		//获得学号
		String bidder_num = null;
		try {
			bidder_num = bidder_info_dao.dispBidderInfo(bidder_acct).getBidder_num();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获得申请信息
		BidderApply bidder_apply = null;
		try {
			bidder_apply = bidder_apply_dao.findBidderApply(bidder_num, proj_no);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//删除申请所带附件
		String file_save_name = bidder_apply.getApply_att_name();
		try {
			file_info_dao.delFileInfo(file_save_name);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//删除申请信息
		try {
			bidder_apply_dao.delBidderApply(bidder_num, proj_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.print("撤销成功");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
