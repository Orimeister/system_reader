package orimeister.projects.systerm_reader;

import java.util.Arrays;

public class CpuInfo {
    private double[] loadPercentages;
//    private double temperature;
    private String info;

    public CpuInfo(double[] loadPercentages, String info) {
        this.loadPercentages = loadPercentages;
        this.info = info;
    }

    public double[] getLoadPercentages() {
        return loadPercentages;
    }

    public void setLoadPercentage(double[] loadPercentages) {
        this.loadPercentages = loadPercentages;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    @Override
    public String toString() {
        return "CpuInfo{" +
                "loadPercentage=" + Arrays.toString(loadPercentages) +
                ", info='" + info + '\'' +
                '}';
    }
}

