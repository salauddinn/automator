package rkv.team.seminar;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Shell extends Activity {
	EditText command;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shell);
		command=(EditText) findViewById(R.id.command);
	}


public void onClear(View v){

command.setText("");
}
public void onExecute(View v){	
try {
SocketThread.ops.writeUTF("SHELL "+command.getText().toString());
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
Toast.makeText(this,"Command is Executing", Toast.LENGTH_SHORT).show();
}
}