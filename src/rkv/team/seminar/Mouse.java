package rkv.team.seminar;

import java.io.IOException;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ScrollView;
import android.widget.TextView;

public class Mouse extends Activity {

private int initX =0;
private int initY =0;
private int disX =0;
private int disY =0;
private boolean mouseMoved=false;
TextView mousePad;
ScrollView scrollbar;
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.mouse);
	mousePad = (TextView)findViewById(R.id.mousepad);
	//scrollbar= (ScrollView)findViewById(R.id.scrollbar);
	
	
	
    //capture finger taps and movement on the textview
	mousePad.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			try {
				SocketThread.ops.writeUTF("CLICK");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	
	
    mousePad.setOnTouchListener(new View.OnTouchListener() {
       
		public boolean onTouch(View v, MotionEvent event) {
			 switch(event.getAction()){
             case MotionEvent.ACTION_DOWN:
                 //save X and Y positions when user touches the TextView
                 initX =(int) event.getX();
            initY =(int) event.getY();
                 mouseMoved=false;
                 break;
                 
             case MotionEvent.ACTION_MOVE:
                 disX = (int) (event.getX()- initX); //Mouse movement in x direction
                 disY = (int) (event.getY()- initY); //Mouse movement in y direction
                 /*set init to new position so that continuous mouse movement
                 is captured*/
                 initX = (int) event.getX();
                 initY = (int) event.getY();
                 if(disX !=0|| disY !=0){
                	 try {
						SocketThread.ops.writeUTF("MOUSE "+disX +" "+ disY);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
                     //send mouse movement to server
                 }
                 mouseMoved=true;
                 break;
            /* case MotionEvent.ACTION_UP:
                 //consider a tap only if usr did not move mouse after ACTION_DOWN
                 if(!mouseMoved){
                	 try {
						SocketThread.ops.writeUTF("LEFT_CLICK");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
                    // out.println(Constants.MOUSE_LEFT_CLICK);
                 }
         */}
     
     return true;
		}
    });
	
}

public void onRight(View v){
	try {
		SocketThread.ops.writeUTF("RIGHT_CLICK");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void onLeft(View v){
	try {
		SocketThread.ops.writeUTF("CLICK");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
