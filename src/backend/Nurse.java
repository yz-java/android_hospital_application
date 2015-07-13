package backend;

public class Nurse {
	
	/**
	 * Empty Constructor
	 */
	public Nurse(){
		
		// Initialize Patient RecordManager.
	}
	
	/**
	 * Creates a new Patient object and stores it in HospitalRecords
	 * @param name name of the patient
	 * @param dob date of birth of the patient 
	 * @param hcn health card number of the patient
	 * @param age age of the patient
	 */
	public void recordPatientData(String name, String dob, int hcn, int age){
		Patient patient = new Patient(name, dob, hcn, age);
		// Add to Hospital Records Master Patient list
		HospitalRecord.addPatientToList(patient);
		// Stores patient object 
	}
	
	/**
	 * Updates the latest Symptoms displayed by a patient.
	 * @param patient the patient 
	 * @param symptom the description of the symptom
	 */
	public void updateSymptoms(Patient patient, String symptom){
		Symptoms symptoms = new Symptoms(symptom);
		patient.addSymptoms(symptoms); // Patient handles writing of symptoms to file.
	}
	
	/**
	 * Updates the latest Vital Sign displayed by a patient
	 * @param patient the patient
	 * @param temperature the temperature of the patient
	 * @param systolicBP the systolic blood pressure of the patient
	 * @param diastolicBP the diastolic blood pressure of the patient
	 * @param heartRate the heartrate of the patient
	 */
	public VitalSigns updateVitalSigns(Patient patient, double temperature, int systolicBP, int diastolicBP, int heartRate){
		BloodPressure bp = new BloodPressure(systolicBP, diastolicBP);
		VitalSigns vs = new VitalSigns(temperature, bp, heartRate);
		patient.addVitalSigns(vs);
		return vs;
	}
	
	/**
	 * Sets time patient has been seen by doctor
	 * @param patient the patient
	 */
	public void setTimeSeenByDoctor(Patient patient){
		patient.setDateSeenByDoctor();
	}
}
