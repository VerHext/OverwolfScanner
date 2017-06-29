/**
 * 
 */
package de.verhext.overwolf.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * @author VerHext
 *
 * @project Overwolf_Query
 *
 * License:
 *
 * Copyright (C) 2017 VerHext <support@allesverhext.de>
 *
 * This work is licensed under the Creative Commons
 *
 * Attribution-NonCommercial-ShareAlike 4.0
 *
 * International License. To view a copy of this license,
 * visit http://creativecommons.org/licenses/by-nc-sa/4.0/.
 *
 */
public class Config {
	public static final String BOT_NAME = "BOT_NAME";
	public static final String IP = "IP";
	public static final String Port = "PORT";
	public static final String QUsername = "QUsername";
	public static final String QPassword = "QPassword";
	public static final String QPort = "QPort";
	public static final String ServerGroup = "ServerGroup";


	File file = new File("Overwolf//settings//config.yml");
	File ordner = new File ("Overwolf//settings//");
	 FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);


	public void create()
	{
		if (!ordner.exists()){
			ordner.mkdirs();
		}
		if (!file.exists()){
			try {
					
					cfg.addDefault("BOT_NAME", "Overwolf-Scanner");
					cfg.addDefault("IP", "ts.example.de");
					cfg.addDefault("PORT", 9987);
					cfg.addDefault("QUsername", "admin");
					cfg.addDefault("QPassword", "password");
					cfg.addDefault("QPort", 10011);
					cfg.addDefault("ServerGroup", 141);
					cfg.options().copyDefaults(true);
					cfg.save(file);
					
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void saveConfig()
	{
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addString(String key, String value)
	{
		cfg.set(key, value);
		saveConfig();
	}

	public void addInt(String key, int value)
	{
		cfg.set(key, value);
		saveConfig();
	}

	public void addBoolean(String key, boolean value)
	{
		cfg.set(key, value);
		saveConfig();
	}

	public String getString (String key)
	{
		return cfg.getString(key);
	}

	public int getInt (String key)
	{
		return cfg.getInt(key);
	}




}
