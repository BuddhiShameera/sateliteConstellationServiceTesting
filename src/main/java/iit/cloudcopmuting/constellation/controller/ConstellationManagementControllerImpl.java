package iit.cloudcopmuting.constellation.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import iit.cloudcopmuting.constellation.dto.ConstellationDetails;
import iit.cloudcopmuting.constellation.response.Response;
import iit.cloudcopmuting.constellation.service.ConstellationManagementService;


@RequestMapping("/constellation")
@RestController
@CrossOrigin
public class ConstellationManagementControllerImpl implements ConstellationManagementController{

	private static final Logger logger = LogManager.getLogger(ConstellationManagementControllerImpl.class);
	
	@Autowired
	private ConstellationManagementService constellationService;
	
	@Override
	@RequestMapping(value = "/getAllConstellations", method = RequestMethod.GET, produces = "application/json")
	public Response getAllConstellations() {
		
		logger.debug("ConstellationManagementControllerImpl -> getAllConstellations | Initiated");

		Response response = new Response();
		response = constellationService.getAllConstellations();

		logger.debug("ConstellationManagementControllerImpl -> getAllConstellations | Finalized");
		
		return response;
	}

	@Override
	@RequestMapping(value = "/createConstellation", consumes = "application/json", method = RequestMethod.POST, produces = "application/json")
	public Response createConstellation(ConstellationDetails payload) {
		logger.debug("ConstellationManagementControllerImpl -> createConstellation | Initiated");

		Response response = new Response();

		if (payload.getName() != null && !payload.getName().isEmpty()) {
			response = constellationService.createConstellation(payload);
		} else {
			response = new Response(Response.ERROR, "ERROR", "Unacceptable payload detected");
		}

		logger.debug("ConstellationManagementControllerImpl -> createConstellation | Finalized");
		
		return response;
	}

	@Override
	@RequestMapping(value = "/getConstellationById", method = RequestMethod.GET, produces = "application/json")
	public Response getConstellationById(int constellationID) {
		logger.debug("ConstellationManagementControllerImpl -> getConstellationById | Initiated");

		Response response = new Response();

		if(constellationID != 0) {
			response = constellationService.getConstellationById(constellationID);
		} else {
			response = new Response(Response.ERROR, "ERROR", "Unacceptable payload detected");
		}

		logger.debug("ConstellationManagementControllerImpl -> getConstellationById | Finalized");
		return response;
	}

	@Override
	@RequestMapping(value = "/addConstellationToSatelite", method = RequestMethod.GET, produces = "application/json")
	public Response addConstellationToSatelite(int constellationID, int sateliteID) {
		logger.debug("ConstellationManagementControllerImpl -> addConstellationToSatelite | Initiated");

		Response response = new Response();

		if(constellationID != 0 && sateliteID != 0) {
			response = constellationService.addConstellationToSatelite(constellationID, sateliteID);
		} else {
			response = new Response(Response.ERROR, "ERROR", "Unacceptable payload detected");
		}

		logger.debug("ConstellationManagementControllerImpl -> addConstellationToSatelite | Finalized");
		return response;
	}

	@Override
	@RequestMapping(value = "/detachConstellationFromSatelite", method = RequestMethod.GET, produces = "application/json")
	public Response detachConstellationFromSatelite(int constellationID) {
		logger.debug("ConstellationManagementControllerImpl -> detachConstellationFromSatelite | Initiated");

		Response response = new Response();

		if(constellationID != 0) {
			response = constellationService.detachConstellationFromSatelite(constellationID);
		} else {
			response = new Response(Response.ERROR, "ERROR", "Unacceptable payload detected");
		}

		logger.debug("ConstellationManagementControllerImpl -> detachConstellationFromSatelite | Finalized");
		return response;
	}

	@Override
	@RequestMapping(value = "/getUnasignedConstellations", method = RequestMethod.GET, produces = "application/json")
	public Response getUnasignedConstellations() {
		logger.debug("ConstellationManagementControllerImpl -> getUnasignedConstellations | Initiated");

		Response response = new Response();
		response = constellationService.getUnasignedConstellations();

		logger.debug("ConstellationManagementControllerImpl -> getUnasignedConstellations | Finalized");
		return response;
	}

}
