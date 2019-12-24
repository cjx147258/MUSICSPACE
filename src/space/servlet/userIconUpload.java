package space.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.jasper.compiler.Node.GetProperty;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class userIconUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * 处理文件上传
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//声明文件名
		String fileName="";
		//声明上传的路径
		String uploadPath=request.getServletContext().getRealPath("upload");
//		String uploadPath="E:\\pictures\\Saved Pictures";
		System.out.println("要上传的路径是："+uploadPath);
		//判断form表单请求提交的类型(encType)
		boolean isMultipart=ServletFileUpload.isMultipartContent(request);
		if(isMultipart) {			//如果是混合表单
			FileItemFactory factory=new DiskFileItemFactory();
			//使用工厂对象创建ServletUpload
			ServletFileUpload upload=new ServletFileUpload(factory);
			try {
				String name="";
				String pass="";
				//解析用户的表单
				List<FileItem> fileItems=upload.parseRequest(request);
				for (FileItem fileItem : fileItems) {
					boolean isField=fileItem.isFormField();		//判断是普通表单还是附件表单
					if(isField) {			//如果是普通表单
						String fieldName=fileItem.getFieldName();
						if("uname".equals(fieldName)) {
							name=fileItem.getString("utf-8");			//获取用户名
						}
						if("pass".equals(fieldName)) {
							pass=fileItem.getString("utf-8");
						}
					}else {			//如果是文件
						fileName=fileItem.getName();   //获取文件名
						System.out.println("获取到的文件名是:"+fileName);
						String newName=getNewName(fileName);			//生成新文件名
						File file=new File(uploadPath,newName);
						//文件写入
						fileItem.write(file);
					}
				}
				//System.out.println("上传用户是："+name);
				request.getRequestDispatcher("upload.jsp").forward(request, response);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//生成一个新的文件名
	public String getNewName(String fileName) {
		int index=fileName.lastIndexOf("\\");
		if(index!=-1) {
		fileName=fileName.substring(index+1);
		} 
		return fileName;			//源文件名
	}
}