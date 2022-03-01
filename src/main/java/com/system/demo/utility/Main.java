package com.system.demo.utility;
/*
import static com.system.demo.GenericProjectSystemStatement.ZONE_DATE_LIMA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.prefs.Preferences;

import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.system.demo.exception.ApiDniNotFoundException;
import com.system.demo.persistence.sqlite.ConnectionSQLite;

public class Main extends Thread {
	
	static final String KeyWeb = "KEY_WEB";
    static final String KeyInt = "KEY_INT";
    static final String KeyBoolean = "KEY_BOOLEAN";
    
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    private static ApiQueriesUtility api = new ApiQueriesUtility();
    
    private static final Preferences prefs=Preferences.userRoot().node("system");
    
	public static void main(String[] args) {
		try {
			System.out.println(api.checkDniApiPeru("7728338")[0]);
		} catch(ApiDniNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println(bCryptPasswordEncoder.encode("Admin321"));
		LocalDateTime fechaHoraPeru = LocalDateTime.now(ZoneId.of(ZONE_DATE_LIMA));
		LocalDate fechaPeru=LocalDate.now(ZoneId.of(ZONE_DATE_LIMA));
		fechaHoraPeru.atZone(ZoneId.systemDefault()).toInstant();
		Date dateRegister=Date.from(fechaHoraPeru.atZone(ZoneId.systemDefault()).toInstant());
		System.out.println(dateRegister);
		ConnectionSQLite c = new ConnectionSQLite();
		c.openConnect();
		c.closeConnect();
		Main thread = new Main();
		Main thread1 = new Main();
		Main thread2 = new Main();
	    thread.start();
	    thread2.start();
	    thread1.start();
		try {
			File fileObj = new ClassPathResource("META-INF/preferences.xml").getFile();
			FileInputStream fis = new FileInputStream(fileObj);
			Preferences.importPreferences(fis);
			FileOutputStream fos = new FileOutputStream("src/main/resources/META-INF/preferences.xml");
			String key = "index";
			int i = prefs.getInt(key, 0);
			prefs.putInt(key, i+1);
			//prefs.put("name", "小马哥");
			//prefs.remove(key);
			prefs.exportSubtree(fos);
			
			System.out.println(""+i);
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Preferences preferences = Preferences.systemRoot().node("java-buddy");
        
	}
	
	public void run() {
		try {
			//File fileObj = new ClassPathResource("META-INF/preferences.xml").getFile();
			//FileInputStream fis = new FileInputStream(fileObj);
			//Preferences.importPreferences(fis);
			FileOutputStream fos = new FileOutputStream("src/main/resources/META-INF/preferences.xml");
			String key = "index";
			int i = prefs.getInt(key, 0);
			prefs.putInt(key, i+1);
			prefs.exportNode(fos);
			System.out.println(""+i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    System.out.println("This code is running in a thread");
	  }

}
*/