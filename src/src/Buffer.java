import java.util.concurrent.Semaphore;

public class Buffer {
    public static Semaphore patientSemaphore = new Semaphore(0);
    public static Semaphore doctorSemaphore = new Semaphore(0);
    public static Semaphore roomSemaphore = new Semaphore(0);
    public static Semaphore mutex = new Semaphore(1);
    public static int patientCount = 0;
    public static final int MAX = 9;
    //public static String beingVisited;
}