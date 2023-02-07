package dz;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Factory  factory = new Factory("test","testAddres");
        ArrayList<Laptop> laptops = factory.createBatchLaptop(100);

        System.out.println(laptops);

        Consultant consultant = new Consultant("Вася", 27, 5);
        consultant.findCriteria();
        System.out.println(consultant.chooseLaptop(laptops));
        System.out.println(consultant);



    }
}
