package servlets;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.FileInfo;
import dao.FileInfoDao;

/**
 * Servlet implementation class DownFile
 */
@WebServlet("/DownFile")
public class DownFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//编码
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//获得请求文件名
        String file_save_name = request.getParameter("filename");
        
        //新建Dao
        FileInfoDao file_info_dao = new FileInfoDao();
        FileInfo file_info = null;
        
        //查找展示名
        try {
			file_info= file_info_dao.findFileInfo(file_save_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //设置文件MIME类型
        response.setContentType(getServletContext().getMimeType(file_save_name));
        //设置Content-Disposition
        String file_disp_name = new String(file_info.getFile_disp_name().getBytes("UTF-8"), "ISO-8859-1");
        response.setHeader("Content-Disposition", "attachment;filename=" + file_disp_name);
        //读取目标文件，通过response将目标文件写到客户端
        //获取目标文件的绝对路径
        String fullFileName = file_info.getFile_path() + "//" + file_save_name;
        //读取文件
        FileInputStream in = new FileInputStream(fullFileName);
        ServletOutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        //循环取出流中的数据
        while((len = in.read(buffer)) != -1){
            out.write(buffer,0,len);
        }
        in.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
