import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

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

public final class TwoDimRaggedArrayUtility {
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int rows = 0;

        while (scanner.hasNextLine()) {
            scanner.nextLine();
            rows++;
        }
        scanner.close();

        double[][] array = new double[rows][];
        scanner = new Scanner(file);
        for (int i = 0; i < rows; i++) {
            String[] values = scanner.nextLine().split(" ");
            array[i] = new double[values.length];
            for (int j = 0; j < values.length; j++) {
                array[i][j] = Double.parseDouble(values[j]);
            }
        }
        scanner.close();
        return array;
    }

    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(outputFile);
        for (double[] row : data) {
            for (double value : row) {
                writer.print(value + " ");
            }
            writer.println();
        }
        writer.close();
    }

    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    public static double getAverage(double[][] data) {
        double total = getTotal(data);
        int count = 0;
        for (double[] row : data) {
            count += row.length;
        }
        return total / count;
    }

    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        for (double value : data[row]) {
            total += value;
        }
        return total;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data) {
            if (col < row.length) {
                total += row[col];
            }
        }
        return total;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double max = Double.MIN_VALUE;
        for (double value : data[row]) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        double max = Double.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > max) {
                max = data[row][i];
                index = i;
            }
        }
        return index;
    }

    public static double getLowestInRow(double[][] data, int row) {
        double min = Double.MAX_VALUE;
        for (double value : data[row]) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public static int getLowestInRowIndex(double[][] data, int row) {
        double min = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < min) {
                min = data[row][i];
                index = i;
            }
        }
        return index;
    }

    public static double getHighestInColumn(double[][] data, int columnIndex) {
        double max = Double.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (columnIndex < data[i].length && data[i][columnIndex] > max) {
                max = data[i][columnIndex];
                index = i;
            }
        }
        return max;
    }

    public static int getHighestInColumnIndex(double[][] data, int col) {
        int index = 0;
        double highest = 0;
        int row = 0;
        while (highest == 0) {
            if (data[row].length > col) {
                highest = data[row][col];
                index = row;
            }
            row++;
        }
        while (row < data.length) {
            if (data[row].length > col) {
                if (data[row][col] > highest) {
                    highest = data[row][col];
                    index = row;
                }
            }
            row++;
        }
        return index;
    }

    public static double getLowestInColumn(double[][] data, int columnIndex) {
        double min = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (columnIndex < data[i].length && data[i][columnIndex] < min) {
                min = data[i][columnIndex];
                index = i;
            }
        }
        return min;
    }

    public static int getLowestInColumnIndex(double[][] data, int col) {
        int index = 0;
        double lowest = 0;
        int row = 0;
        while (lowest == 0) {
            if (data[row].length > col) {
                lowest = data[row][col];
                index = row;
            }
            row++;
        }
        while (row < data.length) {
            if (data[row].length > col) {
                if (data[row][col] < lowest) {
                    lowest = data[row][col];
                    index = row;
                }
            }
            row++;
        }
        return index;
    }

    public static double getHighestInArray(double[] data) {
        double max = Double.MIN_VALUE;
        for (double value : data) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static double getLowestInArray(double[] data) {
        double min = Double.MAX_VALUE;
        for (double value : data) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
}