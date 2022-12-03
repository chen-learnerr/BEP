package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BidderInfo;
import dao.BidderInfoDao;

/**
 * Servlet implementation class BidderInfoFind
 */
@WebServlet("/BidderInfoFind")
public class BidderInfoFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BidderInfoFind() {
        super();
        // TODO Auto-generated constructor stub。
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String bidder_acct = session.getAttribute("acct").toString();
		BidderInfoDao bidder_info_dao = new BidderInfoDao();
		BidderInfo bidder_info = null;
		try {
			bidder_info = bidder_info_dao.dispBidderInfo(bidder_acct);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("bidder_info", bidder_info);
		request.getRequestDispatcher("bidder_info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

