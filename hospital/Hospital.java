package com.hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Hospital {
    List<Patient> patients = new ArrayList<>();
    Map<Integer, List<Appointment>> appointments = new HashMap<>();
    List<Staff> staffList = new ArrayList<>();
    Map<Integer, Double> bill = new HashMap<Integer, Double>();
    Map<String, Integer> inventory = new HashMap<>();

    public void registerPatient(Scanner sc) {
    	System.out.print("Enter Id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        patients.add(new Patient(id, name, age, gender));
        System.out.println("Patient registered successfully.");
    }

    public void scheduleAppointment(Scanner sc) {
    	System.out.print("Enter Id: ");
        int id = sc.nextInt();
        sc.nextLine();
        Patient patient = findPatientById(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Enter doctor name: ");
        String doctor = sc.nextLine();
        System.out.print("Enter date (yyyy-mm-dd): ");
        String date = sc.nextLine();
        Appointment newAppt = new Appointment(id, patient.getName(), doctor, date);
        List<Appointment> apptList = appointments.getOrDefault(id, new ArrayList<>());
        apptList.add(newAppt);
        appointments.put(id, apptList);
        System.out.println("Appointment scheduled.");
    }
    
    public void viewAppointmentsById(Scanner sc) {
        System.out.print("Enter patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Patient patient = findPatientById(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        List<Appointment> apptList = appointments.get(id);
        if (apptList == null || apptList.isEmpty()) {
            System.out.println("No appointments found for patient ID: " + id);
            return;
        }

        System.out.println("Appointments for " + patient.getName() + ":");
        for (Appointment appt : apptList) {
            System.out.println(appt);
        }
    }

    public void addHealthRecord(Scanner sc) {
    	System.out.print("Enter Id: ");
        int id = sc.nextInt();
        sc.nextLine();
        Patient patient = findPatientById(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
     
        System.out.print("Enter diagnosis: ");
        String diagnosis = sc.nextLine();
        System.out.print("Enter treatment: ");
        String treatment = sc.nextLine();
        
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(patient.getName()) && p.getId()==id) {
                p.addHealthRecord("Diagnosis: " + diagnosis + ", Treatment: " + treatment);
                System.out.println("Health record added.");
                return;
            }
        }
    }
    
    public void viewHealthRecordsById(Scanner sc) {
        System.out.print("Enter patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Patient patient = findPatientById(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        
        List<String> healthRecords = patient.getHealthRecords();
        if (healthRecords.isEmpty()) {
            System.out.println("No health records found for patient ID: " + id);
        } else {
            System.out.println("Health records for patient ID " + id + ":");
            for (String record : healthRecords) {
                System.out.println(record);
            }
        }
    }

    public void generateBill(Scanner sc) {
    	System.out.print("Enter patient ID: ");
    	int id = sc.nextInt();
    	sc.nextLine();
    	Patient patient = findPatientById(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
     
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(patient.getName()) && p.getId() == id) {
                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();
                System.out.println("Bill generated for " + patient.getName() + " (ID: " + id + "): $" + amount);
                bill.put(id, amount);
                return;
            }
        }
    }
    
    public void viewBillById(Scanner sc) {
        System.out.print("Enter patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Patient patient = findPatientById(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }        
        Double billAmount = bill.get(id);
        
        if (billAmount == null) {
            System.out.println("No bill found for patient ID: " + id);
            return;
        }

        System.out.println("Bill for " + patient.getName() + " (ID: " + id + "): $" + billAmount);
    }

    public void manageInventory(Scanner sc) {
        System.out.print("Enter item name: ");
        String item = sc.nextLine();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();
        sc.nextLine();
        inventory.put(item, inventory.getOrDefault(item, 0) + qty);
        System.out.println("Inventory updated.");
    }

    public void manageStaff(Scanner sc) {
    	System.out.print("Enter Id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter staff name: ");
        String name = sc.nextLine();
        System.out.print("Enter role: ");
        String role = sc.nextLine();
        staffList.add(new Staff(id, name, role));
        System.out.println("Staff added.");
    }
    
    public void viewStaff() {
        if (staffList.isEmpty()) {
            System.out.println("No staff records found.");
            return;
        }

        System.out.println("Staff Details:");
        for (Staff s : staffList) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Role: " + s.getRole());
        }
    }

    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }
        for (Patient p : patients) {
            System.out.println(p);
        }
    }
    
    private Patient findPatientById(int id) {
        for (Patient p : patients) {
            if (p.getId() == id) return p;
        }
        return null;
    }
}