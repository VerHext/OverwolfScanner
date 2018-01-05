package de.verhext.overwolfscanner;

public class Main {


  public static void main(String[] args) {

    Connect con = new Connect();
    Config cfg = new Config();
    Engine engine = new Engine();

    engine.log(1,1,"Loading the config file (...)");
    Config.load("config.json");
    Config.getInstance().toFile("config.json");
    showLogoOnStartUp();
    engine.log(1,2, "Starting bot (...) ");
    con.connectToServer(Config.getInstance().IP,Config.getInstance().QPort,Config.getInstance().QUsername,Config.getInstance().QPassword);


  }
  public static void showLogoOnStartUp(){
    System.out.println("");
    System.out.println("+----------------------------------------------------------------------------------------------------+");
    System.out.println("|                      Overwolf - Set all Usern without Overwolf a Servergroup or Icon               |");
    System.out.println("|                                         2018 VerHext                                               |");
    System.out.println("+----------------------------------------------------------------------------------------------------+");
    System.out.println("");
  }

}
