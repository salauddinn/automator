package rkv.team.seminar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Home extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	
	super.onCreate(savedInstanceState);
	setContentView(R.layout.home);
	

}
@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		 MenuInflater mf=getMenuInflater();
		 mf.inflate(R.menu.my_menu, menu);
		 return true; 
	}
public void onPresentation(View v){
	if(SeminarActivity.conn==1){
	Intent power=new Intent(this,Presentation.class);
	startActivity(power);}
	else{
		Toast.makeText(this, " Connection lost"+SeminarActivity.conn,
				   Toast.LENGTH_LONG).show();
	}
	
}
public void onMouse(View v){
	if(SeminarActivity.conn==1){
	Intent power=new Intent(this,Mouse.class);
	startActivity(power);}
	else{
		Toast.makeText(this, " Connection lost"+SeminarActivity.conn,
				   Toast.LENGTH_LONG).show();
	}
	
}

public void onServer(View v){
	if(SeminarActivity.conn==1){
	Intent power=new Intent(this,Server.class);
	startActivity(power);}
	else{
		Toast.makeText(this, " Connection lost"+SeminarActivity.conn,
				   Toast.LENGTH_LONG).show();
	}
	
}
public void onShare(View v){
	if(SeminarActivity.conn==1){
	Intent power=new Intent(this,Share.class);
	startActivity(power);}
	else{
		Toast.makeText(this, " Connection lost"+SeminarActivity.conn,
				   Toast.LENGTH_LONG).show();
	}
	
}
public void onShell(View v){
	if(SeminarActivity.conn==1){
	Intent power=new Intent(this,Shell.class);
	startActivity(power);}
	else{
		Toast.makeText(this, " Connection lost"+SeminarActivity.conn,
				   Toast.LENGTH_LONG).show();
	}
	
}
public void onTextpad(View v){
	if(SeminarActivity.conn==1){
	Intent power=new Intent(this,Textpad.class);
	startActivity(power);}
	else{
		Toast.makeText(this, " Connection lost"+SeminarActivity.conn,
				   Toast.LENGTH_LONG).show();
	}
	
}
public void onJoystick(View v){
	if(SeminarActivity.conn==1){
	Intent power=new Intent(this,Joystick.class);
	startActivity(power);}
	else{
		Toast.makeText(this, " Connection lost"+SeminarActivity.conn,
				   Toast.LENGTH_LONG).show();
	}
	
}
public void onMedia(View v){
	if(SeminarActivity.conn==1){
	Intent power=new Intent(this,Media.class);
	startActivity(power);}
	else{
		Toast.makeText(this, " Connection lost"+SeminarActivity.conn,
				   Toast.LENGTH_LONG).show();
	}
	
}

public void onKeyBoard(View v){
	if(SeminarActivity.conn==1){
	Intent power=new Intent(this,Keyboard.class);
	startActivity(power);}
	else{
		Toast.makeText(this, " Connection lost"+SeminarActivity.conn,
				   Toast.LENGTH_LONG).show();
	}
	
}


public void onDisconnect(View v){
	SeminarActivity.conn=0;
	Intent newsemninar=new Intent(this,SeminarActivity.class);
	startActivity(newsemninar);
		
		try {
			SocketThread.socket.close();
			SeminarActivity.conn=0;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	finish();		
}

}
