package iit.cloudcopmuting.constellation.response;

import java.util.List;

import iit.cloudcopmuting.constellation.dto.ConstellationDetails;

public class ConstellationDetailsResponse  extends Response {

    List<ConstellationDetails> constellationDetails;
    int totalItems;

    public ConstellationDetailsResponse(int id, String status, String description, List<ConstellationDetails> constellationDetails) {
        super(id, status, description);
        this.constellationDetails = constellationDetails;
    }

    public ConstellationDetailsResponse(int id, String status, String description, List<ConstellationDetails> constellationDetails, int totalItems) {
        super(id, status, description);
        this.constellationDetails = constellationDetails;
        this.totalItems = totalItems;
    }

	public List<ConstellationDetails> getConstellationDetails() {
		return constellationDetails;
	}

	public void setConstellationDetails(List<ConstellationDetails> constellationDetails) {
		this.constellationDetails = constellationDetails;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

}
