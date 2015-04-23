package com.websockttest;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIOException;

import org.json.JSONException;
import org.json.JSONObject;

public class MMDAgentMessageCallback implements IOCallback, IOAcknowledge {

	MMDAgentMessageCallbackAdapter callback;
	
	public MMDAgentMessageCallback(MMDAgentMessageCallbackAdapter callback){
		this.callback = callback;
	}
	
	@Override
	public void on(String event, IOAcknowledge ack, Object... data) {
		if(event.equals("message")){
			JSONObject json = (JSONObject)data[0];
			String message = "";
			try {
				message = json.getString("message");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			callback.onMessage(message);
		}
		else{
			callback.on(event, (JSONObject)data[0]);
		}
	}

	@Override
	public void onConnect() {
		callback.onConnect();
	}

	@Override
	public void onDisconnect() {
		callback.onDisconnect();
	}

	@Override
	public void onError(SocketIOException error) {
		callback.onError(error);
	}

	@Override
	public void onMessage(String message, IOAcknowledge arg1) {
//		callback.onMessage(message);
	}

	@Override
	public void onMessage(JSONObject arg0, IOAcknowledge arg1) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void ack(Object... arg0) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
