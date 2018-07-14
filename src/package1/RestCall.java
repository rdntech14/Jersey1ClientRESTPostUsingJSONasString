package package1;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestCall {
	
	public static void main(String[] args) {

		try {
			getCall();
			putCall();
			postCall();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getCall(){
		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/student/list");

		ClientResponse response = webResource
									.header("Content-Type","application/json")
//									.header("Authorization", "Bearer ank")
									.get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
	}
	
	public static void putCall(){
		
		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/student/1");
		
		//JSON Body
//		String JSONbody = "{\"indexes\":[0,1,2]}";
		String JSONbody = "{\n" + 
				"	\"id\": 1,\n" + 
				"	\"firstName\": \"Vernon\",\n" + 
				"	\"lastName\": \"Harper\",\n" + 
				"	\"email\": \"1111aaaa@gmail.com\",\n" + 
				"	\"programme\": \"Financial Analysis\",\n" + 
				"	\"courses\": [\n" + 
				"		\"computer1\",\n" + 
				"		\"Statistics\"\n" + 
				"	]\n" + 
				"}";

		ClientResponse response = webResource
								 	.header("Content-Type","application/json")
//								 	.header("Authorization", "Bearer ank")
								 	.put(ClientResponse.class, JSONbody);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
		
	}
	
public static void postCall(){
		
		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/student");
		
		//JSON Body
//		String JSONbody = "{\"indexes\":[0,1,2]}";
		String JSONbody = "{\n" + 
				"	\"id\": 1,\n" + 
				"	\"firstName\": \"Vernon\",\n" + 
				"	\"lastName\": \"Harper\",\n" + 
				"	\"email\": \"1111aaaa@gmail.com\",\n" + 
				"	\"programme\": \"Financial Analysis\",\n" + 
				"	\"courses\": [\n" + 
				"		\"computer\",\n" + 
				"		\"Statistics\"\n" + 
				"	]\n" + 
				"}";

		ClientResponse response = webResource
								 	.header("Content-Type","application/json")
//								 	.header("Authorization", "Bearer ank")
								 	.post(ClientResponse.class, JSONbody);

		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);
		
	}
	
}