package orimeister.projects.systerm_reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;


public class CpuUsageUtil {
    public static Optional<Integer> getCpuUsageFromBatch() {

        try {
            ProcessBuilder pb = new ProcessBuilder();
            pb.command("wmic", "cpu", "get", "loadpercentage");
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String trimmedLine = line.trim();
                if (!trimmedLine.isEmpty()) {
                    try {
                        int loadPercentage = Integer.parseInt(trimmedLine);
                        return Optional.of(loadPercentage);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing CPU load percentage: " + e.getMessage());
                    }
                }
                int exitCode = process.waitFor();
                if (exitCode != 0) {
                    System.err.println("Process exited with error code: " + exitCode);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
