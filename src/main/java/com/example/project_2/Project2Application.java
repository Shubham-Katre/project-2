package com.example.project_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Project2Application {

	public static void main(String[] args) {
		try {
			// Set the API endpoint URL with the name parameter
			String endpoint = "https://api.nationalize.io/?name=nathaniel";

			// Create a new URL object with the endpoint
			URL url = new URL(endpoint);

			// Open a connection to the API URL
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Set the HTTP request method to GET
			connection.setRequestMethod("GET");

			// Read the API response
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// Print the JSON response
			System.out.println(response.toString());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}