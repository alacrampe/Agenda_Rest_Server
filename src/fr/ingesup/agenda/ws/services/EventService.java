package fr.ingesup.agenda.ws.services;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.ingesup.agenda.ws.dao.EventServiceDAOUtil;
import fr.ingesup.agenda.ws.exceptions.DAOException;
import fr.ingesup.agenda.ws.exceptions.JsonException;
import fr.ingesup.agenda.ws.models.Event;
import fr.ingesup.agenda.ws.models.WSEventsInput;
import fr.ingesup.agenda.ws.utils.EventUtils;
import fr.ingesup.agenda.ws.utils.JSONUtils;
import fr.ingesup.agenda.ws.utils.URLUtils;

@Path(URLUtils.SERVICE_EVENT_URL)
public class EventService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEvents(String wsInputStr, @QueryParam(value="userToken") String userToken) {
		try {
			WSEventsInput wsInput = JSONUtils.convertJSONToObject(wsInputStr, WSEventsInput.class);
			return Response.ok(JSONUtils.convertListToJSON(EventServiceDAOUtil.getAllEvents(wsInput, userToken))).build();
		} catch (DAOException e) {
			return Response.status(Status.SERVICE_UNAVAILABLE).build();
		} catch (JsonException e) {
			return Response.status(e.getStatusCode()).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEvent(String eventStr, @QueryParam(value="userToken") String userToken) throws URISyntaxException {
		try {
			Event event = JSONUtils.convertJSONToObject(eventStr, Event.class);
			Event specificEvent = JSONUtils.convertJSONToObject(eventStr, EventUtils.getEventClassFromType(event.getType()));
			EventServiceDAOUtil.save(specificEvent);
			return Response.ok().build();
		} catch (JsonException e) {
			return Response.status(e.getStatusCode()).build();
		} catch (DAOException e) {
			return Response.serverError().build();
		}
	}
	
	@GET
	@Path("{id}")
	public Response getEvent(@PathParam("id") String id, @QueryParam(value="userToken") String userToken) {
		// TODO Do user token check (event must be one of user's ones)
		try {
			Event event = EventServiceDAOUtil.get(id);
			return Response.ok(JSONUtils.convertObjectToJSON(event)).build();
		} catch (DAOException e) {
			return Response.serverError().build();
		} catch (JsonException e) {
			return Response.serverError().build();
		}
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEvent(String eventStr, @PathParam("id") String id, @QueryParam(value="userToken") String userToken) {
		// TODO Do user token check (event must be one of user's ones)
		try {
			Event event = JSONUtils.convertJSONToObject(eventStr, Event.class);
			event = EventServiceDAOUtil.update(event);
			return Response.ok(JSONUtils.convertObjectToJSON(event)).build();
		} catch (DAOException e) {
			return Response.serverError().build();
		} catch (JsonException e) {
			return Response.serverError().build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteEvent(@PathParam("id") String id, @QueryParam(value="userToken") String userToken) {
		// TODO Do user token check (event must be one of user's ones)
		try {
			EventServiceDAOUtil.delete(id);
			return Response.ok().build();
		} catch (DAOException e) {
			return Response.serverError().build();
		}
	}
}