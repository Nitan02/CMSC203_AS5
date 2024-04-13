import java.util.Arrays;

/*
 * Class: CMSC203 
 * Instructor:Ashique Tanveer
 * Description: (Give a brief description for each Class)
 * Due: 04/013/2024
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Touch Nitan
*/

public class HolidayBonus {
    private static final double HIGH_BONUS = 5000.0; // Bonus for highest sales
    private static final double LOW_BONUS = 1000.0;  // Bonus for lowest sales
    private static final double OTHER_BONUS = 2000.0; // Bonus for other sales

    /**
     * Calculates the holiday bonus for each store
     * @param data the two-dimensional array of store sales
     * @return an array of the bonus for each store
     */
    
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            double highestSales = TwoDimRaggedArrayUtility.getHighestInArray(data[i]);
            double lowestSales = TwoDimRaggedArrayUtility.getLowestInArray(data[i]);
            double totalBonus = 0;
            for (double sale : data[i]) {
                if (sale == highestSales) totalBonus += HIGH_BONUS;
                else if (sale == lowestSales) totalBonus += LOW_BONUS;
                else totalBonus += OTHER_BONUS;
            }
            bonuses[i] = totalBonus;
        }
        return bonuses;
    }

    /**
     * Calculates the total holiday bonuses
     * @param data the two-dimensional array of store sales
     * @return the total of all holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double total = 0;
        double[] bonuses = calculateHolidayBonus(data);
        for (double bonus : bonuses) {
            total += bonus;
        }
        return total;
    }
}