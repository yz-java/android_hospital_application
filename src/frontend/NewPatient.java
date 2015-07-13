package frontend;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import backend.Nurse;

import com.example.hospitalapplication.R;


public class NewPatient extends Activity implements OnClickListener{
	
	EditText nameText, dobText, hcnText, ageText;
	Nurse nurse = new Nurse();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_patient_dialog);
		
		nameText = (EditText) findViewById(R.id.NameText);
		dobText = (EditText) findViewById(R.id.DobText);
		hcnText = (EditText) findViewById(R.id.HcnText);
		ageText = (EditText) findViewById(R.id.AgeText);
		
		Button submit = (Button) findViewById(R.id.btn_custom_alert_ok);
	    submit.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btn_custom_alert_ok:
			
			String name = nameText.getText().toString();
			String dob = dobText.getText().toString();
			int hcn = Integer.parseInt(hcnText.getText().toString());
			int age = Integer.parseInt(ageText.getText().toString());
			
			nurse.recordPatientData(name, dob, hcn, age);
			Intent mainScreen = new Intent(this, HomeScreen.class);
			startActivity(mainScreen);
		}
	}
	
	
}

