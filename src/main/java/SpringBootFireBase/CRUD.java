package SpringBootFireBase;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CRUD {

	private String documentId ;
	private String name;
	private String profession;
	public CRUD() {};
	
	public CRUD(String documentId, String name, String profession) {
		super();
		this.documentId = documentId;
		this.name = name;
		this.profession = profession;
	}

	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
}
