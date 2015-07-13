package backend;

import java.util.HashMap;
import java.util.Map;

/**
 * Master HashMap of all patients.
 * @author SeongMinJeong, JunaidPatel, EricCyr, JackYiu, YiChenZhu
 *
 */
public class HospitalRecord {
	// Maps HealthCardNumber to Patient Object
	private static Map<String, Patient> listofPatients= new HashMap<String, Patient>();

	/**
	 * Constructor for a hospital record. Takes no parameters
	 */
	public HospitalRecord() {
	}
	
	/**
	 * Returns the list of patients 
	 * @return The list of patients
	 */
	public static Map<String, Patient> getListOfPatients(){
		return listofPatients;
	}
	/**
	 * Adds a patient to the master list
	 * @param newPatient The patient to be added
	 */
	public static void addPatientToList(Patient newPatient) {
		listofPatients.put(Integer.toString(newPatient.getHcn()), newPatient);
	}
}
