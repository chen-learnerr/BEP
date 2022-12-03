package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.IeProg;
import beans.BidderInfo;
import dao.IeProgDao;
import dao.BidderInfoDao;

/**
 * Servlet implementation class AllProjDisp
 */
@WebServlet("/AllProjDisp")
public class AllProjDisp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllProjDisp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//进行编码
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		
		//新建Dao
		IeProgDao projdao = new IeProgDao();
		
		//
		List<IeProg> proList = null;
		
		//获取当前时间
		Date cur_date = new Date();
		java.sql.Date sd;
		sd = new java.sql.Date(cur_date.getTime());
		
		try {
			proList = projdao.allCurProgFind(sd);
			System.out.print("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		String type = request.getParameter("type");
		request.setAttribute("proinfo_list", proList);
		if(type.equals("tender")) {
			request.getRequestDispatcher("tender_proj_list.jsp").forward(request, response);
		}
		else {
			HttpSession session = request.getSession(true);
			String bidder_acct = session.getAttribute("acct").toString();
			BidderInfo bidder_info = null;
			String bidder_num = null;
			BidderInfoDao bidder_info_dao = new BidderInfoDao();
			try {
				bidder_info = bidder_info_dao.dispBidderInfo(bidder_acct);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(bidder_info == null) {
				bidder_num = "";
			} else {
				bidder_num = bidder_info.getBidder_num();
			}

			request.setAttribute("bidder_num", bidder_num);
			request.getRequestDispatcher("bidder_proj_list.jsp").forward(request, response);
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
