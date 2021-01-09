package iit.cloudcopmuting.constellation.dto;

public class ConstellationDetails {
	private int constellationID;
	private int sateliteID;
	private String name;
	private String description;
	
	public int getConstellationID() {
		return constellationID;
	}
	public void setConstellationID(int constellationID) {
		this.constellationID = constellationID;
	}
	public int getSateliteID() {
		return sateliteID;
	}
	public void setSateliteID(int sateliteID) {
		this.sateliteID = sateliteID;
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
	public void setDescription(String description) {
		this.description = description;
	}
	
}
