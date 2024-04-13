package user.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String name;
	private String adr;
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
	public String getAddress() {
		return adr;
	}
	public void setAddress(String adr) {
		this.adr = adr;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", adr=" + adr + "]";
	}
	
	
}
