import java.text.DateFormat;
        import java.text.SimpleDateFormat;
        import java.util.Date;

public class DoctorVisit {

    public static final DateFormat myTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static String getCurrentDateTime() {
        return myTime.format(new Date());
    }

    public static void main(String[] args) throws InterruptedException {

        Doctor doctor = new Doctor();
        Patient[] pat = new Patient[]{
                new Patient("Patient0", 1),
                new Patient("Patient1", 1),
                new Patient("Patient2", 1),
                new Patient("Patient3", 1),
                new Patient("Patient4", 2),
                new Patient("Patient5", 3),
                new Patient("Patient6", 4),
                new Patient("Patient7", 4)

        };

        doctor.start();
        pat[0].start();
        pat[1].start();
        pat[2].start();
        pat[3].start();
        pat[4].start();
        pat[5].start();
        pat[6].start();
        pat[7].start();
    }
}