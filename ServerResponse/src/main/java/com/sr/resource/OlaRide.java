package com.sr.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import com.sr.dto.RideInfo;
import com.sr.dto.RideRequest;

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

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("book-ride")
	public Response bookRide(RideRequest request) {
		RideInfo rInfo = null;

		rInfo = new RideInfo();
		rInfo.setCabNo("TS2312");
		rInfo.setDriverName("Akash");
		rInfo.setEstimatedPickup("10 min");
		rInfo.setRideNo("RN342212");
		rInfo.setMobileNo("3423312321");

		return Response.ok().header("RideNo", "RN342212").cookie(new NewCookie("otp", "234123"))
				.entity(Entity.json(rInfo)).build();
	}

}
