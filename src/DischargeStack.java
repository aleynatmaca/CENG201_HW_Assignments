import java.util.Date;

public class DischargeStack {
    NodeStack top;
    public DischargeStack() {
        top = null;
    }
    public void push(DischargeRecord record){
        NodeStack newNode = new NodeStack(record);
        newNode.next = top;
        top = newNode;
        }
    public void pop() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return;
        }
        DischargeRecord record = top.data;
        System.out.println("Discharge Record: " + record.patientId);
        top = top.next;
        return;
    }
    public void peek() {
        if (top == null) {
            System.out.println("Stack is empty!");
        }
        DischargeRecord record = top.data;
        System.out.println("Discharge Record: " + record.patientId);
    }
    public void printStack() {

        if (top == null) {
            System.out.println("Stack is empty!");
            return;
        }
        NodeStack current = top;

        while (current != null) {
            Date date = new Date(current.data.dischargeTime);

            System.out.println("PatientID: " + current.data.patientId + " | Discharged Time: " + date);

            current = current.next;
        }
        }
    }

