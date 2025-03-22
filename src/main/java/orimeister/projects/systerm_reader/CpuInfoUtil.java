package orimeister.projects.systerm_reader;

import oshi.SystemInfo;
import oshi.hardware.*;

import java.util.Optional;

public class CpuInfoUtil {
    public static CpuInfo getCpuInfo() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        CentralProcessor processor = hal.getProcessor();
        Sensors sensors = hal.getSensors();
        double[] cpuLoadFractions = processor.getProcessorCpuLoad(1000);
        double[] cpuLoadPercentages = new double[cpuLoadFractions.length];
        for (int i = 0; i < cpuLoadFractions.length; i++) {
            cpuLoadPercentages[i] = cpuLoadFractions[i] * 100;
        }
        return new CpuInfo(
                cpuLoadPercentages,
                processor.toString());
    }

}
