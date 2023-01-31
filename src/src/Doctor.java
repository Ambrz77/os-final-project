public class Doctor extends Thread {
    @Override
    public void run() {
        while (Buffer.patientCount < Buffer.MAX) {
            try {
                //while (true) {
                    Thread.sleep(2000);

                    Buffer.patientSemaphore.acquire();
                    Buffer.mutex.acquire();
                    System.out.println("The doctor acquires the lock.");
                    Buffer.patientCount--;

                    Buffer.doctorSemaphore.release();
                    System.out.println("The doctor visited the mentioned patient in " + DoctorVisit.getCurrentDateTime() );
                    //Thread.interrupted();
                    Buffer.mutex.release();
                    System.out.println("The doctor releases the lock."+ "\n");

                    Buffer.roomSemaphore.release();

                //}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}