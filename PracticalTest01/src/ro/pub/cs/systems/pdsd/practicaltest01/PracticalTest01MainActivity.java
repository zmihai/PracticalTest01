package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PracticalTest01MainActivity extends Activity {

	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	private int activeId = R.id.button_name;
	private String nameString = "Name", emailString = "Email", phoneString = "Phone"; 
	
	private class ButtonClickListener implements Button.OnClickListener {

		@Override
		public void onClick(View view) {
			EditText editText = (EditText)findViewById(R.id.edit_text);
			
			// if name
			if (((Button)findViewById(R.id.button_name)).getText().toString().equals(((Button)view).getText().toString()) && activeId != R.id.button_name) {
				if (activeId == R.id.button_email) {
					emailString = editText.getText().toString();
				}
				
				if (activeId == R.id.button_phone) {
					phoneString = editText.getText().toString();
				}
				
				editText.setText(nameString);
				activeId = R.id.button_name;
					
			}
			
			// if email
			if (((Button)findViewById(R.id.button_email)).getText().toString().equals(((Button)view).getText().toString()) && activeId != R.id.button_email) {
				if (activeId == R.id.button_name) {
					nameString = editText.getText().toString();
				}
				
				if (activeId == R.id.button_phone) {
					phoneString = editText.getText().toString();
				}
				
				editText.setText(emailString);
				activeId = R.id.button_email;
				
			}
			
			// if phone
			if (((Button)findViewById(R.id.button_phone)).getText().toString().equals(((Button)view).getText().toString()) && activeId != R.id.button_phone) {
				if (activeId == R.id.button_name) {
					nameString = editText.getText().toString();
				}
				
				if (activeId == R.id.button_email) {
					emailString = editText.getText().toString();
				}
				
				editText.setText(phoneString);
				activeId = R.id.button_phone;
				
			}
		}
		
	}
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        
        Button nameButton = (Button) findViewById(R.id.button_name);
        nameButton.setOnClickListener(buttonClickListener);
        
        Button emailButton = (Button) findViewById(R.id.button_email);
        emailButton.setOnClickListener(buttonClickListener);
        
        Button phoneButton = (Button) findViewById(R.id.button_phone);
        phoneButton.setOnClickListener(buttonClickListener);
    }
    
    @Override
    protected void onRestart() {
    	super.onRestart();
    }

    @Override
    protected void onStart() {
    	super.onStart();
    }

    @Override
    protected void onResume() {
    	super.onResume();
    }

    @Override
    protected void onPause() {
    	super.onPause();
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    }
    
    protected void onSaveInstanceState(Bundle instanceState) {
    	super.onSaveInstanceState(instanceState);
    	
		instanceState.putString("name", nameString);
		instanceState.putString("email", emailString);
		instanceState.putString("phone", phoneString);
		instanceState.putInt("active", activeId);
    }
    
    protected void onRestoreInstanceState(Bundle instanceState) {
    	super.onRestoreInstanceState(instanceState);
    	
    	if (instanceState != null) {
    		EditText editText = (EditText) findViewById(R.id.edit_text);
    		
    		nameString = instanceState.getCharSequence("name").toString();
    		emailString = instanceState.getCharSequence("email").toString();
    		phoneString = instanceState.getCharSequence("phone").toString();
    		activeId = instanceState.getInt("active");
    		
    		if (activeId == R.id.button_name) {
    			editText.setText(instanceState.getCharSequence("name"));
    		} else if (activeId == R.id.button_name) {
    			editText.setText(instanceState.getCharSequence("email"));
    		} else {
    			editText.setText(instanceState.getCharSequence("phone"));
    		}
    		
    	}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
