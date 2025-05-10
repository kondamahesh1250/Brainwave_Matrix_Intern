package com.hospital;
import java.util.Scanner;

public class HospitalManagementSystems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hospital hospital = new Hospital();

        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. Add Health Record");
            System.out.println("4. Generate Bill");
            System.out.println("5. Manage Inventory");
            System.out.println("6. Manage Staff");
            System.out.println("7. Display Patients");
            System.out.println("8. View Appointments by Patient ID");
            System.out.println("9. View Health Records by Patient ID");
            System.out.println("10. View Bill by Patient ID");
            System.out.println("11. View Staff Details");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: hospital.registerPatient(sc); break;
                case 2: hospital.scheduleAppointment(sc); break;
                case 3: hospital.addHealthRecord(sc); break;
                case 4: hospital.generateBill(sc); break;
                case 5: hospital.manageInventory(sc); break;
                case 6: hospital.manageStaff(sc); break;
                case 7: hospital.displayPatients(); break;
                case 8: hospital.viewAppointmentsById(sc); break;
                case 9: hospital.viewHealthRecordsById(sc); break;
                case 10: hospital.viewBillById(sc); break;
                case 11: hospital.viewStaff(); break;
                case 12: System.out.println("Thank You!"); System.exit(0);
                default: System.out.println("Invalid option");
            }
        }
    }
}