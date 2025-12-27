import java.util.Date;
public class TreatmentQueue {
    private int size =0;
    TreatmentNode front;
    TreatmentNode rear;

    TreatmentQueue(){
        front=null;
        rear=null;
    }
    public void enqueue(TreatmentRequest request){
        TreatmentNode newNode = new TreatmentNode(request);
        if(front==null){
            front =newNode;
            rear=newNode;
        }
        else{
            rear.next=newNode;
            rear=newNode;
        }
        size++;
        return;

    }

    public TreatmentRequest dequeue() {
        if(front==null){
            System.out.println("Queue is empty");
            return null;

        }
        TreatmentRequest remove = front.data;
        front = front.next;
        if (front==null){
            rear=null;
        }
        size--;
        return remove;

    }
    public boolean isEmpty() {
        return front == null;
    }


    public int size(){

        return size;
    }

    public void printQueue() {

        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }

        TreatmentNode current = front;

        while (current != null) {
            Date date =new Date(current.data.arrivalTime);

            System.out.println("PatientID: " + current.data.patientId + " | Arrival Time: " + date);

            current = current.next;
        }

    }
}
