package ucsc.cmps278.lambdaArch.kafka;

import java.util.HashMap;

/**
 *	The logic to read this end points configuration from a file 
 *	and populating this map can done later. Keep it in-memory for now.
 */
public class EndPoints {
	private HashMap<String, String> routes =  new HashMap<>();

	// Ctor
	public EndPoints() {
		// Later on read external configuration files here
		routes.put("api", "http://api.metro.net/agencies/lametro/vehicles/");
	}

	// Get URI
	public HashMap<String, String> getRoutes() {
		return routes;
	}

	// Set URI
	public void setRoutes(String route, String URI) {
		routes.put(route, URI);
	}
}
 