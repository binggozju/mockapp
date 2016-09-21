package org.binggo.mockapp.domain;

public class DetailedPerson {
	
	private Integer personId;
	
    private String personName;

    private String phone;

    private Integer cityId;
    
    private String cityName;

    private String province;
    
    public DetailedPerson(Integer personId) {
    	this.personId = personId;
    }

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	//@Override
	//public String toString() {
	//	return String.format("{\"person_id\": %d, \"person_name\": \"%s\", "
	//			+ "\"phone\": \"%s\", \"city_id\": %d, \"city_name\": \"%s\", "
	//			+ "\"province\": \"%s\"}", personId, personName, phone, cityId, cityName, province);
	//}
	
}
