package holiday;

import java.time.LocalDate;

public class Holiday {

    public String sayHello() {
        LocalDate today = LocalDate.now();
        if (today.getMonthValue() == 12 && today.getDayOfMonth() == 25) {
            return "Merry Christmas";
        }
        return "Today is not Christmas";
    }
}
