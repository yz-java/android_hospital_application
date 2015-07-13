package frontend;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import backend.Nurse;
import backend.Patient;
import backend.VitalSigns;

import com.example.hospitalapplication.R;

public class PatientView extends Activity implements OnClickListener{
	
	Patient patient;
	Nurse nurse = new Nurse();
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	
	ArrayList<String> displayVS = new ArrayList<String>();
	ArrayAdapter<String> VSListAdapter;
	private ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patient_view);
		
		// Get Patient from previous activity
		patient = (Patient) getIntent().getSerializableExtra("PatientKey");
		
		// Setup Patient General Information
		TextView name = (TextView) findViewById(R.id.TVname);
		name.setText("Patient Name: "+patient.getName());
		TextView HCN = (TextView) findViewById(R.id.TVhcn);
		HCN.setText("Health Card Number: "+patient.getHcn());
		TextView DOB = (TextView) findViewById(R.id.TVdob);
		DOB.setText("Date of Birth: "+patient.getDob());
		TextView ArrivalTime = (TextView) findViewById(R.id.TVarrivaltime);
		ArrivalTime.setText("Arrival Time: "+dateformat.format(patient.getAdmissionDate()));
		
		// Setup OnClickListener
		Button updateVS = (Button) findViewById(R.id.BTupdate_vital_signs);
		updateVS.setOnClickListener(this);
		
		// Setup List of Vital Signs
		displayVS.add(" ");
		lv = (ListView) findViewById(R.id.LISTvitalSigns);
		Iterator<Map.Entry<Date, VitalSigns>> ITvitalsigns = patient.getVitalSignsMap().entrySet().iterator();
		if (ITvitalsigns.hasNext())
			displayVS.clear();
		while (ITvitalsigns.hasNext()){
			Entry<Date, VitalSigns> VSSet = ITvitalsigns.next();
			displayVS.add(dateformat.format(VSSet.getValue().getTimeOfRecording())+" "+VSSet.getValue().toString());
		}
		VSListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, displayVS);
		lv.setAdapter(VSListAdapter);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()){
			case R.id.BTupdate_vital_signs:
				// Retrieve all fields from EditText
				EditText Temperature = (EditText) findViewById(R.id.ETtemperature);
				EditText BPSystolic = (EditText) findViewById(R.id.ETSystolicBP);
				EditText BPDiastolic = (EditText) findViewById(R.id.ETDiastolicBP);
				EditText HeartRate = (EditText) findViewById(R.id.ETHeartRate);
				// Call backend function
				VitalSigns vitalsigns = nurse.updateVitalSigns(patient, 
						Double.parseDouble(Temperature.getText().toString()), 
						Integer.parseInt(BPSystolic.getText().toString()), 
						Integer.parseInt(BPDiastolic.getText().toString()), 
						Integer.parseInt(HeartRate.getText().toString()));
				
				// Clear EditTexts
				Temperature.setText("");
				BPSystolic.setText("");
				BPDiastolic.setText("");
				HeartRate.setText("");
				// Update List of VitalSigns
				displayVS.add(dateformat.format(vitalsigns.getTimeOfRecording())+
						" "+vitalsigns.toString());
				VSListAdapter.notifyDataSetChanged();
				System.out.println("SIZE"+patient.getVitalSignsMap().size());
		}
	}
	
	
}
