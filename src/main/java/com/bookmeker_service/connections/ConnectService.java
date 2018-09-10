package com.bookmeker_service.connections;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class ConnectService {

	private final HttpClient client= HttpClientBuilder.create().build();
    private static final int HTTP_CODE_NOT_FOUND = 404;
	
    
	public String sendGETRequest(String url) {
		HttpGet request = new HttpGet(url);
		String json = null;
		try {
			HttpResponse response = client.execute(request);
			
			System.out.println("HTTP code : " + response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == HTTP_CODE_NOT_FOUND) {
              System.err.println("Document not found!");
              throw new FileNotFoundException();
            }
            json = readFromStream(response.getEntity().getContent());
		} catch (IOException e) {
        	System.err.println("System error!");
        }
		return json;	
	}
	
	private static String readFromStream(InputStream stream) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
        	System.err.println("System error!");
        }
        return builder.toString();
    }
}
