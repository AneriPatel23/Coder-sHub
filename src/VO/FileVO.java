package VO;

public class FileVO {
	ProjectVO pv;
	ModuleVO mv;
	private int fileId;
	private String fileName;
	public ProjectVO getPv() {
		return pv;
	}
	public void setPv(ProjectVO pv) {
		this.pv = pv;
	}
	public ModuleVO getMv() {
		return mv;
	}
	public void setMv(ModuleVO mv) {
		this.mv = mv;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
