package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@SpringBootApplication
public class SpringTranslatorApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringTranslatorApplication.class);

	public static void main(String[] args) throws Exception{
		SpringApplication.run(SpringTranslatorApplication.class, args);
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://google-translate1.p.rapidapi.com/language/translate/v2/languages"))
				.header("Accept-Encoding", "application/gzip")
				.header("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
				.header("X-RapidAPI-Key", "2e8087b636msh384464746937759p1941f9jsn9c7a58296c33")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println(response.body());

		String responseStr = replace(response.body());
		System.out.println("new Response : ");

		System.out.println(responseStr);
		String[] array = responseStr.split(",");

		System.out.println("Array of languages");

		ArrayList<Language> language = new ArrayList<Language>();

		for(int i = 0; i < array.length; i++){
			System.out.println(array[i]);
			language.add(new Language(array[i]));
		}

		System.out.println("Array of languages objects");

		for(int j = 0; j < language.size(); j++){
			System.out.println(language.get(j));
		}
	}

	private static String replace(String string){
		string = string.replace("[", "");
		string = string.replace("]", "");
		string = string.replace("{", "");
		string = string.replace("}", "");
		char ch = '"';
		string = string.replace(Character.toString(ch), "");
		string = string.replace("data", "");
		string = string.replace("languages", "");
		string = string.substring(2,string.length());
		return string;
	}
}
