public class QueueTestClass {
    public static void main(String[] args) {
        System.out.println("------TASK 2: TREATMENT QUEUE------");
        TreatmentQueue queue = new TreatmentQueue();
        queue.enqueue(new TreatmentRequest(101));
        queue.enqueue(new TreatmentRequest(102));
        queue.enqueue(new TreatmentRequest(103));
        queue.enqueue(new TreatmentRequest(104));
        queue.enqueue(new TreatmentRequest(105));
        queue.enqueue(new TreatmentRequest(106));
        queue.enqueue(new TreatmentRequest(107));
        queue.enqueue(new TreatmentRequest(108));

        queue.printQueue();

        System.out.println("----Deleting now----");
        queue.dequeue();

        System.out.println("Size is: " + queue.size());
        queue.dequeue();
        System.out.println("Size is: " + queue.size());
        queue.dequeue();
        System.out.println("Size is: " + queue.size());
        queue.printQueue();

        System.out.println("-------");
    }
}
