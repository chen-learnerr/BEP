package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BidderInfo;
import dao.BidderInfoDao;

/**
 * Servlet implementation class TenderBidderInfoQuery
 */
@WebServlet("/TenderBidderInfoQuery")
public class TenderBidderInfoQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenderBidderInfoQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		String name = request.getParameter("bidder_name");
		String num = request.getParameter("bidder_num");
		String grd = request.getParameter("bidder_grd");
		BidderInfoDao bidderinfodao = new BidderInfoDao();
		List<BidderInfo> bidder_info = null;
		try {
			bidder_info = bidderinfodao.findCondBidderInfo(num, name, grd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("bidder_list", bidder_info);
		request.getRequestDispatcher("tender_bidder_info.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
