package com.lori.aspa.dto;




public class StructureDTO {
	

	    private int id;
	    private String name;
	    private String parent;
	    private int parentId;
	    private boolean active;
	    
	    
	    
	    
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getParent() {
			return parent;
		}
		public void setParent(String parent) {
			this.parent = parent;
		}
		public int getParentId() {
			return parentId;
		}
		public void setParentId(int parentId) {
			this.parentId = parentId;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		
		@Override
		public String toString() {
			return "StructureDTO [id=" + id + ", name=" + name + ", parent=" + parent + ", parentId=" + parentId
					+ ", active=" + active + "]";
		}
	
	    
	    


}
