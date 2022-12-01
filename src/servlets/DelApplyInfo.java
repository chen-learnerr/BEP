package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.StuApply;
import dao.FileInfoDao;
import dao.StuApplyDao;
import dao.StuInfoDao;

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
		String stu_acct = session.getAttribute("acct").toString();
		
		//新建Dao
		StuInfoDao stu_info_dao = new StuInfoDao();
		StuApplyDao stu_apply_dao = new StuApplyDao();
		FileInfoDao file_info_dao = new FileInfoDao();
		
		//获得参数
		int proj_no = Integer.parseInt(request.getParameter("proj_no"));
		
		//获得学号
		String stu_num = null;
		try {
			stu_num = stu_info_dao.dispStuInfo(stu_acct).getStu_num();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获得申请信息
		StuApply stu_apply = null;
		try {
			stu_apply = stu_apply_dao.findStuApply(stu_num, proj_no);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//删除申请所带附件
		String file_save_name = stu_apply.getApply_att_name();
		try {
			file_info_dao.delFileInfo(file_save_name);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//删除申请信息
		try {
			stu_apply_dao.delStuApply(stu_num, proj_no);
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
