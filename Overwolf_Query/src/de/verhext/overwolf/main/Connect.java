/**
 * 
 */
package de.verhext.overwolf.main;



import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;


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
public class Connect {

	
	Engine engine = new Engine();
	
	final TS3Config config = new TS3Config();
	 final TS3Query query = new TS3Query(config);
	 final TS3Api api = query.getApi();
	 Config cfg = new Config();

		public void connectToServer(String IP, int port, int qPort,  String qUsername, String qPassword){
			
		
			
			config.setHost(IP);
			config.setQueryPort(qPort);
		
			
			engine.log(1, 1, "Connect...");
			//Conectet.
			query.connect();
			api.login(qUsername, qPassword);
			api.selectVirtualServerByPort(port);
			api.setNickname(cfg.getString(Config.BOT_NAME));
			engine.log(1, 1, "Connect successfull!");
			api.registerAllEvents();
			api.addTS3Listeners(new TSListener(api));

				
	
		}			
			
}
