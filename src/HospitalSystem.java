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

    public void addPatient(Patient p) { // Adds the patient to the linked list for ordered traversal
                                        // and stores it in the HashMap for fast access by ID
        patientList.addPatient(p);
        patientMap.put(p.id, p);
    }

    public void addDischargeRecord(DischargeRecord record) {
        dischargeStack.push(record);
    }
    public void addTreatmentRequest(TreatmentRequest req) {
        if (!patientMap.containsKey(req.patientId)) {
            System.out.println("Patient not found: " + req.patientId);
            return;
        }
        if (req.priority) priorityQueue.enqueue(req);
        else normalQueue.enqueue(req);
    }

     // Two separate queues are used for priority and normal treatment requests
    // This design ensures that immediate patients are always processed first
    // while preserving FIFO order within each group
    // If the priority queue is empty requests are taken from the normal queue(I create)

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


