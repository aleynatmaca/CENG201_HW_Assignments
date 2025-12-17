import java.util.Date;
import java.util.ArrayList;
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

    public void dequeue() {
        if(front==null){
            System.out.println("Queue is empty");
            return;

        }
        TreatmentRequest remove = front.data;
        System.out.println("Patient is deleted: " + "ID: " + remove.patientId);
        front = front.next;
        if (front==null){
            rear=null;
        }
        size--;
        return;

    }
    public TreatmentRequest dequeueAndReturn() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return null;
        }

        TreatmentRequest removed = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;
        return removed;
    }
    public boolean isEmpty() {
        return front == null;
    }


    public ArrayList<TreatmentRequest> drainToList() {
        ArrayList<TreatmentRequest> list = new ArrayList<>();
        while (!isEmpty()) {
            TreatmentRequest r = dequeueAndReturn();
            if (r != null) list.add(r);
        }
        return list;
    }

    public void loadFromList(ArrayList<TreatmentRequest> list) {
        for (TreatmentRequest r : list) {
            enqueue(r);
        }
    }


    public int size(){

        return size;
    }

    public void printQueue() {

        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("----CURRENT LIST----");

        TreatmentNode current = front;

        while (current != null) {
            Date date =new Date(current.data.arrivalTime);

            System.out.println("PatientID: " + current.data.patientId + " | Arrival Time: " + date);

            current = current.next;
        }

    }



}
