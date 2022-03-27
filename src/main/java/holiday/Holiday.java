package holiday;

import java.time.LocalDate;

public class Holiday {

    public String sayHello() {
        LocalDate today = getToday();
        if (today.getMonthValue() == 12 && today.getDayOfMonth() == 25) {
            return "Merry Christmas";
        }
        return "Today is not Christmas";
    }

    protected LocalDate getToday() {
        return LocalDate.now();
    }
}
