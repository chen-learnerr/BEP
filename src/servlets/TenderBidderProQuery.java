package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Applicant;
import dao.ApplicantDao;

/**
 * Servlet implementation class TenderBidderProQuery
 */
@WebServlet("/TenderBidderProQuery")
public class TenderBidderProQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenderBidderProQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int proj_no = Integer.parseInt(request.getParameter("proj_no"));
		String bidder_name = request.getParameter("bidder_name");
		String bidder_num = request.getParameter("bidder_num");
		String bidder_grd = request.getParameter("bidder_grd");
		ApplicantDao applicantdao = new ApplicantDao();
		List<Applicant> applicant = null;
		try {
			applicant = applicantdao.applicantCondQuery(proj_no, bidder_name, bidder_num, bidder_grd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("app_list", applicant);
		request.getRequestDispatcher("tender_app_list.jsp").forward(request, response);
	}

}
