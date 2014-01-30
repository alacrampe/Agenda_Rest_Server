package fr.ingesup.agenda.ws.services;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;

import fr.ingesup.agenda.ws.dao.UserServiceDAOUtil;
import fr.ingesup.agenda.ws.exceptions.DAOException;
import fr.ingesup.agenda.ws.exceptions.JsonException;
import fr.ingesup.agenda.ws.models.User;
import fr.ingesup.agenda.ws.utils.JSONUtils;
import fr.ingesup.agenda.ws.utils.Log;
import fr.ingesup.agenda.ws.utils.StringUtils;
import fr.ingesup.agenda.ws.utils.URLUtils;

@Path(URLUtils.SERVICE_USER_URL)
public class UserService {
	@GET
	@Path("{id}")
	public Response getUser(@PathParam("id") int id) {
		try {
			User user = UserServiceDAOUtil.get(String.valueOf(id));
			// Hide password from user
			user.setPassword("********");
			return Response.ok(JSONUtils.convertObjectToJSON(user)).build();
		} catch (JsonException e) {
			Log.error(e);
			return Response.status(e.getStatusCode()).build();
		} catch (DAOException e) {
			Log.error(e);
			return Response.serverError().build();
		}
	}

	@GET
	public Response getUserToken(@QueryParam("email") String userEmail, @QueryParam("password") String userPassword) {
		try {
//			String token = UserCRUDService.getUserToken(userEmail, userPassword);
			String token = null;
			return Response.ok(JSONUtils.getJSONObjectFromKeyValue("userToken", token)).build();
		} catch (JSONException e) {
			Log.error(e);
			return Response.serverError().build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(String userStr) throws URISyntaxException {
		try {
			User user = JSONUtils.convertJSONToObject(userStr, User.class);
			user.setUserToken(StringUtils.MD5Hash(user.getEmail()));
			user.setPassword("********");
			System.out.println("Generating user token : " + user.getUserToken());
//			int insertedId = UserCRUDService.save(user);
//			return Response.created(new URI(String.valueOf(insertedId))).build();
			return Response.ok().build();
		} catch (JsonException e) {
			Log.error(e);
			return Response.status(e.getStatusCode()).build();
		}
	}
}