package iit.cloudcopmuting.constellation.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iit.cloudcopmuting.constellation.dao.ConstellationManagementDao;
import iit.cloudcopmuting.constellation.dto.ConstellationDetails;
import iit.cloudcopmuting.constellation.response.ConstellationDetailsResponse;
import iit.cloudcopmuting.constellation.response.Response;

@Service
public class ConstellationManagementServiceImpl implements ConstellationManagementService{

	private static final Logger logger = LogManager.getLogger(ConstellationManagementServiceImpl.class);
	
	@Autowired
	ConstellationManagementDao constellationDAO;
	
	@Override
	public Response getAllConstellations() {
		logger.debug("ConstellationManagementServiceImpl -> getAllConstellations | Started");

		Response response = new Response();

		List<ConstellationDetails> satelites = new ArrayList<ConstellationDetails>();

		satelites = constellationDAO.getAllConstellations();

		if(satelites.size() == 0)	{
			response = new Response(Response.ERROR, "ERROR", "Data query returned null");
			logger.debug("ConstellationManagementServiceImpl -> getAllConstellations | Failed");
		}else {
			response = new ConstellationDetailsResponse( Response.SUCCESS, "SUCCESS", "Constellations found", satelites);
			logger.debug("ConstellationManagementServiceImpl -> getAllConstellations | Success");
		}

		return response;
	}

	@Override
	public Response createConstellation(ConstellationDetails payload) {
		logger.debug("ConstellationManagementServiceImpl -> createConstellation | Initialized");

		Response response = new Response();

		if (constellationDAO.createConstellation(payload)== 1) {
			response = new Response(Response.SUCCESS, "SUCCESS", "Constellation created successfully!");
			logger.debug("ConstellationManagementServiceImpl -> createConstellation | Success");
		} else {
			response = new Response(Response.ERROR, "ERROR", "Constellation creation error!");
		}

		logger.debug("ConstellationManagementServiceImpl -> createConstellation | Finalized");
		return response;
	}

	@Override
	public Response getConstellationById(int constellationID) {
		logger.debug("ConstellationManagementServiceImpl -> getConstellationById | Started");

		Response response = new Response();

		List<ConstellationDetails> constellations = new ArrayList<ConstellationDetails>();

		constellations = constellationDAO.getConstellationById(constellationID);

		if(constellations.size() == 0)	{
			response = new Response(Response.ERROR, "ERROR", "Data query returned null");
			logger.debug("ConstellationManagementServiceImpl -> getConstellationById | Failed");
		}else {
			response = new ConstellationDetailsResponse( Response.SUCCESS, "SUCCESS", "Constellations found", constellations);
			logger.debug("ConstellationManagementServiceImpl -> getConstellationById | Success");
		}

		return response;
	}

	@Override
	public Response addConstellationToSatelite(int constellationID, int sateliteID) {
		logger.debug("ConstellationManagementServiceImpl -> addConstellationToSatelite | Initialized");

		Response response = new Response();

		if (constellationDAO.addConstellationToSatelite(constellationID, sateliteID)== 1) {
			response = new Response(Response.SUCCESS, "SUCCESS", "Constellation added successfully!");
			logger.debug("ConstellationManagementServiceImpl -> addConstellationToSatelite | Success");
		} else {
			response = new Response(Response.ERROR, "ERROR", "Add constellation error!");
		}

		logger.debug("ConstellationManagementServiceImpl -> addConstellationToSatelite | Finalized");
		return response;
	}

	@Override
	public Response detachConstellationFromSatelite(int constellationID) {
		logger.debug("ConstellationManagementServiceImpl -> detachConstellationFromSatelite | Initialized");

		Response response = new Response();

		if (constellationDAO.detachConstellationFromSatelite(constellationID)== 1) {
			response = new Response(Response.SUCCESS, "SUCCESS", "Constellation detached successfully!");
			logger.debug("ConstellationManagementServiceImpl -> detachConstellationFromSatelite | Success");
		} else {
			response = new Response(Response.ERROR, "ERROR", "Detach constellation error!");
		}

		logger.debug("ConstellationManagementServiceImpl -> detachConstellationFromSatelite | Finalized");
		return response;
	}

	@Override
	public Response getUnasignedConstellations() {
		logger.debug("ConstellationManagementServiceImpl -> getUnasignedConstellations | Started");

		Response response = new Response();

		List<ConstellationDetails> satelites = new ArrayList<ConstellationDetails>();

		satelites = constellationDAO.getUnasignedConstellations();

		if(satelites.size() == 0)	{
			response = new Response(Response.ERROR, "ERROR", "Data query returned null");
			logger.debug("ConstellationManagementServiceImpl -> getUnasignedConstellations | Failed");
		}else {
			response = new ConstellationDetailsResponse( Response.SUCCESS, "SUCCESS", "UnasignedConstellations found", satelites);
			logger.debug("ConstellationManagementServiceImpl -> getUnasignedConstellations | Success");
		}

		return response;
	}

}
