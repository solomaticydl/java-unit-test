package holiday;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class HolidayTest {

    private HolidayForTest holiday;

    @Before
    public void setUp() throws Exception {
        holiday = new HolidayForTest();
    }

    @Test
    public void today_is_xmas() {
        givenToday(12, 25);
        sayHelloShouldBe("Merry Christmas");
    }

    private void sayHelloShouldBe(String expected) {
        assertEquals(expected, holiday.sayHello());
    }

    private void givenToday(int month, int dayOfMonth) {
        holiday.today = LocalDate.of(2000, month, dayOfMonth);
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
