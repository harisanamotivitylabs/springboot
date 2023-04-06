package com.example.WebClientPoc;

import com.example.WebClientPoc.model.Name;
import com.example.WebClientPoc.model.Root;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import jdk.internal.org.objectweb.asm.tree.LdcInsnNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.DataInput;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootApplication
public class WebClientPocApplication {

//	public static <K, V> K getKeyByValue(Map<K, V> map, V value) {
//		for (Map.Entry<K, V> entry : map.entrySet()) {
//			if (Objects.equals(value, entry.getValue())) {
//				return entry.getKey();
//			}
//		}
//		return null;
//	}


	public static void main(String[] args) throws JsonProcessingException {


		SpringApplication.run(WebClientPocApplication.class, args);


//		WebClient webClient2 = WebClient.builder()
//				.baseUrl("https://webapi-uatv2.digitalreef.com/api/users/list/")
//				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//				.build();


		WebClient webClient = WebClient.create("https://webapi-uatv2.digitalreef.com/api");

		HashMap<String, Name> createdEmployee = webClient.get()

				.uri("/users/list/")
				.headers(httpHeaders -> {
					httpHeaders.add("Authorization", "Token aeacd8b8250852c0231e4da05abeeb2564c99727");
					httpHeaders.add("organization", "5a294f81993c8f1570c2550d");
				})
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<HashMap<String, Name>>() {}).block();

		String filterRole = "Campaign Approver";
		Map<String, Name> collect = createdEmployee.entrySet().stream().filter(entry -> entry.getValue().getRoles().contains(filterRole)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		collect.values().stream().forEach(name -> System.out.println(name));
		System.out.println("");
//		HashMap<String, Name> filteredMap = createdEmployee.entrySet().stream()
//				.filter(entry -> entry.getValue().roles != null && entry.getValue().roles.contains(filterRole))
//				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));



//		createdEmployee.entrySet().stream().filter(t -> t.getValue().getRoles().size() != 0).forEach(System.out::println);
//
//
//		Iterator<String> iterator = createdEmployee.keySet().iterator();
//		while (iterator.hasNext()) {
//			String str = iterator.next();

			//(str,createdEmployee.get(str),"ADMIN");





/*

         String role ="Campaign Approver";
		createdEmployee.entrySet().stream()
				.filter(entry -> entry.getValue().getRoles().contains(role))
				.forEach(entry -> System.out.println(entry.getKey() + " has the desired role"));

		// Get a list of all employees with the desired role
		ArrayList<String> employeesWithRole = createdEmployee.entrySet().stream()
				.filter(entry -> entry.getValue().getRoles().contains(role))
				.map(entry -> entry.getKey())
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println("Employees with the desired role: " + employeesWithRole);
*/


//		createdEmployee.keySet().forEach(key -> {
//			System.out.println("Employee ID: " + key);
//			System.out.println("Employee Name: " + createdEmployee.get(key));
//		});
//
//		createdEmployee.values().forEach(value -> {
//			System.out.println("Employee Name: " + value);
//			System.out.println("Employee ID: " + getKeyByValue(createdEmployee, value));
//
//
//		});
////
////		List<String> adminPermissions = (List<String>) ((Map<String, Map<String, List<String>>>) createdEmployee.get("roles")).getOrDefault("admin", (Map<String, List<String>>) Collections.emptyList());
////
////		List<String> filteredPermissions = adminPermissions.stream()
////				.filter(permission -> permission.equals("Campaign Approver") || permission.equals("DR Admin"))
////				.collect(Collectors.toList());
////		System.out.println(filteredPermissions);
//
////		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>.");
////		createdEmployee.entrySet().stream().filter(i->i.getValue().roles.contains("Campaign Approver")).collect(Collectors.toList());
//
//
//
//
////		createdEmployee.forEach((key, value) -> System.out.println(key + " = " + value));
////
////		createdEmployee.keySet().forEach(key -> System.out.println(key));
////		createdEmployee.values().forEach(value -> System.out.println(value));
////		createdEmployee.entrySet().forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
////		System.out.println("++++++++++++++++");
//
//		System.out.println(createdEmployee);
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//		mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
//
//		//System.out.println(createdEmployee.get(0).company);
//	//	HashMap<String, Name> mapping =mapper.readValue(createdEmployee, HashMap.class);
//	/*	if (createdEmployee != null) {
//			System.out.println("Employee found: " + too.getName());
//		} else {
//			System.out.println("Employee not found");
//		}*/
//	//	System.out.println(createdEmployee.getName());
//	/*	System.out.println(webClient.get()
//				.uri("/users/list")
//				.exchange()
//				.flatMap(clientResponse -> clientResponse.bodyToMono(String.class))
//				.block());*/
//
//		WebClient client = WebClient.create("https://webapi-uatv2.digitalreef.com/api");
//
//		client.get()
//				.uri("/users/list/")
//				.accept(MediaType.APPLICATION_JSON)
//				.retrieve()
//				.bodyToMono(Map.class)
//				.subscribe(user -> {
//					Map<String, Name> roles = (Map<String, Name>) user.get("roles");
//					Name adminName = roles.get("admin");
//					Map<String, List<String>> adminRoles = (Map<String, List<String>>) adminName.getRoles();
//
//					System.out.println(adminRoles);
//				});


//		WebClient webClient = WebClient.create("https://webapi-uatv2.digitalreef.com/api");
//	String createdEmployee = webClient.get()
//				.uri("/users/list/")
//		.headers(httpHeaders -> {
//				httpHeaders.add("Authorization", "Token 1d0252e761494b4196937bd5b5529ddc17b46448");
//				httpHeaders.add("organization","5a294f81993c8f1570c2550d");
//			})
//			.retrieve().bodyToMono(String.class).block();
//		System.out.println(createdEmployee);
		}

	}
