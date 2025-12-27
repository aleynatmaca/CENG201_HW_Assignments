import java.util.HashMap;
public class HospitalSystem {
    private PatientList patientList;
    private TreatmentQueue treatmentQueue;
    private DischargeStack dischargeStack;
    private HashMap<Integer, Patient> patientMap;
    TreatmentQueue priorityQueue;
    TreatmentQueue normalQueue;

    public HospitalSystem() {
        this.patientList = new PatientList();
        this.treatmentQueue = new TreatmentQueue();
        this.dischargeStack = new DischargeStack();
        this.patientMap = new HashMap<>();
        this.priorityQueue = new TreatmentQueue();
        this.normalQueue = new TreatmentQueue();
    }

    public void addPatient(Patient p) {
        patientList.addPatient(p);
        patientMap.put(p.id, p);
    }

    public void addDischargeRecord(DischargeRecord record) {
        dischargeStack.push(record);
    }

//    private int getPatientSeverity(int patientId) {
//        Patient p = patientMap.get(patientId);
//        if (p == null) return 0;
//        return p.severity;
//    }

    public void addTreatmentRequest(TreatmentRequest req) {
        if (!patientMap.containsKey(req.patientId)) {
            System.out.println("Patient not found: " + req.patientId);
            return;
        }
        if (req.priority) priorityQueue.enqueue(req);
        else normalQueue.enqueue(req);
    }

    public void processTreatmentRequest() {
        TreatmentRequest req;

        if (!priorityQueue.isEmpty()) req = priorityQueue.dequeue();
        else req = normalQueue.dequeue();

        if (req == null) return;

        dischargeStack.push(new DischargeRecord(req.patientId));
        System.out.println("Processed: " + req.patientId + " priority=" + req.priority);
    }

    public void printSystemState() {
        System.out.println("\n--- PATIENT LIST ---");
        patientList.printList();

        System.out.println("\n--- PRIORITY TREATMENT REQUESTS ---");
        priorityQueue.printQueue();

        System.out.println("\n--- NORMAL TREATMENT REQUESTS ---");
        normalQueue.printQueue();

        System.out.println("\n--- DISCHARGE RECORDS ---");
        dischargeStack.printStack();

        System.out.println("\n--- Patient Map Size --- " + patientMap.size());
    }


    public void sortSeverity() {
        Node c = patientList.head;

        while (c != null) {
            Node current = patientList.head;
            while (current != null && current.next != null) {
                if (current.data.severity < current.next.data.severity) {
                    Patient p1 = current.data;
                    current.data = current.next.data;
                    current.next.data = p1;
                }
                current = current.next;
            }
            c = c.next;
        }

        System.out.println("-----PATIENT LIST AFTER SORT-----");
        patientList.printList();
    }
}


