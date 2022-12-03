package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BidderInfoDao;
import dao.BidderPrefDao;

/**
 * Servlet implementation class BidderPrefChange
 */
@WebServlet("/BidderPrefChange")
public class BidderPrefChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BidderPrefChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应和请求编码
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		BidderInfoDao bidder_info_dao = new BidderInfoDao();
		List<String> typeList = new ArrayList<String>();
		List<String> nameList = new ArrayList<String>();
		
		//获取信息
		int pref_num = Integer.parseInt(request.getParameter("pref_num"));
		for(int i = 0; i < pref_num; i++) {
			typeList.add(request.getParameter("pref"+i+"type"));
			nameList.add(request.getParameter("pref"+i+"name"));
		}
		
		BidderPrefDao bidder_pref_dao = new BidderPrefDao();
		HttpSession session = request.getSession(true);
		String bidder_acct = session.getAttribute("acct").toString();
		String bidder_num = null;
		try {
			bidder_num = bidder_info_dao.dispBidderInfo(bidder_acct).getBidder_num();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bidder_pref_dao.delBidderPref(bidder_num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < pref_num; i++) {
			try {
				bidder_pref_dao.insertBidderPref(bidder_num, typeList.get(i), nameList.get(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		out.print("更新成功");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
