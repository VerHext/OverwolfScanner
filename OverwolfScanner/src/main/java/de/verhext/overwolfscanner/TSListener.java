/**
 *
 */
package de.verhext.overwolfscanner;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.api.event.ChannelCreateEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDeletedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDescriptionEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelPasswordChangedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientLeaveEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.PrivilegeKeyUsedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ServerEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.TS3Listener;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.ServerGroup;


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
public class TSListener implements TS3Listener {

  Engine engine = new Engine();
  Config cfg = new Config();

  /* (non-Javadoc)
     * @see com.github.theholywaffle.teamspeak3.api.event.TS3Listener#onChannelCreate(com.github.theholywaffle.teamspeak3.api.event.ChannelCreateEvent)
     */
  @Override
  public void onChannelCreate(ChannelCreateEvent arg0) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
     * @see com.github.theholywaffle.teamspeak3.api.event.TS3Listener#onChannelDeleted(com.github.theholywaffle.teamspeak3.api.event.ChannelDeletedEvent)
     */
  @Override
  public void onChannelDeleted(ChannelDeletedEvent arg0) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
     * @see com.github.theholywaffle.teamspeak3.api.event.TS3Listener#onChannelDescriptionChanged(com.github.theholywaffle.teamspeak3.api.event.ChannelDescriptionEditedEvent)
     */
  @Override
  public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent arg0) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
     * @see com.github.theholywaffle.teamspeak3.api.event.TS3Listener#onChannelEdit(com.github.theholywaffle.teamspeak3.api.event.ChannelEditedEvent)
     */
  @Override
  public void onChannelEdit(ChannelEditedEvent arg0) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
     * @see com.github.theholywaffle.teamspeak3.api.event.TS3Listener#onChannelMoved(com.github.theholywaffle.teamspeak3.api.event.ChannelMovedEvent)
     */
  @Override
  public void onChannelMoved(ChannelMovedEvent arg0) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
     * @see com.github.theholywaffle.teamspeak3.api.event.TS3Listener#onChannelPasswordChanged(com.github.theholywaffle.teamspeak3.api.event.ChannelPasswordChangedEvent)
     */
  @Override
  public void onChannelPasswordChanged(ChannelPasswordChangedEvent arg0) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
     * @see com.github.theholywaffle.teamspeak3.api.event.TS3Listener#onClientJoin(com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent)
     */
  @Override
  public void onClientJoin(ClientJoinEvent ev) {
    updateOverwolf(ev.getClientDatabaseId(), ev.getClientId());



  }

  /* (non-Javadoc)
     * @see com.github.theholywaffle.teamspeak3.api.event.TS3Listener#onClientLeave(com.github.theholywaffle.teamspeak3.api.event.ClientLeaveEvent)
     */
  @Override
  public void onClientLeave(ClientLeaveEvent arg0) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
     * @see com.github.theholywaffle.teamspeak3.api.event.TS3Listener#onClientMoved(com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent)
     */
  @Override
  public void onClientMoved(ClientMovedEvent arg0) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
     * @see com.github.theholywaffle.teamspeak3.api.event.TS3Listener#onPrivilegeKeyUsed(com.github.theholywaffle.teamspeak3.api.event.PrivilegeKeyUsedEvent)
     */
  @Override
  public void onPrivilegeKeyUsed(PrivilegeKeyUsedEvent arg0) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
     * @see com.github.theholywaffle.teamspeak3.api.event.TS3Listener#onServerEdit(com.github.theholywaffle.teamspeak3.api.event.ServerEditedEvent)
     */
  @Override
  public void onServerEdit(ServerEditedEvent arg0) {
    // TODO Auto-generated method stub

  }

	/* (non-Javadoc)
	 * @see com.github.theholywaffle.teamspeak3.api.event.TS3Listener#onTextMessage(com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent)
	 */

  private TS3Api api;
  public TSListener(TS3Api api) {
    this.api = api;
  }




  @Override
  public void onTextMessage(TextMessageEvent ev) {

    // TODO Auto-generated method stub


  }

  public void updateOverwolf(int id, int idd){

    String overwolf = api.getClientInfo(idd).get("client_badges");


    overwolf = overwolf.replace("overwolf=" , "");
    overwolf = overwolf.replace("Overwolf=" , "");

    if (Config.getInstance().IgnoreClientIcons == true)
    {
      if (userUseClientIcon(idd))
      {
        return;
      }

    }

    if(overwolf.startsWith("1")){
      //OVERWOLF
      for( ServerGroup Sid: api.getServerGroupsByClientId(id) )
      {
        if (Sid.getId() == Config.getInstance().ServerGroup){
          api.removeClientFromServerGroup(Config.getInstance().ServerGroup, id);
          engine.log(0, 1, "Remove Placeholder from Client " + api.getClientInfo(idd).getNickname());
        }
      }
      engine.log(0, 1, "Client " + api.getClientInfo(idd).getNickname() + " use Overwolf.");
    }else{
      //NO OVERWOLF
      boolean setOverwolf = true;
      for( ServerGroup Sid: api.getServerGroupsByClientId(id) )
      {
        if (Sid.getId() == Config.getInstance().ServerGroup){
          setOverwolf = false;
        }
      }
      if (setOverwolf)
      {
        engine.log(0, 1, "Set Client " + api.getClientInfo(idd).getNickname()+ " Overwolf Placeholder.");
        api.addClientToServerGroup(Config.getInstance().ServerGroup, id);
      }

    }
  }

  public boolean userUseClientIcon(int clientID)
  {
    long id = api.getClientInfo(clientID).getIconId();
    if (id == 0)
    {
      return false;
    }else{
      engine.log(1,1,"User clientID: " + id);
      return true;
    }
  }
}
