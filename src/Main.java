import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
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
        System.out.println("------TASK 2: TREATMENT QUEUE------");
        TreatmentQueue queue = new TreatmentQueue();
        queue.enqueue(new TreatmentRequest(101));
        queue.enqueue(new TreatmentRequest(102));
        queue.enqueue(new TreatmentRequest(103));
        queue.enqueue(new TreatmentRequest(104));
        queue.enqueue(new TreatmentRequest(105));
        queue.enqueue(new TreatmentRequest(106));
        queue.enqueue(new TreatmentRequest(107));
        queue.enqueue(new TreatmentRequest(108));


        queue.printQueue();


        System.out.println("----Deleting now----");
        queue.dequeue();

        System.out.println("Size is: " + queue.size());
        queue.dequeue();
        System.out.println("Size is: " + queue.size());
        queue.dequeue();
        System.out.println("Size is: " + queue.size());
        queue.printQueue();

        System.out.println("-------");
        System.out.println("------TASK 3------");

        DischargeStack dischargeStack = new DischargeStack();

        dischargeStack.push(new DischargeRecord(101));
        dischargeStack.push(new DischargeRecord(102));
        dischargeStack.push(new DischargeRecord(103));
        dischargeStack.push(new DischargeRecord(104));
        dischargeStack.push(new DischargeRecord(105));

        dischargeStack.printStack();
        System.out.println("-------");
        dischargeStack.pop();
        dischargeStack.pop();
        dischargeStack.printStack();

        System.out.println("-------");
        System.out.println("-------TASK 4------");

                HospitalSystem hs = new HospitalSystem();


                hs.addPatient(new Patient(101, "ALİ", 5, 65));
                hs.addPatient(new Patient(102, "AYŞE", 8, 15));
                hs.addPatient(new Patient(103, "FATMA", 4, 42));
                hs.addPatient(new Patient(104, "SEMA", 6, 28));
                hs.addPatient(new Patient(105, "AHMET", 7, 33));
                hs.addPatient(new Patient(106, "MEHMET", 3, 50));
                hs.addPatient(new Patient(107, "ZEYNEP", 9, 10));
                hs.addPatient(new Patient(108, "CAN", 2, 80));
                hs.addPatient(new Patient(109, "ELİF", 6, 25));
                hs.addPatient(new Patient(110, "MERT", 1, 90));


                hs.addTreatmentRequest(new TreatmentRequest(101, false));
                hs.addTreatmentRequest(new TreatmentRequest(102, false));
                hs.addTreatmentRequest(new TreatmentRequest(103, false));
                hs.addTreatmentRequest(new TreatmentRequest(104, false));
                hs.addTreatmentRequest(new TreatmentRequest(105, false));


                hs.addTreatmentRequest(new TreatmentRequest(106, true));
                hs.addTreatmentRequest(new TreatmentRequest(107, true));
                hs.addTreatmentRequest(new TreatmentRequest(108, true));


                hs.addDischargeRecord(new DischargeRecord(109));
                hs.addDischargeRecord(new DischargeRecord(110));

                hs.printSystemState();

                hs.processTreatmentRequest();
                hs.processTreatmentRequest();
                hs.processTreatmentRequest();
                hs.processTreatmentRequest();

                hs.sortBySeverity();




    }

}



