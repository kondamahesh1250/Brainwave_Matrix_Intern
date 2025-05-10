package com.hospital;

public class Appointment {
 private int id;
 private String patientName;
 private String doctorName;
 private String date;

 	public Appointment(int id, String patientName, String doctorName, String date) {
 		this.id = id;
 		this.patientName = patientName;
 		this.doctorName = doctorName;
 		this.date = date;
 	}

 	@Override
 	public String toString() {
	return "Appointment [id=" + id + ", patientName=" + patientName + ", doctorName=" + doctorName + ", date=" + date
			+ "]";
 	}
}