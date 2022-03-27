package holiday;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class HolidayTest {

    @Test
    public void today_is_xmas() {
        HolidayForTest holiday = new HolidayForTest();
        holiday.today = LocalDate.of(2000, 12, 25);
        assertEquals("Merry Christmas", holiday.sayHello());
    }

    // Extract and Override
    // 建立SUT子類別模擬SUT
    private static class HolidayForTest extends Holiday {
        private LocalDate today;

        @Override
        protected LocalDate getToday() {
            return today;
        }

        public void setToday(LocalDate today) {
            this.today = today;
        }
    }
}
