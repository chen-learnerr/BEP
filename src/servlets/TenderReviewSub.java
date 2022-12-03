package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.IeProg;
import dao.IeProgDao;
import dao.RevChangeNotifyDao;
import dao.BidderApplyDao;

/**
 * Servlet implementation class TenderReviewSubmit
 */
@WebServlet("/TenderReviewSub")
public class TenderReviewSub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenderReviewSub() {
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
		
		//获取账号
		HttpSession session = request.getSession(true);
		String aprv_tender=session.getAttribute("acct").toString();
		
		//获取参数
		int proj_no = Integer.parseInt(request.getParameter("proj_no"));
		String bidder_num = request.getParameter("bidder_num");
		String proj_status = request.getParameter("proj_status");

		//新建Dao
		BidderApplyDao bidder_apply_dao = new BidderApplyDao();
		RevChangeNotifyDao rev_notify_dao = new RevChangeNotifyDao();
		IeProgDao ie_prog_dao = new IeProgDao();
		
		//所需变量
		IeProg ieprog = null;
		
		
		//更新状态
		try {
			bidder_apply_dao.updateApply(bidder_num, proj_no, proj_status, aprv_tender);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//删除原有信息
		try {
			rev_notify_dao.delRevChangeNotify(bidder_num, proj_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取项目
		try {
			ieprog = ie_prog_dao.dispProjDetail(proj_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//添加新的信息
		String review_info = "你提交的关于 " + ieprog.getProj_name() + " 项目的申请的评定结果变更为" + proj_status;
		try {
			rev_notify_dao.insertRevChangeNotify(review_info, bidder_num, proj_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.print("success");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
