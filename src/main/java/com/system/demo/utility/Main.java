package com.system.demo.utility;
/*
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.prefs.Preferences;

import org.springframework.core.io.ClassPathResource;

public class Main {
	
	static final String KeyWeb = "KEY_WEB";
    static final String KeyInt = "KEY_INT";
    static final String KeyBoolean = "KEY_BOOLEAN";
    
    private static final Preferences prefs=Preferences.userRoot().node("system");
    
	public static void main(String[] args) {
		
		try {
			//File fileObj = new ClassPathResource("META-INF/preferences.xml").getFile();
			//FileInputStream fis = new FileInputStream(fileObj);
			//Preferences.importPreferences(fis);
			FileOutputStream fos = new FileOutputStream("src/main/resources/META-INF/preferences.xml");
			String key = "index";
			int i = prefs.getInt(key, 0);
			prefs.putInt(key, i+1);
			//prefs.put("name", "小马哥");
			//prefs.remove(key);
			prefs.exportSubtree(fos);
			//prefs.put("name", "HOLA");
			//prefs.exportNode(fos);
			System.out.println(""+i);
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Preferences preferences = Preferences.systemRoot().node("java-buddy");
        
	}

}
*/