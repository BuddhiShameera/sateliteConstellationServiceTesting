package iit.cloudcopmuting.constellation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import iit.cloudcopmuting.constellation.dto.ConstellationDetails;
import iit.cloudcopmuting.constellation.response.Response;

@Repository
public class ConstellationManagementDaoImpl implements ConstellationManagementDao{

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public List<ConstellationDetails> getAllConstellations() {
		final String query = "SELECT " +
				"a.constellationID," +
				"a.name," +
				"a.description," +
				"a.sateliteID," +
				"FROM constellation a ";


		List<ConstellationDetails> constellations = new ArrayList<ConstellationDetails>();

		List<Map<String, Object>> rows = jdbc.queryForList(query, new Object[] {});

		for (Map<String, Object> row : rows) {

			ConstellationDetails constellation = new ConstellationDetails();

			constellation.setSateliteID((Integer) row.get("sateliteID"));
			constellation.setName((String) row.get("name"));
			constellation.setDescription((String) row.get("description"));
			constellation.setConstellationID((Integer)row.get("constellationID"));

			constellations.add(constellation);

		}

		return constellations;
	}

	@Override
	public int createConstellation(ConstellationDetails payload) {
		int value;

		final String query = "INSERT INTO constellation ("
				+ "name, "
				+ "description, "
				+ "sateliteID ) "
				+ "VALUES (?,?,?)";


		value = jdbc.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				PreparedStatement ps = con.prepareStatement(query, new String[] {});

				ps.setString(1, payload.getName());
				ps.setString(2, payload.getDescription());
				ps.setDouble(3, payload.getSateliteID());

				return ps;
			}

		});

		return value;
	}

	@Override
	public List<ConstellationDetails> getConstellationById(int constellationID) {
		final String query = "SELECT " +
				"a.constellationID," +
				"a.name," +
				"a.description," +
				"a.sateliteID," +
				"FROM constellation a " +
				"WHERE a.constellationID = ?";


		List<ConstellationDetails> constellations = new ArrayList<ConstellationDetails>();

		List<Map<String, Object>> rows = jdbc.queryForList(query, new Object[] {constellationID});

		for (Map<String, Object> row : rows) {

			ConstellationDetails constellation = new ConstellationDetails();

			constellation.setSateliteID((Integer) row.get("sateliteID"));
			constellation.setName((String) row.get("name"));
			constellation.setDescription((String) row.get("description"));
			constellation.setConstellationID((Integer)row.get("constellationID"));

			constellations.add(constellation);

		}

		return constellations;
	}

	@Override
	public int addConstellationToSatelite(int constellationID, int sateliteID) {
		int val = 0;

		final String query = "UPDATE constellation a SET "
				+ "a.sateliteID=?, "
				+ "WHERE a.constellationID=?";

		val = jdbc.update(query,
				sateliteID,
				constellationID
				);

		return val;
	}

	@Override
	public int detachConstellationFromSatelite(int constellationID) {
		int val = 0;

		final String query = "UPDATE constellation a SET "
				+ "a.sateliteID=null, "
				+ "WHERE a.constellationID=?";

		val = jdbc.update(query,
				constellationID
				);

		return val;
	}

	@Override
	public List<ConstellationDetails> getUnasignedConstellations() {
		final String query = "SELECT " +
				"a.constellationID," +
				"a.name," +
				"a.description," +
				"a.sateliteID," +
				"FROM constellation a " +
				"WHERE a.sateliteID = null";


		List<ConstellationDetails> constellations = new ArrayList<ConstellationDetails>();

		List<Map<String, Object>> rows = jdbc.queryForList(query, new Object[] {});

		for (Map<String, Object> row : rows) {

			ConstellationDetails constellation = new ConstellationDetails();

			constellation.setSateliteID((Integer) row.get("sateliteID"));
			constellation.setName((String) row.get("name"));
			constellation.setDescription((String) row.get("description"));
			constellation.setConstellationID((Integer)row.get("constellationID"));

			constellations.add(constellation);

		}

		return constellations;
	}

}
