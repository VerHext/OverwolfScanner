/**
 * 
 */
package de.verhext.overwolf.main;



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
public class Main {
	
	
	  public static void main(String[] args) {
			
		  //Link Clas
	Connect con = new Connect();
	Config cfg = new Config();
	Engine engine = new Engine();
	
	
	
	cfg.create();
	showLogoOnStartUp();
	engine.log(1,1, "Starting bot... ");
	//cfg.createConfig();

	con.connectToServer(cfg.getString(Config.IP), cfg.getInt(Config.Port), cfg.getInt(Config.QPort),  cfg.getString(Config.QUsername), cfg.getString(Config.QPassword));
	//	con.connectToServer(cfg.getString("IP"), cfg.getString("Port"), cfg.getString("QueryUsername"), cfg.getString("QueryPassword"));
	
	
	  }
	  
	  
	  public static void showLogoOnStartUp(){
		  System.out.println("");
		  System.out.println("+----------------------------------------------------------------------------------------------------+");
		  System.out.println("|                      Overwolf - Set all Usern without Overwolf a Servergroup                       |");
		  System.out.println("|                                         © 2017 VerHext                                             |");
		  System.out.println("+----------------------------------------------------------------------------------------------------+");
		  System.out.println("");
	  }  

}
