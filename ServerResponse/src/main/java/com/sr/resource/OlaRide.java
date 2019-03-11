package com.sr.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
}
