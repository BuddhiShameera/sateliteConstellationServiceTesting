package iit.cloudcopmuting.constellation.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import iit.cloudcopmuting.constellation.dto.ConstellationDetails;
import iit.cloudcopmuting.constellation.response.Response;

public interface ConstellationManagementController {
	public @ResponseBody Response getAllConstellations();
	public @ResponseBody Response createConstellation(@RequestBody ConstellationDetails payload);
	public @ResponseBody Response getConstellationById(@RequestParam("constellationID") int constellationID);
	public @ResponseBody Response addConstellationToSatelite(@RequestParam("constellationID") int constellationID, @RequestParam("sateliteID") int sateliteID);
	public @ResponseBody Response detachConstellationFromSatelite(@RequestParam("constellationID") int constellationID);
	public @ResponseBody Response getUnasignedConstellations();
}
