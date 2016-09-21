package org.binggo.mockapp.domain;

public class Person {
	private Integer personId;
	
    private String name;

    private String phone;

    private Integer cityId;

    public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
    
    //@Override
    //public String toString() {
    //	return String.format("{\"person_id\": %d, \"name\": \"%s\", \"phone\": \"%s\", \"city_id\": %d}", personId, name, phone, cityId);
    //}
}