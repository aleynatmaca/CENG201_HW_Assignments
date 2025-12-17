public class DischargeRecord {
    int patientId;
    long dischargeTime;
    public DischargeRecord(int patientId) {
        this.patientId = patientId;
        dischargeTime = System.currentTimeMillis();

    }
}
