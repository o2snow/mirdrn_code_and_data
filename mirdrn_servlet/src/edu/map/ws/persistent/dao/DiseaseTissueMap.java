package edu.map.ws.persistent.dao;

// Generated 2014/8/6 �W�� 10:27:37 by Hibernate Tools 3.4.0.CR1

/**
 * DiseaseTissueMap generated by hbm2java
 */
public class DiseaseTissueMap implements java.io.Serializable {

	private Integer diseaseTissueMapId;
	private String hmddDisease;

	public DiseaseTissueMap() {
	}

	public DiseaseTissueMap(String hmddDisease) {
		this.hmddDisease = hmddDisease;
	}

	public Integer getDiseaseTissueMapId() {
		return this.diseaseTissueMapId;
	}

	public void setDiseaseTissueMapId(Integer diseaseTissueMapId) {
		this.diseaseTissueMapId = diseaseTissueMapId;
	}

	public String getHmddDisease() {
		return this.hmddDisease;
	}

	public void setHmddDisease(String hmddDisease) {
		this.hmddDisease = hmddDisease;
	}

}
