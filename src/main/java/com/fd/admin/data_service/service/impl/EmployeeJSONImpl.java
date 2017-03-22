package com.fd.admin.data_service.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import com.fd.admin.data_service_api.EmployeeJSON;
import com.fd.admin.model.json.Address;
import com.fd.admin.model.json.Employee;

public class EmployeeJSONImpl implements EmployeeJSON {

	public static final String FILE_NAME = "employee.json";
	public static final String JSON_FILE="employee.json";
	
	@Override
	public void employeeJSONGenerator() throws FileNotFoundException {
		OutputStream fos = new FileOutputStream("emp_stream.json");
		JsonGenerator jsonGenerator = Json.createGenerator(fos);
		/**
		 * We can get JsonGenerator from Factory class also
		 * JsonGeneratorFactory factory = Json.createGeneratorFactory(null);
		 * jsonGenerator = factory.createGenerator(fos);
		 */
		
		Employee emp = createEmployee();
		jsonGenerator.writeStartObject(); // {
		jsonGenerator.write("id", emp.getId()); // "id":123
		jsonGenerator.write("name", emp.getName());
		jsonGenerator.write("role", emp.getRole());
		jsonGenerator.write("permanent", emp.isPermanent());
		
		jsonGenerator.writeStartObject("address") //start of address object
			.write("street", emp.getAddress().getStreet())
			.write("city",emp.getAddress().getCity())
			.write("zipcode",emp.getAddress().getZipcode())
			.writeEnd(); //end of address object
		
		jsonGenerator.writeStartArray("phoneNumbers"); //start of phone num array
		for(long num : emp.getPhoneNumbers()){
			jsonGenerator.write(num);
		}
		jsonGenerator.writeEnd(); // end of phone num array
		jsonGenerator.writeEnd(); // }
		
		jsonGenerator.close();
	}

	@Override
	public void employeeJSONParser() throws IOException {
		
		InputStream fis = new FileInputStream(FILE_NAME);

		JsonParser jsonParser = Json.createParser(fis);

		/**
		 * We can create JsonParser from JsonParserFactory also with below code
		 * JsonParserFactory factory = Json.createParserFactory(null);
		 * jsonParser = factory.createParser(fis);
		 */

		Employee emp = new Employee();
		Address address = new Address();
		String keyName = null;
		List<Long> phoneNums = new ArrayList<Long>();
		
		while (jsonParser.hasNext()) {
			Event event = jsonParser.next();
			switch (event) {
			case KEY_NAME:
				keyName = jsonParser.getString();
				break;
			case VALUE_STRING:
				setStringValues(emp, address, keyName, jsonParser.getString());
				break;
			case VALUE_NUMBER:
				setNumberValues(emp, address, keyName, jsonParser.getLong(), phoneNums);
				break;
			case VALUE_FALSE:
				setBooleanValues(emp, address, keyName, false);
				break;
			case VALUE_TRUE:
				setBooleanValues(emp, address, keyName, true);
				break;
			case VALUE_NULL:
				// don't set anything
				break;
			default:
				// we are not looking for other events
			}
		}
		emp.setAddress(address);
		long[] nums = new long[phoneNums.size()];
		int index = 0;
		for(Long l :phoneNums){
			nums[index++] = l;
		}
		emp.setPhoneNumbers(nums);
		
		System.out.println(emp);
		
		//close resources
		fis.close();
		jsonParser.close();
		
	}

