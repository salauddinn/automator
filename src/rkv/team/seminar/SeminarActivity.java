package rkv.team.seminar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.text.Editable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SeminarActivity extends Activity {
	EditText ip,user,port,pwd;
	String ip2;
	static int conn=-1;
	static String ss=null;
	
	/** Called when the activity is first created. */
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ip=(EditText)findViewById(R.id.ip);
    
        port=(EditText)findViewById(R.id.port);
               
        user=(EditText)findViewById(R.id.username);
      
        pwd=(EditText)findViewById(R.id.password);
       
    }
    
   
    public void connect(View v){
    	SocketThread st;
        ip2=ip.getText().toString();
			try {
				st = new SocketThread(ip2,Integer.parseInt(port.getText().toString()),user.getText().toString(),pwd.getText().toString());
				
				st.start();
				
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			if(conn==1){
				Intent home=new Intent("rkv.team.seminar.HOME");
				startActivity(home);
				Toast.makeText(this, "Connected",
						   Toast.LENGTH_SHORT).show();}
			else {
				Toast.makeText(this, "Unknown host",
						   Toast.LENGTH_SHORT).show();
			}
			
				
		
    }
   public void onClear(View v){
	   ip.setText("");
	   port.setText("");
	   user.setText("");
	   pwd.setText("");
   }
        
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		finish();
	}

    
}