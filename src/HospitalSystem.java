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

    private int getPatientSeverity(int patientId) {
        Patient p = patientMap.get(patientId);
        if (p == null) return 0;
        return p.severity;
    }

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

        System.out.println("\n--- PRIORITY QUEUE ---");
        priorityQueue.printQueue();

        System.out.println("\n--- NORMAL QUEUE ---");
        normalQueue.printQueue();

        System.out.println("\n--- DISCHARGE STACK ---");
        dischargeStack.printStack();

        System.out.println("\n--- patientMap size --- " + patientMap.size());
    }

    public void sortBySeverity() {
        Node current2 = patientList.head;

        while (current2 != null) {
            Node current = patientList.head;
            while (current != null && current.next != null) {
                if (current.data.severity < current.next.data.severity) {
                    Patient temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
            current2 = current2.next;
        }

        System.out.println("-----AFTER SORTING PATIENT LIST BY SEVERITY-----");
        patientList.printList();
    }
}


