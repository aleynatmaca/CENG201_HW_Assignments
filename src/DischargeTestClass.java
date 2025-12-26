public class DischargeTestClass {
    public static void main(String[] args) {
        System.out.println("------TASK 3------");

        DischargeStack dischargeStack = new DischargeStack();

        dischargeStack.push(new DischargeRecord(101));
        dischargeStack.push(new DischargeRecord(102));
        dischargeStack.push(new DischargeRecord(103));
        dischargeStack.push(new DischargeRecord(104));
        dischargeStack.push(new DischargeRecord(105));

        dischargeStack.printStack();
        System.out.println("-------");
        dischargeStack.pop();
        dischargeStack.pop();
        dischargeStack.printStack();

        System.out.println("-------");
    }
}
