package backend;

import java.io.Serializable;
import java.util.Date;

/**
 * Symptoms Object that stores a description of a patient's
 * symptom for a given date and time.
 * @author jack
 *
 */
public class Symptoms implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4364661452977383234L;
	private Date timeOfRecording;
	private String descriptionOfSymptoms;

	/**
	 * Constructor for this Symptoms object
	 * @param descriptionOfSymptoms description of a patient's symptoms
	 */
	public Symptoms(String descriptionOfSymptoms) {
		this.descriptionOfSymptoms = descriptionOfSymptoms;
		timeOfRecording = new Date();
	}
	
	/**
	 * Gets the time at which this Symptoms was observed/recorded
	 * @return timeOfRecording as a Date object
	 */
	public Date getTimeOfRecording(){
		return timeOfRecording;
	}
	
	/**
	 * Gets the description of the patient's Symptoms
	 * @return descriptionOfSymptoms
	 */
	public String getdescriptionOfSymptoms(){
		return descriptionOfSymptoms;
	}
	
	/**
	 * Returns a String representation of this Symptoms object as
	 * the time of recording and a description of their symptoms.
	 */
	public String toString(){
		return timeOfRecording + ":\n" + descriptionOfSymptoms;
	}
	
}
