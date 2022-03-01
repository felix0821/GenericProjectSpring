package com.system.demo.utility;

import java.util.prefs.Preferences;

import org.springframework.stereotype.Component;

@Component
public class PreferenceUtility {
	
	private static final Preferences PREFERENCE=Preferences.userRoot().node("system");
	
	public int getIndex(String key) {
		int index = PREFERENCE.getInt(key, 1);
		PREFERENCE.putInt(key, index+1);
		return index;
	}
	
//	¬Metodos para mostrar valor
	public String getStringByKey(String key) {
		return PREFERENCE.get(key, null);
	}
	
	public int getIntByKey(String key) {
		return PREFERENCE.getInt(key, 0);
	}
	
	public double getDoubleByKey(String key) {
		return PREFERENCE.getDouble(key, 0);
	}
	
//	¬Metodos para guardar valor
	public void setStringByKey(String key, String value) {
		PREFERENCE.put(key, value);
	}
	
	public void setIntByKey(String key, int value) {
		PREFERENCE.putInt(key, value);
	}
	
	public void setDoubleByKey(String key, double value) {
		PREFERENCE.putDouble(key, value);
	}
}
