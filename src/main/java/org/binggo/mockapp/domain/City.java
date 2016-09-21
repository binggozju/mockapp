package org.binggo.mockapp.domain;

public class City {
	private Integer cityId;
	
    private String name;

    private String province;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }
    
    //@Override
    //public String toString() {
    //	return String.format("{\"city_id\": %d, \"name\": \"%s\", \"province\": \"%s\"}", cityId, name, province);
    //}
}