import java.nio.BufferUnderflowException;

public class Patient extends Thread {

    private String patientName;
    private int entryTime;

    public Patient(String name, int time) {
        super(name);
        patientName = name;
        entryTime = time;
    }

    @Override
    public void run() {

        try {

            Thread.sleep(entryTime * 1000);
            System.out.println("PATIENT " + patientName + " GETS IN THE ROOM WITH ENTRY TIME OF " + entryTime + "s");

            Buffer.mutex.acquire();
            System.out.println("The patient" + patientName + " acquires the lock.\n");
            if (Buffer.patientCount < Buffer.MAX) {
                Buffer.patientCount = Buffer.patientCount + 1;
                Buffer.patientSemaphore.release();
                Buffer.mutex.release();
                Buffer.doctorSemaphore.acquire();
                Buffer.roomSemaphore.acquire();
                //Buffer.beingVisited = patientName;
            } else {
                Buffer.mutex.release();
                System.out.println("Not enough seats, plz go out Mr."+ patientName + " :)\n");
            }
/*              System.out.println("ENTRY TIME IS" + entryTime + " AND NAME IS: " + patientName);

                Buffer.patientSemaphore.acquire();
                //Buffer.doctorSemaphore.acquire();

                if (Buffer.doctorSemaphore.availablePermits() == 1)

                Buffer.patientSemaphore.release();
                System.out.println("Patient1 got in the room as doctor's " + Buffer.patientCount + "th patient, in " + DoctorVisit.getCurrentDateTime() + "\n");*/


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Buffer.patientCount == 0)
            System.out.println("Nobody left in waiting room ...\n");
/*            Buffer.doctorSemaphore.release();

            if (Buffer.doctorSemaphore.availablePermits() == 0)
                System.out.println("The last patient releases the lock.");*/

    }
}