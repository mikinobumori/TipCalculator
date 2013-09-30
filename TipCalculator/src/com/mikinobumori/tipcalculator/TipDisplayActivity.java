package com.mikinobumori.tipcalculator;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class TipDisplayActivity extends Activity implements OnClickListener 
{
	TextView total_tv;
	ImageView pondelion_iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_display);
		
		Intent previousIntent = this.getIntent(); //gets intent from previous activity
		int previousTotal = previousIntent.getIntExtra("total_label", 0);
		
		total_tv = (TextView) this.findViewById(R.id.tip_display_total_tv);
		total_tv.setText(String.valueOf(previousTotal)); //sets textview to total stored in value that was passed in from previous activity
		pondelion_iv = (ImageView) this.findViewById(R.id.tip_display_iv);
		pondelion_iv.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_display, menu);
		return true;
	}

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		if (v.getId() == R.id.tip_display_iv)
		{
			playSound();
		}

	}
	
	public void playSound()
	{
		MediaPlayer mp = MediaPlayer.create(this, R.raw.sexy);
		mp.start();
	}

}
