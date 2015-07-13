package backend;

import java.io.Serializable;
import java.util.Date;

/**
 * A representation of VitalSigns which includes temperature, blood pressure, and heart rate.
 * @author SeongMinJeong, JunaidPatel, EricCyr, JackYiu, YiChenZhu
 *
 */

public class VitalSigns implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 279724511585928900L;
	private Date recordTime;
	private double temperature;
	private BloodPressure bloodPressure;
	private int heartRate;
	
	/**
	 * Creates a new VitalSigns with the given temperature. heart rate, systolicBP and diastolicBP for the blood pressure.
	 * @param temperature
	 * @param heartRate
	 * @param systolicBP
	 * @param diastolicBP
	 */
	public VitalSigns(double temperature, BloodPressure bloodPressure, int heartRate) {
		this.recordTime = new Date();
		this.temperature = temperature;
		this.bloodPressure = bloodPressure;
		this.heartRate = heartRate;
	}

	/**
	 * Returns recorded time for this VitalSigns.
	 * @return this VitalSigns's recorded time.
	 */
	public Date getTimeOfRecording() {
		return recordTime;
	}
	
	/**
	 * Returns temperature for this VitalSigns.
	 * @return this VitalSigns's temperature.
	 */
	public double getTemperature() {
		return temperature;
	}
	
	/**
	 * Returns blood pressure for this VitalSigns.
	 * @return this VitalSigns's blood pressure.
	 */
	public BloodPressure getBloodPressure() {
		return bloodPressure;
	}
	
	/**
	 * Returns heart rate for this VitalSigns.
	 * @return this VitalSigns's heart rate.
	 */
	public int getHeartRate() {
		return heartRate;
	}
	
	/**
	 * Returns a string representation of this VitalSigns.
	 */
	public String toString() {
		String resultVS = "[" + temperature + ", " + 
				bloodPressure.toString() + ", " + heartRate + "]";
		return resultVS;
	}
	
}
