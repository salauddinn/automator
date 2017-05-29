package rkv.team.seminar;
import rkv.team.seminar.R;
import android.app.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Intro extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);		
		RelativeLayout layout=new RelativeLayout(this);
		RelativeLayout.LayoutParams logoDetails=new RelativeLayout.LayoutParams(
			RelativeLayout.LayoutParams.WRAP_CONTENT,
			RelativeLayout.LayoutParams.WRAP_CONTENT
		);
		layout.setBackgroundResource(R.drawable.grunge);
		logoDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
		logoDetails.addRule(RelativeLayout.CENTER_VERTICAL);
		TextView logo=new TextView(this);
		logo.setText("Handy");
		logo.setTextSize(40);
		logo.setTextColor(Color.GREEN);
		layout.addView(logo,logoDetails);
		setContentView(layout);
		Thread timer=new Thread(){
			public void run(){
			try{
				sleep(1000)	;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{				
				Intent sa=new Intent(Intro.this,SeminarActivity.class);
				startActivity(sa);
			}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
