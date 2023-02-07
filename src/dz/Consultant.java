package dz;

import java.util.*;

public class Consultant extends Person {
    private String name;
    private int workExperience;
    private Map<String, Integer> map;

    public Consultant(String name, int age, int workExperienceo) {
        super(name, age);
        this.workExperience = workExperienceo;
        this.name = name;
        this.map = new HashMap<>();
    }

    public void findCriteria(){
        System.out.println("По каким критериям будем выбирать ноутбук?");
        System.out.println("1 - ОЗУ\n" +
                "2 - Объем ЖД\n" +
                "3 - Операционная система\n" +
                "4 - Цвет");
        criteria();
    }
    private void criteria(){
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        switch (x) {
            case "1" -> {
                System.out.println("введите минимальную ОЗУ");
                map.put("ram", scanner.nextInt());
            }
            case "2" -> {
                System.out.println("введите минимальный Объем ЖД");
                map.put("hardDrive", scanner.nextInt());
            }
            case "3" -> {
                System.out.println("введите желаемую перационку");
                System.out.println("1-Windows\n2-Linux\n3-MacOS");
                boolean flag3 = true;
                while (flag3) {
                    String x3 = scanner.nextLine();
                    switch (x3) {
                        case "1" -> {
                            map.put("operatingSystem", 0);
                            flag3 = false;
                        }
                        case "2" -> {
                            map.put("operatingSystem", 1);
                            flag3 = false;
                        }
                        case "3" -> {
                            map.put("operatingSystem", 2);
                            flag3 = false;
                        }
                        default -> System.out.println("нет такой опции, попробуйте еще раз");
                    }
                }
            }
            case "4" -> {
                System.out.println("введите желаемый цвет");
                boolean flag4 = true;
                while (flag4) {
                    System.out.println("WHITE(1), RED(2), GREEN(3), BLACK(4), YELLOW(5), BLUE(6)");
                    String x4 = scanner.nextLine();
                    switch (x4) {
                        case "1" -> {
                            map.put("color", 0);
                            flag4 = false;
                        }
                        case "2" -> {
                            map.put("color", 1);
                            flag4 = false;
                        }
                        case "3" -> {
                            map.put("color", 2);
                            flag4 = false;
                        }
                        case "4" -> {
                            map.put("color", 3);
                            flag4 = false;
                        }
                        case "5" -> {
                            map.put("color", 4);
                            flag4 = false;
                        }
                        case "6" -> {
                            map.put("color", 5);
                            flag4 = false;
                        }
                        default -> {
                            System.out.println("нет такой опции, попробуйте еще раз");

                        }
                    }
                }
            }
            default -> {
                System.out.println("нет такой опции");
                findCriteria();
            }
        }
        recCriteria();
    }
    private void recCriteria(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("хотите добавить еще критериев или посмотреть текущию? да/нет/текущие");
        String s = scanner.nextLine();
        if ("да".equals(s)){
            System.out.println("1 - ОЗУ\n" +
                    "2 - Объем ЖД\n" +
                    "3 - Операционная система\n" +
                    "4 - Цвет");
            criteria();
        }
        if ("текущие".equals(s)){
            System.out.println(this);
            recCriteria();
        }
    }

    public List<Laptop> chooseLaptop(ArrayList<Laptop> laptopList){
        ArrayList<Laptop> listRes = new ArrayList<>();
        for (Map.Entry<String, Integer> item: map.entrySet()){
            if(listRes.size() == 0){
                listRes = sort(laptopList, item.getKey(), item.getValue());
            }
            else {
                listRes = sort(listRes, item.getKey(), item.getValue());
            }
        }
        System.out.println("Вот что есть по данным критериям");
        return listRes;
    }
    private ArrayList<Laptop> sort(ArrayList<Laptop> list, String key, int value){
        ArrayList<Laptop> listRes = new ArrayList<>();
        for (Laptop laptop : list) {
            if ("ram".equals(key)) {
                if (laptop.getRam() >= value) {
                    listRes.add(laptop);
                }
            } else if ("hardDrive".equals(key)) {
                if (laptop.getHardDrive() > value){
                    listRes.add(laptop);
                }
            } else if ("operatingSystem".equals(key)) {//operatingSystem
                if (laptop.getOperatingSystem() == value) {
                    listRes.add(laptop);
                }
            } else if ("color".equals(key)) {
                if (laptop.getColor() == value) {
                    listRes.add(laptop);
                }
            }
        }
        return listRes;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                name +
                ", стаж: " + workExperience +
                ", ищет нам: " + map +
                '}';
    }
}
