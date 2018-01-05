package de.verhext.overwolfscanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Config {

  public String BOT_NAME;
  public String IP;
  public int VirtualServerID;
  public String QUsername;
  public String QPassword;
  public int QPort;
  public int ServerGroup;
  public boolean IgnoreClientIcons;


  public Config() {
    this.BOT_NAME = "Overwolf-Scanner";
    this.IP = "ts.example.de";
    this.VirtualServerID = 1;
    this.QUsername = "admin";
    this.QPassword = "secert";
    this.QPort = 10011;
    this.ServerGroup = 141;
    this.IgnoreClientIcons = true;
  }

  private static Config instance;

  public static Config getInstance() {
    if (instance == null) {
      instance = fromDefaults();
    }
    return instance;
  }

  public static void load(File file) {
    instance = fromFile(file);

    // no helper file found
    if (instance == null) {
      instance = fromDefaults();
    }
  }

  public static void load(String file) {
    load(new File(file));
  }

  private static Config fromDefaults() {
    Config config = new Config();
    return config;
  }

  public void toFile(String file) {
    toFile(new File(file));
  }

  public void toFile(File file) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String jsonConfig = gson.toJson(this);
    FileWriter writer;
    try {
      writer = new FileWriter(file);
      writer.write(jsonConfig);
      writer.flush();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static Config fromFile(File configFile) {
    try {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      BufferedReader reader = new BufferedReader(new InputStreamReader(
        new FileInputStream(configFile)));
      return gson.fromJson(reader, Config.class);
    } catch (FileNotFoundException e) {
      return null;
    }
  }

  @Override
  public String toString() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.toJson(this);
  }
}

