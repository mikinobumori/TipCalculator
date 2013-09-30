package com.mikinobumori.tipcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener 
{
	
	//This is a change that was created by tom
	
	TextView person1;
	TextView person2;
	TextView person3;
	
	EditText item1, item2, item3, tip;
//miki does something
	
	Button calc;
	
	//miki does another thing
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        person1 = (TextView) this.findViewById(R.id.main_person1_tv);
        person2 = (TextView) this.findViewById(R.id.main_person2_tv);
        person3 = (TextView) this.findViewById(R.id.main_person3_tv);
        
        item1 = (EditText) this.findViewById(R.id.main_item1_et);
        item2 = (EditText) this.findViewById(R.id.main_item2_et);
        item3 = (EditText) this.findViewById(R.id.main_item3_et);
        tip = (EditText) this.findViewById(R.id.main_tip_percent_et);
        
        calc = (Button) this.findViewById(R.id.main_calc_b);
        
        person1.setText("Miki");
        person2.setText("Tom");
        person3.setText("Nan");
        
        calc.setOnClickListener(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		if (v.getId() == R.id.main_calc_b)
		{
			
			// convert textfields to integers
			int item1_value = Integer.parseInt(item1.getText().toString());
			int item2_value = Integer.parseInt(item2.getText().toString());
			int item3_value = Integer.parseInt(item3.getText().toString());
			int tip_percent = Integer.parseInt(tip.getText().toString());
			
			double total = (double) (item1_value + item2_value + item3_value); //converting integer to double, so we can do fraction calculations
			
			
			double tip_percent_fraction =  (double) tip_percent / 100; //convert tip percent into a fraction, so we can do calculation
			
			Log.d("tip percent", String.valueOf(tip_percent_fraction));
			
			
			//do some math to start calculating what percentage each person owes
			
			double person1_percent = item1_value / total;
			double person2_percent = item2_value / total;
			double person3_percent = item3_value / total;
			
			//Log.d allows us to check in our LogCat (that little green icon) tracking tool information that is being handled in the background
			//Unfortunately, it can only display String values, so we need to convert all of our values to strings so it can be displayed in our
			//Logging tool properly
			
			
			//Is Git Working Now???
			Log.d("person one percent is", String.valueOf(person1_percent));
			Log.d("person two percent is", String.valueOf(person2_percent));
			Log.d("person three percent is", String.valueOf(person3_percent));
			
			double tip_amount = tip_percent_fraction * total;
			
			Log.d("calculated tip amount is", String.valueOf(tip_amount));
						
			Intent i = new Intent(this, TipDisplayActivity.class);
			i.putExtra("total_label", total); //send total value to other activity through intent
			this.startActivity(i);
		}
	}
	
	public void calculateTips()
	{
		//we can organize our code here later to calculate tips
	}


    
}
