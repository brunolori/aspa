package com.lori.aspa.ui.models;




public class VehicleDTO {
	

	    private int id;
	    private String plate;
	    private String capacity;
	    private boolean carriage;
	    private String description;
	    private boolean active;
	    private String structure;
	    private int structureId;
	    private String type;
	    private String typeCode;
	    
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPlate() {
			return plate;
		}
		public void setPlate(String plate) {
			this.plate = plate;
		}
		public String getCapacity() {
			return capacity;
		}
		public void setCapacity(String capacity) {
			this.capacity = capacity;
		}
		public boolean isCarriage() {
			return carriage;
		}
		public void setCarriage(boolean carriage) {
			this.carriage = carriage;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		public String getStructure() {
			return structure;
		}
		public void setStructure(String structure) {
			this.structure = structure;
		}
		public int getStructureId() {
			return structureId;
		}
		public void setStructureId(int structureId) {
			this.structureId = structureId;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getTypeCode() {
			return typeCode;
		}
		public void setTypeCode(String typeCode) {
			this.typeCode = typeCode;
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			VehicleDTO other = (VehicleDTO) obj;
			if (id != other.id)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return plate;
		}
	    
	    
		
	    
	    

	

}
