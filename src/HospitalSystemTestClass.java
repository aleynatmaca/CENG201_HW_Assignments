public class HospitalSystemTestClass {
    public static void main(String[] args) {
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
