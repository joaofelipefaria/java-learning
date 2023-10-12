package lu.joaofaria.java.samples.mapdata.test.dto;

import java.io.Serializable;

public class MapData implements Serializable{

	private String id;
	private String value;
	
	public MapData() {	
	}
	public MapData(String value) {
		this.value = value;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "MapData [id=" + id + ", value=" + value + "]";
	}
	
}
