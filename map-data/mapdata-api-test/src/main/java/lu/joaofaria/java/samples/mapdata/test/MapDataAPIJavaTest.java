package lu.joaofaria.java.samples.mapdata.test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lu.joaofaria.java.samples.mapdata.test.dto.MapData;

public class MapDataAPIJavaTest {
	static final String HOST = "http://localhost:8080";
	static ObjectMapper mapper = new ObjectMapper();

	public static void main(String... args) throws Exception {
		System.out.println("teste");
		HttpClient client = HttpClient.newBuilder().build();
//		// GET ALL METHOD
		List<MapData> listDb = getAll(client);
		// GET BY ID METHOD
//		String id = listDb.get(0).getId();
//		getById(client, id);
//		// UPDATE METHOD
//		MapData updateObj = listDb.get(0);
//		updateObj.setValue("JOAO VALUE");
//		update(client, updateObj);
//		// DELETE METHOD
//		delete(client, id);
		// INSERT METHOD
//		String valueStr = "value";
//		create(client, valueStr);

	}

	private static void create(HttpClient client, String valueStr)
			throws JsonProcessingException, IOException, InterruptedException {
		MapData newObj = new MapData(valueStr);
		String postString = mapper.writeValueAsString(newObj).replaceAll("\"0\"", "0");
		System.out.println("::::::::" + postString);
		BodyPublisher bodyPost = HttpRequest.BodyPublishers.ofString(postString);
		HttpRequest request5 = HttpRequest.newBuilder().header("Content-Type", "application/json")
				.uri(URI.create(HOST + "/api/v1/data")).POST(bodyPost).build();
		HttpResponse<String> response5 = client.send(request5, HttpResponse.BodyHandlers.ofString());
		System.out.println("INSERT-Status code: " + response5.statusCode());
		System.out.println("\n Body: " + response5.body());
	}

	private static void delete(HttpClient client, String id) throws IOException, InterruptedException {
		HttpRequest request4 = HttpRequest.newBuilder().header("Content-Type", "application/json")
				.uri(URI.create(HOST + "/api/v1/data/" + id)).DELETE().build();
		HttpResponse<String> response4 = client.send(request4, HttpResponse.BodyHandlers.ofString());
		System.out.println("DELETE-Status code: " + response4.statusCode());
		System.out.println("\n Body: " + response4.body());
	}

	private static void update(HttpClient client, MapData updateObj)
			throws JsonProcessingException, IOException, InterruptedException {
		String putString = mapper.writeValueAsString(updateObj).replaceAll("\"2\"", "2");
		System.out.println("::::::::" + putString);
		BodyPublisher bodyPut = HttpRequest.BodyPublishers.ofString(putString);
		HttpRequest request3 = HttpRequest.newBuilder().header("Content-Type", "application/json")
				.uri(URI.create(HOST + "/api/v1/data/" + updateObj.getId())).PUT(bodyPut).build();
		HttpResponse<String> response3 = client.send(request3, HttpResponse.BodyHandlers.ofString());
		System.out.println("UPDATE-Status code: " + response3.statusCode());
		System.out.println("\n Body: " + response3.body());
	}

	private static void getById(HttpClient client, String id)
			throws IOException, InterruptedException, JsonProcessingException, JsonMappingException {
		HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create(HOST + "/api/v1/data/" + id)).build();
		HttpResponse<String> response2 = client.send(request2, BodyHandlers.ofString());
		Object o = mapper.readValue(response2.body(), Object.class);
		String a = o.toString().replaceAll("=", "\":\"").replaceAll(", ", "\", \"").replaceAll("}", "\"}")
				.replaceAll("\\{", "\\{\"");
		MapData m = mapper.readValue(a, MapData.class);
	}

	private static List<MapData> getAll(HttpClient client)
			throws IOException, InterruptedException, JsonProcessingException, JsonMappingException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(HOST + "/api/v1/all-data")).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		List<MapData> listDb = new ArrayList<>();
		List list = mapper.readValue(response.body(), List.class);
		for (Object o : list) {
			String a = o.toString().replaceAll("=", "\":\"").replaceAll(", ", "\", \"").replaceAll("}", "\"}")
					.replaceAll("\\{", "\\{\"");
			MapData m = mapper.readValue(a, MapData.class);
			listDb.add(m);
		}
		System.out.println("ALLL RESULT:" + listDb);
		return listDb;
	}
}