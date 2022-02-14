package com.system.demo.utility;

import java.util.prefs.Preferences;

import org.springframework.stereotype.Component;

@Component
public class PreferenceUtility {
	
	private static final Preferences PREFERENCE=Preferences.userRoot().node("system");
	
	public int getIndex(String key) {
		int index = PREFERENCE.getInt(key, 0);
		PREFERENCE.putInt(key, index+1);
		return index;
	}
}
