package rkv.team.seminar;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class Joystick extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.joystick);
	}

	public void onUp(View v) {
		try {
			SocketThread.ops.writeUTF("UP");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onDown(View v) {
		try {
			SocketThread.ops.writeUTF("DOWN");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onRight(View v) {
		try {
			SocketThread.ops.writeUTF("NEXT");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onLeft(View v) {
		try {
			SocketThread.ops.writeUTF("PREVIOUS");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onSpace(View v) {
		try {
			SocketThread.ops.writeUTF("SPACE");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onEnter(View v) {
		try {
			SocketThread.ops.writeUTF("ENTER");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
