package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BidderInfo;
import beans.BidderPref;
import dao.BidderInfoDao;
import dao.BidderPrefDao;

/**
 * Servlet implementation class AllPrefFind
 */
@WebServlet("/AllPrefFind")
public class AllPrefFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllPrefFind() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		BidderInfoDao bidder_info_dao = new BidderInfoDao();
		HttpSession session = request.getSession(true);
		String bidder_acct = session.getAttribute("acct").toString();
		BidderInfo bidder_info = null;
		try {
			bidder_info = bidder_info_dao.dispBidderInfo(bidder_acct);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bidder_info == null) {
			request.getRequestDispatcher("bidder_pref_error.jsp").forward(request, response);
		}
		else {
			BidderPrefDao bidder_pref_dao = new BidderPrefDao();
			List<BidderPref> bidderPreflist = null;
			try {
				bidderPreflist = bidder_pref_dao.findAllBidderPref(bidder_info.getBidder_num());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("bidderPreflist", bidderPreflist);
			request.getRequestDispatcher("bidder_personal_pref.jsp").forward(request, response);
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
