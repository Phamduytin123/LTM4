package model.BEAN;

public class Department {
	private int id;
	private String name;
	private String description;
	public Department() {
		
	}
	public Department(String name, String decription) {
		this.name = name;
		this.description = decription;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String decription) {
		this.description = decription;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
