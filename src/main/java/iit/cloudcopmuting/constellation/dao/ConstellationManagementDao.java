package iit.cloudcopmuting.constellation.dao;

import java.util.List;

import iit.cloudcopmuting.constellation.dto.ConstellationDetails;
import iit.cloudcopmuting.constellation.response.Response;

public interface ConstellationManagementDao {
	
	public List<ConstellationDetails> getAllConstellations();
	public int createConstellation(ConstellationDetails payload);
	public List<ConstellationDetails> getConstellationById(int constellationID);
	public int addConstellationToSatelite(int constellationID, int sateliteID);
	public int detachConstellationFromSatelite(int constellationID);
	public List<ConstellationDetails> getUnasignedConstellations();
}
