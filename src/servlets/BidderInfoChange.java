package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BidderInfoDao;

/**
 * Servlet implementation class BidderInfoChange
 */
@WebServlet("/BidderInfoChange")
public class BidderInfoChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BidderInfoChange() {
        super();
        // TODO Auto-generated constructor bidderb
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 编码
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// 输出
		PrintWriter out = response.getWriter();
		
		// 获取acct
		HttpSession session = request.getSession(true);
		String bidder_acct=session.getAttribute("acct").toString();
		
		// 获取参数
		String biddernum=request.getParameter("bidder_num");
		String biddername=request.getParameter("bidder_name");
		String biddermajor=request.getParameter("bidder_major");
		String bidderid=request.getParameter("bidder_id");
		String biddernation=request.getParameter("bidder_nation");
		String bidderpol=request.getParameter("bidder_pol");
		String bidderemail=request.getParameter("bidder_email");
		String biddersex=request.getParameter("bidder_sex");
		String biddergrade=request.getParameter("bidder_grade");
		String biddercall=request.getParameter("bidder_call");
		String bidderyear=request.getParameter("bidder_year");
		String bidderbirth=request.getParameter("bidder_birth");
		
		//新建Dao
		BidderInfoDao bidder_info_dao = new BidderInfoDao();
		
		try  {
			if(bidder_info_dao.dispBidderInfo(bidder_acct) != null) {
				bidder_info_dao.updateInfo(biddernum,bidder_acct,biddername,bidderid,biddersex,bidderpol,biddermajor,biddercall,bidderemail,biddernation,biddergrade,bidderbirth,bidderyear);
				out.print("ok");
			}
			else {
				if(biddernum.isEmpty()) {
					out.print("请输入执照编号");
				}
				else {
					try {
						bidder_info_dao.insertBidderInfo(biddernum,bidder_acct,biddername,bidderid,biddersex,bidderpol,biddermajor,biddercall,bidderemail,biddernation,biddergrade,bidderbirth,bidderyear);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					out.print("ok");
				}
			}
		} 
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
