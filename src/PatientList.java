public class PatientList {
    Node head;

    public void addPatient(Patient p) { //add a new patient
        Node newNode = new Node(p); //create the object for add patient
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void removePatient(int id) {

        if (head == null) {
            return;
        }
        if (head.data.id == id) {
            head = head.next;
            return;
        }
        Node current = head;
        Node previous = null;

        while (current != null && current.data.id != id) {
            previous = current;
            current = current.next;

        }
        previous.next = current.next;
    }

    public Patient findPatient(int id) {
        if (head == null) {
            return null;
        }
        Node current = head;
        while (current != null) {
            if (current.data.id == id) {
                return current.data;
            }
            current = current.next;

        }
        return null;

    }

    public void printList() { //print information
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println("ID: " + current.data.id + " " +
                     "Name: " + current.data.name +  " "+
                     "Age: " + current.data.age + " " +
                    "Severity: " + current.data.severity);
            current = current.next;

        }

    }

}
