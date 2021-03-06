public class Vip extends Thread implements ICustomer {
    private final DancingFloor dancingFloor;
    private boolean isListening=false;

    public Vip(DancingFloor dancingFloor,String name) {
        super(name);
        this.dancingFloor = dancingFloor;
    }

    @Override
    public void listen() {
        try {
            isListening=true;
            Thread.sleep(6000);
            System.out.println(getName() + " is listening");
        } catch (Exception e) {
        }
    }

    @Override
    public void await() {
         try {
             isListening=false;
            Thread.sleep(6000);
            System.out.println(getName() + " is waiting");
        } catch (Exception e) {
        }
    }
    public void run() {
        while (true) {
            int seatNumber = dancingFloor.enter();
            listen();
            dancingFloor.leave(seatNumber);
            System.out.println(Thread.currentThread().getName()+" left");
            await();
        }
    }
}
