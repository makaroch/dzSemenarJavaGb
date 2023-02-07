package dz;

import java.util.ArrayList;
import java.util.Random;

public class Factory {

    private String nameFactory;
    private String addres;
    private int maxRam = 32;
    private int minRam = 4;
    private int maxHardDrive = 1000;
    private int minHardDrive = 200;
    private final String[] operatingSystemArr = {"Windows", "Linux", "MacOS"};

    public Factory(String nameFactory, String addres) {
        this.nameFactory = nameFactory;
        this.addres = addres;
    }
    private Laptop createLaptop(){// можем делать только париями)
        Random rnd = new Random();
        int ram = rnd.nextInt((maxRam-minRam)+1) + minRam;
        int hardDrive = rnd.nextInt((maxHardDrive - minHardDrive) +1) + minHardDrive;
        String operatingSystem = operatingSystemArr[rnd.nextInt(operatingSystemArr.length)];
        Colors color = Colors.values()[rnd.nextInt(6)];

        return new Laptop(ram, hardDrive, operatingSystem, color);
    }
    public ArrayList<Laptop> createBatchLaptop(int countOfBatch){
        ArrayList<Laptop> list = new ArrayList<>(countOfBatch);
        for (int i = 0; i < countOfBatch; i++) {
            list.add(createLaptop());
        }
        return list;
    }

    public String getNameFactory() {
        return nameFactory;
    }

    public void setNameFactory(String nameFactory) {
        this.nameFactory = nameFactory;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public int getMaxRam() {
        return maxRam;
    }

    public void setMaxRam(int maxRam) {
        this.maxRam = maxRam;
    }

    public int getMinRam() {
        return minRam;
    }

    public void setMinRam(int minRam) {
        this.minRam = minRam;
    }

    public int getMaxHardDrive() {
        return maxHardDrive;
    }

    public void setMaxHardDrive(int maxHardDrive) {
        this.maxHardDrive = maxHardDrive;
    }

    public int getMinHardDrive() {
        return minHardDrive;
    }

    public void setMinHardDrive(int minHardDrive) {
        this.minHardDrive = minHardDrive;
    }
}
