package dz;

public class Laptop {
    private int count;
    private static int countStatic = 1;
    private int ram;
    private int hardDrive ;
    private String operatingSystem;
    private Colors color;

    public Laptop(int ram, int hardDrive, String operatingSystem, Colors color) {
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.operatingSystem = operatingSystem;
        this.color = color;
        this.count = countStatic++;
    }

    @Override
    public String toString() {
        return "Laptop: (" +
                "номер в партии: " + count +
                ", ОЗУ = " + ram +
                ", Объём ЖД = " + hardDrive + "гб " +
                ", операционная система = " + operatingSystem +
                ", цвет = " + color+")\n";
    }

    public int getRam() {
        return ram;
    }

    public int getHardDrive() {
        return hardDrive;
    }

    public int getOperatingSystem() {
        //{"Windows ", "Linux", "MacOS"}
        if ("Windows".equals(operatingSystem)){
            return 0;
        }
        if ("Linux".equals(operatingSystem)){
            return 1;
        }
        if ("MacOS".equals(operatingSystem)){
            return 2;
        }
        return -1;
    }

    public int  getColor() {
        return color.ordinal();
    }
}