	@Override
	public void employeeJSONReader() throws IOException {
		
		InputStream fis = new FileInputStream(JSON_FILE);
		
		//create JsonReader object
		JsonReader jsonReader = Json.createReader(fis);
		
		/**
		 * We can create JsonReader from Factory also
		JsonReaderFactory factory = Json.createReaderFactory(null);
		jsonReader = factory.createReader(fis);
		*/
		
		//get JsonObject from JsonReader
		JsonObject jsonObject = jsonReader.readObject();
		
		//we can close IO resource and JsonReader now
		jsonReader.close();
		fis.close();
		
		//Retrieve data from JsonObject and create Employee bean
		Employee emp = new Employee();
		
		emp.setId(jsonObject.getInt("id"));
		emp.setName(jsonObject.getString("name"));
		emp.setPermanent(jsonObject.getBoolean("permanent"));
		emp.setRole(jsonObject.getString("role"));
		
		//reading arrays from json
		JsonArray jsonArray = jsonObject.getJsonArray("phoneNumbers");
		long[] numbers = new long[jsonArray.size()];
		int index = 0;
		for(JsonValue value : jsonArray){
			numbers[index++] = Long.parseLong(value.toString());
		}
		emp.setPhoneNumbers(numbers);
		
		//reading inner object from json object
		JsonObject innerJsonObject = jsonObject.getJsonObject("address");
		Address address = new Address();
		address.setStreet(innerJsonObject.getString("street"));
		address.setCity(innerJsonObject.getString("city"));
		address.setZipcode(innerJsonObject.getInt("zipcode"));
		emp.setAddress(address);
		
		//print employee bean information
		System.out.println(emp);
		
	}

	@Override
	public void employeeJSONWriter() throws FileNotFoundException {
		
		Employee emp = createEmployee();

		JsonObjectBuilder empBuilder = Json.createObjectBuilder();
		JsonObjectBuilder addressBuilder = Json.createObjectBuilder();
		JsonArrayBuilder phoneNumBuilder = Json.createArrayBuilder();

		for (long phone : emp.getPhoneNumbers()) {
			phoneNumBuilder.add(phone);
		}
		
		addressBuilder.add("street", emp.getAddress().getStreet())
						.add("city", emp.getAddress().getCity())
							.add("zipcode", emp.getAddress().getZipcode());
		
		empBuilder.add("id", emp.getId())
					.add("name", emp.getName())
						.add("permanent", emp.isPermanent())
							.add("role", emp.getRole());
		
		empBuilder.add("phoneNumbers", phoneNumBuilder);
		empBuilder.add("address", addressBuilder);
		
		JsonObject empJsonObject = empBuilder.build();
		
		System.out.println("Employee JSON String\n"+empJsonObject);
		
		//write to file
		OutputStream os = new FileOutputStream("emp.json");
		JsonWriter jsonWriter = Json.createWriter(os);
		/**
		 * We can get JsonWriter from JsonWriterFactory also
		JsonWriterFactory factory = Json.createWriterFactory(null);
		jsonWriter = factory.createWriter(os);
		*/
		jsonWriter.writeObject(empJsonObject);
		jsonWriter.close();
		
	}
	
	private Employee createEmployee() {

		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("David");
		emp.setPermanent(false);
		emp.setPhoneNumbers(new long[] { 123456, 987654 });
		emp.setRole("Manager");

		Address add = new Address();
		add.setCity("Bangalore");
		add.setStreet("BTM 1st Stage");
		add.setZipcode(560100);
		emp.setAddress(add);

		return emp;
	}
	
	private void setStringValues(Employee emp, Address address,String key, String value) {
		switch(key){
		case "name":
			emp.setName(value);
			break;
		case "role":
			emp.setRole(value);
			break;
		case "city":
			address.setCity(value);
			break;
		case "street":
			address.setStreet(value);
			break;
		default:
			System.out.println("Unkonwn Key="+key);
				
		}
	}
	
	private void setBooleanValues(Employee emp, Address address,String key, boolean value) {
		if("permanent".equals(key)){
			emp.setPermanent(value);
		}else{
			System.out.println("Unknown element with key="+key);
		}
	}
	
	private void setNumberValues(Employee emp, Address address,
			String keyName, long value, List<Long> phoneNums) {
		switch(keyName){
		case "zipcode":
			address.setZipcode((int)value);
			break;
		case "id":
			emp.setId((int) value);
			break;
		case "phoneNumbers":
			phoneNums.add(value);
			break;
		default:
			System.out.println("Unknown element with key="+keyName);	
		}
	}

}
