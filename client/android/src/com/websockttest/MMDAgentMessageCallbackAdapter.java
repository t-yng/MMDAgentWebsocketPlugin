package com.websockttest;

import io.socket.SocketIOException;

import org.json.JSONObject;

public interface MMDAgentMessageCallbackAdapter  {
	public void on(String event, JSONObject data);
	public void onConnect();
	public void onDisconnect();
	public void onError(SocketIOException arg0);
	public void onMessage(String message);
	public void onMessage(JSONObject json);
}
