import java.util.*;

public class DZ3 {


    static void dzEx0(int listSize) {
        /*Пусть дан произвольный список целых чисел, удалить из него четные числа*/

        List<Integer> list = createList(listSize);
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }

        System.out.println();
        System.out.println(list);
    }

    static void dzEx1(int listSize) {
        /*Задан целочисленный список ArrayList. Найти минимальное, максимальное 
        и среднее арифметическое из этого списка. Collections.max()*/
        List<Integer> list = createList(listSize);
        System.out.println(list);

        int max = Collections.max(list);
        int min = Collections.min(list);
        float average = 0;

        for (int i = 0; i < listSize; i++) {
            average += list.get(i);
        }
        average /= listSize;
        System.out.printf("Max: %d, Min: %d, Srednee: %f", max, min, average);
    }

    static void dzEx2(int listSize) {
        /*Реализовать алгоритм сортировки слиянием*/
        List<Integer> list = createList(listSize);
        System.out.println(list);
        list = sortMerger(list);
        System.out.println(list);
    }

    static List<Integer> sortMerger(List<Integer> list) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        if (list.size() <= 1)
            return list;
        int midle = list.size() / 2;

        for (int i = 0; i < midle; i++) {
            leftList.add(list.get(i));
        }
        for (int i = midle; i < list.size(); i++) {
            rightList.add(list.get(i));
        }

        return mergerTwoLists(sortMerger(leftList), sortMerger(rightList));
    }


    static List<Integer> mergerTwoLists(List<Integer> list1, List<Integer> list2) {
        int pointer1 = 0;
        int pointer2 = 0;
        List<Integer> list3 = new ArrayList<>();
        while (pointer2 + pointer1 < list1.size() + list2.size()) {
            if (pointer1 >= list1.size()) {
                list3.add(list2.get(pointer2));
                pointer2++;
            } else if (pointer2 >= list2.size()) {
                list3.add(list1.get(pointer1));
                pointer1++;
            } else if (list1.get(pointer1) < list2.get(pointer2)) {
                list3.add(list1.get(pointer1));
                pointer1++;
            } else {
                list3.add(list2.get(pointer2));
                pointer2++;
            }
        }
        return list3;
    }

    static List<Integer> createList(int listSize) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(101));
        }
        return list;

    }

}
