import java.util.*;

public class Dz5 {

    static class PhoneBook{
        /*Реализуйте структуру телефонной книги с помощью HashMap,
        учитывая, что 1 человек может иметь несколько телефонов.*/

        private HashMap<String, List<Integer>> hashMap;
        public PhoneBook(){
            this. hashMap = new HashMap<>();
        }
        public void addPerson(String name, int nomber){
            if (hashMap.containsKey(name)){
                hashMap.get(name).add(nomber);
            }
            else {
                List<Integer> list = new LinkedList<>();
                list.add(nomber);
                hashMap.put(name, list);
            }
        }
        public HashMap<String, List<Integer>> lookAllContacts(){
           return hashMap;
        }
        public List<Integer> looContacts(String name){
            return hashMap.get(name);
        }

    }

    static void ex1() {
        /*Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова,
        Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина,
        Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
        Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
        Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.*/

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, List<String>> treeMap = new TreeMap<>(Comparator.reverseOrder());

        String peple = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, " +
                "Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, " +
                "Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.";
        String[] peplesArr = peple.split(", ");
        System.out.println(Arrays.toString(peplesArr));
        for (int i = 0; i < peplesArr.length; i++) {
           String name = peplesArr[i].split(" ")[0];
           if (map.containsKey(name)){
               map.put(name, map.get(name) + 1);
           }
           else {
               map.put(name, 1);
           }
        }
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (treeMap.containsKey(entry.getValue())){
                treeMap.get(entry.getValue()).add(entry.getKey());
            }
            else {
                List<String> list = new LinkedList<>();
                list.add(entry.getKey());
                treeMap.put(entry.getValue(), list);
            }
        }
        System.out.println(treeMap);

    }
}
