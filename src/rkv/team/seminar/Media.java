package rkv.team.seminar;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class Media extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.media);
	}
	
public void onNext(View v){
	try {
		SocketThread.ops.writeUTF("MNEXT");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void onPrevious(View v){
	try {
		SocketThread.ops.writeUTF("MPREVIOUS");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void onForward(View v){
	try {
		SocketThread.ops.writeUTF("MFORWARD");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void onBackward(View v){
	try {
		SocketThread.ops.writeUTF("MBACKWARD");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void onPlay(View v){
	ToggleButton fs=(ToggleButton) findViewById(R.id.mplay);
	if(fs.isChecked()){
		try {
			SocketThread.ops.writeUTF("MPLAY");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else{
		try {
			SocketThread.ops.writeUTF("MPAUSE");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
}


}
