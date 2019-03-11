package com.sr.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ola")
public class OlaRide {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("ridefare/{rideNo}")
	public double getRideFare(@QueryParam("source") String source, @QueryParam("destination") String destination,
			@PathParam("rideNo") String rideNo) {
		double farePrice = 0.0;

		if (rideNo != null && rideNo.trim().length() > 0) {
			farePrice = 454.75;
		}

		return farePrice;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("ridefare/response/{rideNo}")
	public Response getRideFareAsResponse(@QueryParam("source") String source,
			@QueryParam("destination") String destination, @PathParam("rideNo") String rideNo) {
		double farePrice = 0.0;

		if (rideNo != null && rideNo.trim().length() > 0) {
			farePrice = 454.75;
		}

		return Response.status(120).header("rideNo", rideNo).entity(Entity.text(farePrice).getEntity()).build();
	}
}
