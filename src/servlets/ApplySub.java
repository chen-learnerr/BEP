package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

import beans.BidderInfo;
import dao.FileInfoDao;
import dao.BidderApplyDao;
import dao.BidderInfoDao;

/**
 * Servlet implementation class ApplySub
 */
@WebServlet("/ApplySub")
public class ApplySub extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplySub() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		BidderInfoDao bidder_info_dao = new BidderInfoDao();
		BidderApplyDao bidder_apply_dao = new BidderApplyDao();
		String bidder_acct = session.getAttribute("acct").toString();
		BidderInfo bidder_info = null;

		boolean isFileExists = false;
		String uuid = null;
		
		try {
			bidder_info = bidder_info_dao.dispBidderInfo(bidder_acct);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(bidder_info == null) {
			out.print("noNum");
		}
		else {
			// 获取学号
			String bidder_num = bidder_info.getBidder_num();
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

	        try {
	            List<FileItem> list = upload.parseRequest(request);
	            for (FileItem fileItem:list){
	            	if (!fileItem.isFormField() &&fileItem.getName()!=null&&!"".equals(fileItem.getName())){
	            		isFileExists = true;
	                    String fileName = fileItem.getName();
	                    //利用UUID生成伪随机字符串，作为文件名避免重复
	                    uuid= UUID.randomUUID().toString();
	                    //获取文件后缀名
	                    String suffix= fileName.substring(fileName.lastIndexOf("."));
	                    //获取文件上传目录路径，在项目部署路径下的upload目录里。若想让浏览器不能直接访问到图片，可以放在WEB-INF下
	                    String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
	                    File file=new File(uploadPath);
	                    file.mkdirs();
	                    //写入文件到磁盘，该行执行完毕后，若有该临时文件，将会自动删除
	                    fileItem.write(new File(uploadPath,uuid+suffix));
	                    
	                    FileInfoDao file_info_dao = new FileInfoDao();
	                    file_info_dao.insertFileInfo(uuid+suffix, fileName, uploadPath);
	                }
	            }
	        }  catch (Exception e) {
	            e.printStackTrace();
	        }
	        
			int proj_num = Integer.parseInt(request.getParameter("proj_num"));
			String apply_status = "等待审批";
			String file_name = uuid+".zip";
			
			if (isFileExists) {
				try {
					bidder_apply_dao.delBidderApply(bidder_num, proj_num);
					bidder_apply_dao.insertBidderApply(bidder_num, proj_num, apply_status, file_name);
				} catch (Exception e) {
					e.printStackTrace();
				}
				out.print("success");
			} else if(!isFileExists) {
				out.print("fail_2");
			}
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
