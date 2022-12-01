package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import beans.IeProg;
import dao.ModProjNotifyDao;
import dao.FileInfoDao;
import dao.IeProgDao;

/**
 * Servlet implementation class AdminStuInfoDtl
 */
@WebServlet("/ProjInfoChange")
public class ProjInfoChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjInfoChange() {
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
		
		//发送信息
		PrintWriter out = response.getWriter();
		
		//获取账号
		HttpSession session = request.getSession(true);
		String proj_pub_acct = session.getAttribute("acct").toString();
		
		//新建Dao
		IeProgDao ie_prog_dao = new IeProgDao();
		FileInfoDao file_info_dao = new FileInfoDao();
		ModProjNotifyDao del_proj_info_dao = new ModProjNotifyDao();
		
		//获得参数
		int proj_no = Integer.parseInt(request.getParameter("proj_no"));
		
		//找到对应的IeProg
		IeProg ie_prog = null;
		try {
			ie_prog =  ie_prog_dao.dispProjDetail(proj_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//找到对应的文件
		String file_save_name = ie_prog.getProj_file();
		
		//获取当天时间
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date2 = sdf.format(date);
		
		//文件检查
		DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        //设置缓冲区大小与临时文件目录
        factory.setSizeThreshold(1024*1024*1024);
        File uploadTemp=new File("e:\\uploadTemp");
        uploadTemp.mkdirs();
        factory.setRepository(uploadTemp);
        
        //设置单个文件大小限制
        upload.setFileSizeMax(1024*1024*256);
        //设置所有文件总和大小限制
        upload.setSizeMax(1024*1024*512);
        
        Map<String, String> infoMap = new HashMap<String, String>();
        try {
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem fileItem:list) {
                infoMap.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
            	if (!fileItem.isFormField() &&fileItem.getName()!=null&&!"".equals(fileItem.getName())){
                    String fileName = fileItem.getName();
                    System.out.println("File:" + fileName);
                    //利用UUID生成伪随机字符串，作为文件名避免重复
                    String uuid= UUID.randomUUID().toString();
                    //获取文件后缀名
                    String suffix= fileName.substring(fileName.lastIndexOf("."));
                    file_info_dao.delFileInfo(file_save_name);
                    file_save_name = uuid + suffix;
                    //获取文件上传目录路径，在项目部署路径下的upload目录里。若想让浏览器不能直接访问到图片，可以放在WEB-INF下
                    String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
                    System.out.println(uploadPath);
                    File file=new File(uploadPath);
                    file.mkdirs();
                    //写入文件到磁盘，该行执行完毕后，若有该临时文件，将会自动删除
                    fileItem.write(new File(uploadPath, file_save_name));
                    
                    file_info_dao.insertFileInfo(file_save_name, fileName, uploadPath);
                }
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
        
		//获取参数
		String proj_name = infoMap.get("proj_name");
		String proj_sch = infoMap.get("proj_sch");
		String proj_country = infoMap.get("proj_country");
		int proj_credict = Integer.parseInt(infoMap.get("proj_credict"));
		Date proj_start_time = Date.valueOf(infoMap.get("proj_start_time"));
		Date proj_apply_ddl = Date.valueOf(infoMap.get("proj_apply_ddl"));
		String proj_lang = infoMap.get("proj_lang");
		String proj_time = infoMap.get("proj_time");
		String proj_info = infoMap.get("proj_info");
		
		try {
			ie_prog_dao.updateIeProg(proj_no, proj_name, proj_sch, proj_apply_ddl, proj_start_time, proj_lang, proj_country, proj_pub_acct, proj_credict, proj_time, proj_info, file_save_name);
			String info = "你参与的 "+proj_name+" 项目于" + date2 +"被管理员 " + proj_pub_acct + " 更改，快去看看吧！";
			del_proj_info_dao.delModProjNotify(proj_no);
			del_proj_info_dao.insertModProjNotify(info, proj_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("success");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}