package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BidderInfo;
import dao.BidderInfoDao;

/**
 * Servlet implementation class TenderBidderInfoDtl
 */
@WebServlet("/TenderBidderInfoDtl")
public class TenderBidderInfoDtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenderBidderInfoDtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String bidder_num = request.getParameter("bidder_num");
		System.out.println(bidder_num);
		BidderInfoDao bidderinfodao = new BidderInfoDao();
		BidderInfo bidder_info = null;
		try {
			bidder_info = bidderinfodao.dispBidderDetail(bidder_num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("bidder_list", bidder_info);
		request.getRequestDispatcher("tender_bidder_info_dtl.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}