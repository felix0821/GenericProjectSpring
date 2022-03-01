package com.system.demo.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.system.demo.exception.ApiDniNotFoundException;

@Component
public class ApiQueriesUtility {
	
	//Api consumida de https://ruc.com.pe/tokens
	public String[] checkDniRucPe(String dni) throws Exception {
		String data[]= {"NaN","NaN","NaN"};
		URL url;
		try {
			url = new URL("https://ruc.com.pe/api/v1/consultas");
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setRequestMethod("POST");
			http.setDoOutput(true);
			http.setRequestProperty("Content-Type", "application/json");
			http.setRequestProperty("Accept", "application/json");
			String token = "122e8c23-68e0-4553-8511-dfd5e0a89e27-2394a875-4d82-4e56-8a07-d1d1c36d8ba1";
			String jsonInputString = "{\"token\":\""+token+"\", \"dni\":\""+dni+"\"}";

			byte[] out = jsonInputString.getBytes(StandardCharsets.UTF_8);

			OutputStream stream = http.getOutputStream();
			stream.write(out);
			try(BufferedReader br = new BufferedReader(
					  new InputStreamReader(http.getInputStream(), "utf-8"))) {
					    StringBuilder response = new StringBuilder();
					    String responseLine = null;
					    while ((responseLine = br.readLine()) != null) {
					        response.append(responseLine.trim());
					    }
					    //Extraemos el objeto json del 'response'
				    	JSONObject jo = new JSONObject(response.toString());
				    	String fullName = jo.get("nombre_completo").toString();
				    	int position = 0;
				    	int breakBucle = 2;
				    	//Distribuir informacion recibida
				    	for (int i=0;i<fullName.length();i++){
				    		if(breakBucle==0){
				    			System.out.println(fullName.substring(position));
				    			data[breakBucle]=fullName.substring(position);
				    			break;
				    		}
				    		if(Character.compare(fullName.charAt(i), ' ') == 0){
				    			System.out.println(fullName.substring(position,i));
				    			data[breakBucle]=fullName.substring(position,i);
				    			position=i+1;
				    			breakBucle--;
				    		}
				    	}
					}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("Error de parseo");
			}
			http.disconnect();
		} catch (MalformedURLException e1) {
			System.out.println("Error de conexion");
		}
		return data;
	}
	
	//Api consumida de https://api-peru.com/
	public String[] checkDniApiPeru(String dni) throws Exception, ApiDniNotFoundException {
		String data[]= {"Sin nombres","Sin apellido paterno","Sin apellido materno","2000-01-01","X"};
		URL url;
		try {
			url = new URL("https://consulta.api-peru.com/api/dni/"+dni);
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.setRequestMethod("GET");
			http.setDoOutput(true);
			http.setRequestProperty("Content-Type", "application/json");
			http.setRequestProperty("Accept", "application/json");
			try(BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "utf-8"))) {
					    StringBuilder response = new StringBuilder();
					    String responseLine = null;
					    while ((responseLine = br.readLine()) != null) {
					        response.append(responseLine.trim());
					    }
					    //Extraemos el objeto json del 'response'
					    JSONObject jo = new JSONObject(response.toString());
					    JSONObject jos = jo.getJSONObject("data");
					    data[0] = jos.getString("nombres").toString();
					    data[1] = jos.getString("apellido_paterno").toString();
					    data[2] = jos.getString("apellido_materno").toString();
					    data[3] = jos.getString("fecha_nacimiento").toString();
					    data[4] = jos.getString("sexo").toString();
			} catch(Exception e){
				e.printStackTrace();
				System.out.println("Error de parseo");
				throw new ApiDniNotFoundException("Dni incorrecto");
			}
			http.disconnect();
		} catch (MalformedURLException e1) {
			System.out.println("Error de conexion");
		}
		return data;
	}
	

}
