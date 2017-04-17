package VO;

public class ModuleVO {
	ProjectVO pv;
	private int moduleId;
	private String moduleName;
	
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
		public ProjectVO getPv() {
		return pv;
	}
	public void setPv(ProjectVO pv) {
		this.pv = pv;
	}
		public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

}
