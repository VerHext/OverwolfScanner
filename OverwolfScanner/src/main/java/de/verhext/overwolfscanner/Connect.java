package de.verhext.overwolfscanner;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.exception.TS3ConnectionFailedException;

public class Connect {


  Engine engine = new Engine();

  final TS3Config config = new TS3Config();
  final TS3Query query = new TS3Query(config);
  final TS3Api api = query.getApi();
  Config cfg = new Config();

  public void connectToServer(String IP, int qPort,  String qUsername, String qPassword){

    config.setHost(IP);
    config.setQueryPort(qPort);

    engine.log(1, 1, "Connect...");
    //Conectet.
    try
    {
      query.connect();
    }catch(TS3ConnectionFailedException e)
    {
      engine.log(1,1,"Connection FAILED!");
    }

    api.login(qUsername, qPassword);
    api.selectVirtualServerById(Config.getInstance().VirtualServerID);
    api.setNickname(Config.getInstance().BOT_NAME);
    engine.log(1, 1, "Connect successfull!");
    api.registerAllEvents();
    api.addTS3Listeners(new de.verhext.overwolfscanner.TSListener(api));
  }

}
