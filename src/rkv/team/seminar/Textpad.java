package rkv.team.seminar;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Textpad extends Activity {

	EditText alert;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textpad);
		alert=(EditText) findViewById(R.id.msg);
		
	}
	
public void onClear(View v){
	
	alert.setText("");
}
public void onAlert(View v){	
try {
	SocketThread.ops.writeUTF("ALERT "+alert.getText().toString());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
Toast.makeText(this,"Alert sent...", Toast.LENGTH_SHORT).show();
}


}
