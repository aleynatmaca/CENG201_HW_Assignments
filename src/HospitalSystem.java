import java.util.HashMap;
import java.util.ArrayList;
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

        if (!priorityQueue.isEmpty()) req = priorityQueue.dequeueAndReturn();
        else req = normalQueue.dequeueAndReturn();

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
    private void bubbleSortBySeverityThenArrival(ArrayList<TreatmentRequest> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                TreatmentRequest a = list.get(j);
                TreatmentRequest b = list.get(j + 1);

                int sevA = getPatientSeverity(a.patientId);
                int sevB = getPatientSeverity(b.patientId);

                boolean swap = false;

                if (sevA < sevB) swap = true;
                else if (sevA == sevB && a.arrivalTime > b.arrivalTime) swap = true;

                if (swap) {
                    list.set(j, b);
                    list.set(j + 1, a);
                }
            }
        }
    }
}
