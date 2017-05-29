package rkv.team.seminar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.net.Socket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Presentation extends Activity {
	
	 Socket socket=null;
	 private ObjectInputStream ips=null;
	 private DataOutputStream ops=null;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ppt);
		socket=SocketThread.socket;
		
		ops=SocketThread.ops;	
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		
	}
	
	
	
	public void onPrevious(View v) throws IOException{
	//	ops.writeUTF((SocketThread.username+"@"+SocketThread.pwd));
		
		
		SocketThread.ops.writeUTF("PREVIOUS");	
		//SocketThread.ops.writeUTF("SCREEN");
		

	}
	public void onNext(View v) throws IOException{
	//	ops.writeUTF((SocketThread.username+"@"+SocketThread.pwd));
		SocketThread.ops.writeUTF("NEXT");
		
	}
	public void onFullscreen(View v) throws IOException{
	//	ops.writeUTF((SocketThread.username+"@"+SocketThread.pwd));
		ToggleButton fs=(ToggleButton) findViewById(R.id.Fullscreen);
		if(fs.isChecked()){
			SocketThread.ops.writeUTF("FULL_SCREEN");
		}
		else{
			SocketThread.ops.writeUTF("OFF_SCREEN");
		}
		
		
	}
	public void onDisconnect(View v){
		SeminarActivity.conn=0;
	Intent newsemninar=new Intent(this,SeminarActivity.class);
	startActivity(newsemninar);
	/*	
		try {
			socket.close();
			SeminarActivity.conn=0;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	finish();
		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		 switch (item.getItemId()) {
	        case android.R.id.home:
	            // app icon in action bar clicked; go home
	            Intent intent = new Intent(this, Home.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            finish();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}


}
