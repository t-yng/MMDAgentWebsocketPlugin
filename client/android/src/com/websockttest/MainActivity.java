package com.websockttest;

import javax.net.ssl.SSLContext;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIO;
import io.socket.SocketIOException;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity implements MMDAgentMessageCallbackAdapter{

	SocketIO socket;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try {
			SocketIO.setDefaultSSLSocketFactory(SSLContext.getDefault());
			socket = new SocketIO();
			socket.connect("http://192.168.0.2:3000/", new MMDAgentMessageCallback(this));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void on(String event, JSONObject data) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void onConnect() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void onDisconnect() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void onError(SocketIOException arg0) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void onMessage(String message) {
		Log.d("onMesagge", message);
	}

	@Override
	public void onMessage(JSONObject json) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
