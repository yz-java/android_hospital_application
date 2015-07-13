package frontend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import backend.HospitalRecord;
import backend.Nurse;
import backend.Patient;

import com.example.hospitalapplication.R;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class HomeScreen extends Activity implements OnItemClickListener, OnClickListener{

	ArrayList<String> displayHCN = new ArrayList<String>();
	ArrayList<String> HCNList = new ArrayList<String>();
	ArrayList<Patient> PatientList = new ArrayList<Patient>();
	ArrayAdapter<String> ListAdapter;
	String[] HCNArray;
	Patient[] PatientArray;
	private ListView lv;
	EditText inputSearch;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_screen);
		
		// Setup New Patient button
		Button newpatient = (Button) findViewById(R.id.BTnewpatient);
		newpatient.setOnClickListener(this);
		
		// Setup List Adapters and List View
		lv = (ListView) findViewById(R.id.list);
		inputSearch = (EditText) findViewById(R.id.inputSearch);
		displayHCN.add(" "); // Empty placeholder.
		ListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, displayHCN);
		lv.setAdapter(ListAdapter);
		lv.setOnItemClickListener(this);
		
		// Setup Patient Search Function
		inputSearch.addTextChangedListener(new TextWatcher(){
			public void onTextChanged(CharSequence cs, int arg1, int arg2,
					int arg3) {
				// When user changed the Text
				HomeScreen.this.ListAdapter.getFilter().filter(cs);
			}

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
			}

			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
			}
		});
		
		// Initialize ListView with patient data.
		System.out.println("Passed 1");
		
		Iterator<Map.Entry<String, Patient>> listofpatients = HospitalRecord.getListOfPatients().entrySet().iterator();
		while (listofpatients.hasNext()){
			Entry<String, Patient> currentRecord = listofpatients.next();
			HCNList.add(currentRecord.getKey());
			PatientList.add(currentRecord.getValue());
			System.out.println("Passed 2");
		}
		HCNArray = HCNList.toArray(new String[HCNList.size()]);
		PatientArray = PatientList.toArray(new Patient[PatientList.size()]);
		displayHCN.clear();
		displayHCN.addAll(HCNList);
		ListAdapter.notifyDataSetChanged();
		System.out.println("Passed 3");
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		Intent patientView = new Intent(this, PatientView.class);
		patientView.putExtra("PatientKey", PatientArray[position]);
		startActivity(patientView);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.BTnewpatient:
			Intent intent = new Intent(this, NewPatient.class);
			startActivity(intent);
		}
	}

}
