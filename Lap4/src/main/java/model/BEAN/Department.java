package model.BEAN;

public class Department {
	private int id;
	private String name;
	private String decription;
	private String equipment;
	public Department() {
		
	}
	public Department(String name, String decription, String equipment) {
		this.name = name;
		this.decription = decription;
		this.equipment = equipment;
	}
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
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
}
