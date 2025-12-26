public class PatientListTestClass {
    public static void main(String[] args) {
        System.out.println("------ TASK 1------");
        PatientList patientList = new PatientList();
        Patient p1 = new Patient(101, "ALİ", 5, 65);
        Patient p2 = new Patient(102, "AYŞE", 8, 15);
        Patient p3 = new Patient(103, "FATMA", 4, 42);
        Patient p4 = new Patient(104, "SEMA", 6, 28);
        Patient p5 = new Patient(105, "AHMET", 7, 33);

        patientList.addPatient(p1);
        patientList.addPatient(p2);
        patientList.addPatient(p3);
        patientList.addPatient(p4);
        patientList.addPatient(p5);

        patientList.printList();
        System.out.println("----------------------");
        System.out.println("Patient 104 is deleting now");
        patientList.removePatient(104);
        patientList.printList();
        System.out.println("Patient 104 is deleted");

        System.out.println("---------------------");
        Patient found = patientList.findPatient(103);

        if (found != null) {
            System.out.println("Patient found: " + found.name);
        } else {
            System.out.println("Not found.");
        }
        System.out.println("---------------------");
        System.out.println("FINAL LIST:");
        patientList.printList();
    }
}
