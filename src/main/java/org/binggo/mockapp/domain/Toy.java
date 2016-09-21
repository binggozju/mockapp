package org.binggo.mockapp.domain;

public class Toy {
	
	private int id;
	private String name;
	private Integer age;
	private Byte company;
	private boolean graduated;
	private Boolean adult;
	
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
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Byte getCompany() {
		return company;
	}
	public void setCompany(Byte company) {
		this.company = company;
	}
	
	public boolean isGraduated() {
		return graduated;
	}
	public void setGraduated(boolean graduated) {
		this.graduated = graduated;
	}
	
	public Boolean getAdult() {
		return adult;
	}
	public void setAdult(Boolean adult) {
		this.adult = adult;
	}
	
	//@Override
	//public String toString() {
	//	return String.format("Toy[id(int)=%d, name(String)=%s, age(Integer)=%d, company(Byte)=%d, graduated(boolean)=%b, adult(Boolean)=%b]", id, name, age, company, graduated, adult);
	//}
	
}
