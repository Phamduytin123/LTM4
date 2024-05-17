package model.BEAN;

public class Staff {
	private int id ;
	private int idDepartment;
	private String name;
	private String address;
	private String gender;
	private String phone;
	public Staff() {
		
	}
	public Staff(int idDepartment, String name, String address, String gender, String phone) {
		super();
		this.idDepartment = idDepartment;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdDepartment() {
		return idDepartment;
	}
	public void setIdDepartment(int idDepartment) {
		this.idDepartment = idDepartment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
