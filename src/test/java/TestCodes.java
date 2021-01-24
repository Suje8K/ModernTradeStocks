import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TestCodes {
    public static void main(String[] args) {
//        System.out.println(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        TestCodes t1 = new TestCodes();
        URL historical_data = t1.getClass().getClassLoader().getResource("historical_data");
        if (historical_data != null) {
            System.out.println(historical_data.getPath());
            File fl = new File(historical_data.getPath().concat("/lksdjflksjdf.csv"));
        } else {
            System.out.println("OOOPPPPSSSSSSSSSS");
        }
    }
}
