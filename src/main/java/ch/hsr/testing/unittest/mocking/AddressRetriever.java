package ch.hsr.testing.unittest.mocking;


import ch.hsr.testing.unittest.testbuilderpattern.Address;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;

public class AddressRetriever {
    private final HttpService httpService;
    private final String apiKey;

    public AddressRetriever(String apiKey, HttpService httpService) {
        this.apiKey = apiKey;
        this.httpService = httpService;
    }

    public Address retrieveAddress(double coordX, double coordY) throws AddressRetrieverException {
        String url = "https://api3.geo.admin.ch/rest/services/api/MapServer/identify?" +
                "mapExtent=0,0,100,100&imageDisplay=100,100,100&tolerance=1&geometryType=esriGeometryPoint&geometry="
                + coordX + ","
                + coordY + "&layers=all:ch.bfs.gebaeude_wohnungs_register&returnGeometry=false&apiKey"
                + this.apiKey;
        try {
            String response = httpService.get(url);

            JSONObject obj = (JSONObject) new JSONParser().parse(response);
            JSONObject location = (JSONObject) (((JSONObject) ((JSONArray) obj.get("results")).get(0)).get("attributes"));
            return Address.fromJSONLocation(location);
        } catch (IOException e) {
            throw new AddressRetrieverException("Received Exception from HttpService", e);
        } catch (Exception e) {
            throw new AddressRetrieverException("Could not parse JSON from HttpService", e);
        }

    }
}
