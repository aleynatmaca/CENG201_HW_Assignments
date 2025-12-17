public class TreatmentRequest {
    int patientId;
    long arrivalTime;
    boolean priority;
    int severity;



    public TreatmentRequest(int patientId) {
        this.patientId = patientId;
        this.priority = false;
        this.severity = 0;
        arrivalTime = System.currentTimeMillis();
    }
    public TreatmentRequest(int patientId, boolean priority) {
        this.patientId = patientId;
        this.priority = priority;
        this.severity = 0;
        this.arrivalTime = System.currentTimeMillis();
    }
}
