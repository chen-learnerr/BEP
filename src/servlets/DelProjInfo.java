package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.IeProg;
import dao.ModProjNotifyDao;
import dao.FileInfoDao;
import dao.IeProgDao;
import dao.NewProjInfoDao;

/**
 * Servlet implementation class DelPorjInfo
 */
@WebServlet("/DelProjInfo")
public class DelProjInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelProjInfo() {
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
		
		//新建Dao
		IeProgDao ie_proj_dao = new IeProgDao();
		FileInfoDao file_info_dao = new FileInfoDao();
		NewProjInfoDao new_proj_info_dao = new NewProjInfoDao();
		ModProjNotifyDao del_proj_info_dao = new ModProjNotifyDao();
        
		int proj_no = Integer.parseInt(request.getParameter("proj_no"));
		IeProg delproj = null;
		
		//获取编号对应的项目
		try {
			delproj = ie_proj_dao.dispProjDetail(proj_no);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//删除项目包含的文件信息
		String file_save_name = delproj.getProj_file();
		try {
			file_info_dao.delFileInfo(file_save_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//删除项目对应的通知信息
		try {
			new_proj_info_dao.delNewProjNotify(proj_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//添加项目被删除的信息
		String info = "您参与的 " + delproj.getProj_name() +" 项目被撤销";
		try {
			del_proj_info_dao.insertModProjNotify(info, proj_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//删除项目
		try {
			ie_proj_dao.delIeProg(proj_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
