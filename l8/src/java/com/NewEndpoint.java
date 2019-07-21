/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author MD-Aseef
 */
@ServerEndpoint("/NewEndpoint")
public class NewEndpoint {
    static Set<Session> chatRoom=Collections.synchronizedSet(new HashSet<Session>());
    @OnOpen
    public void handleOpen(Session userSession){
        chatRoom.add(userSession);
        System.out.println("opened");
    }
    
    @OnMessage
    public void handleMessage(String message,Session userSession) throws IOException {
        String username=(String)userSession.getUserProperties().get("username");
        System.out.println("In Message"+username);
        if(username==null){
            System.out.println("In deep Message:"+message);
            userSession.getUserProperties().put("username",message);
            userSession.getBasicRemote().sendText("Hello you are connected");
        }
        else{
            System.out.println("In Message2");
            Iterator<Session> iterator=chatRoom.iterator();
            while(iterator.hasNext()){
                iterator.next().getBasicRemote().sendText(username+":"+message);
            }
        }
        
    }
    @OnClose
    public void handleClose(Session userSession){
        chatRoom.remove(userSession);
    }
}


