import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    static int invalidCount = 0;
    static int totalLines = 0;

    public static void main(String[] args) {
        String fileName = args[0];
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(fileName);

        // Step 2: calculate statistics
        double average = calculateAverage(scores);

        int highest = 0;
        int lowest = 0;

        if (!scores.isEmpty()) {
            highest = scores.get(0);
            lowest = scores.get(0);

            for (int score : scores) {
                if (score > highest) {
                    highest = score;
                }

                if (score < lowest) {
                    lowest = score;
                }
            }
        }

        // Step 3: write and print report
        writeReport(scores, average, highest, lowest, "report.txt");
    }


    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {

        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {

                totalLines++;
                line = line.trim();

                // Blank line
                if (line.isEmpty()) {
                    invalidCount++;
                    System.out.println(
                            "Warning: invalid line " + totalLines);
                    continue;
                }

                try {
                    int score = Integer.parseInt(line);

                    if (score >= 0 && score <= 100) {
                        scores.add(score);
                    } else {
                        invalidCount++;
                        System.out.println(
                                "Warning: score out of range on line "
                                        + totalLines + ": " + line);
                    }

                } catch (NumberFormatException e) {
                    invalidCount++;

                    System.out.println(
                            "Warning: invalid score on line "
                                    + totalLines + ": " + line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: scores.txt not found.");

        } catch (IOException e) {
            System.out.println(
                    "Error reading file: " + e.getMessage());
        }

        return scores;
    }


    // Returns average, or 0.0 if empty
    public static double calculateAverage(
            ArrayList<Integer> scores) {

        if (scores.isEmpty()) {
            return 0.0;
        }

        int total = 0;

        for (int score : scores) {
            total += score;
        }

        return (double) total / scores.size();
    }


    // Writes and prints report
    public static void writeReport(
            ArrayList<Integer> scores,
            double avg,
            int high,
            int low,
            String outputFile) {

        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        int fCount = 0;

        for (int score : scores) {

            if (score >= 90) {
                aCount++;
            } else if (score >= 80) {
                bCount++;
            } else if (score >= 70) {
                cCount++;
            } else if (score >= 60) {
                dCount++;
            } else {
                fCount++;
            }
        }

        String report;

        if (scores.isEmpty()) {

            report =
                    "=== Grade Analysis Report ===\n" +
                    "Total scores processed: " + totalLines + "\n" +
                    "Invalid lines skipped:   " + invalidCount + "\n\n" +
                    "No valid scores found.\n";

        } else {

            report = String.format(
                    "=== Grade Analysis Report ===%n" +
                    "Total scores processed: %3d%n" +
                    "Invalid lines skipped:   %3d%n" +
                    "%n" +
                    "Average score:   %6.2f%n" +
                    "Highest score:   %6d%n" +
                    "Lowest score:    %6d%n" +
                    "%n" +
                    "Grade distribution:%n" +
                    "  A (90-100):   %3d%n" +
                    "  B (80-89):    %3d%n" +
                    "  C (70-79):    %3d%n" +
                    "  D (60-69):    %3d%n" +
                    "  F (below 60): %3d%n",

                    totalLines,
                    invalidCount,
                    avg,
                    high,
                    low,
                    aCount,
                    bCount,
                    cCount,
                    dCount,
                    fCount
            );
        }

        // Print report to terminal
        System.out.println();
        System.out.println(report);

        // Write report to file
        try (PrintWriter writer =
                     new PrintWriter(outputFile)) {

            writer.print(report);

        } catch (FileNotFoundException e) {
            System.out.println(
                    "Error writing report: " + e.getMessage());
        }
    }
}