package iit.cloudcopmuting.constellation.service;

import iit.cloudcopmuting.constellation.dto.ConstellationDetails;
import iit.cloudcopmuting.constellation.response.Response;

public interface ConstellationManagementService {

	public Response getAllConstellations();
	public Response createConstellation(ConstellationDetails payload);
	public Response getConstellationById(int constellationID);
	public Response addConstellationToSatelite(int constellationID, int sateliteID);
	public Response detachConstellationFromSatelite(int constellationID);
	public Response getUnasignedConstellations();
}
