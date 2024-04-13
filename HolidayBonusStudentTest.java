import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents JUnit test cases for the HolidayBonus class.
 * 
 * @author [Touch Nitan]
 * @version [4/13/24]
 */
public class HolidayBonusStudentTest {

    private double[][] dataSet1 = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalculateHolidayBonusA() {
        try {
            double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
            assertEquals(8000.0, result[0], .001);
            assertEquals(6000.0, result[1], .001);
            assertEquals(8000.0, result[2], .001);
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }

    }

    @Test
    public void testCalculateTotalHolidayBonusA() {
        assertEquals(22000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
    }
}