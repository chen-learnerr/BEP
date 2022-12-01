package beans;

public class FileInfo {
	private String file_save_name;
	private String file_disp_name;
	private String file_path;
	public FileInfo() {
		// TODO Auto-generated constructor stub
	}
	public FileInfo(String file_save_name, String file_disp_name, String file_path) {
		super();
		this.file_save_name = file_save_name;
		this.file_disp_name = file_disp_name;
		this.file_path = file_path;
	}
	public String getFile_save_name() {
		return file_save_name;
	}
	public void setFile_save_name(String file_save_name) {
		this.file_save_name = file_save_name;
	}
	public String getFile_disp_name() {
		return file_disp_name;
	}
	public void setFile_disp_name(String file_disp_name) {
		this.file_disp_name = file_disp_name;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
}
