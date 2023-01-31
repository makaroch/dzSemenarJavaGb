import java.util.*;

public class Dz4 {


    static public void ex2(){
        /*Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. 
        Используйте итератор*/
        List<Integer> list = creatList(5);
        System.out.println(list);
        int sum = 0;
        for (Integer item: list) {
            sum+= item;
        }
        System.out.println(sum);
    }
    static public void ex0() {
        /*Пусть дан LinkedList с несколькими элементами.
        Реализуйте метод, который вернет “перевернутый” список.
         */
        List<Integer> list = creatList(10);
        System.out.println(list);
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        System.out.print("обратный проход: ");
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }

    }

    static List<Integer> creatList(int x) {
        Random rn = new Random();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < x; i++) {
            list.add(rn.nextInt(101));
        }
        return list;
    }
}

class MyQueue {
    /*Реализуйте очередь с помощью LinkedList со следующими методами:
    enqueue() - помещает элемент в конец очереди,
    dequeue() - возвращает первый элемент из очереди и удаляет его,
    first() - возвращает первый элемент из очереди, не удаляя.*/

    private LinkedList<Integer> list;

    public MyQueue() {
        this.list = new LinkedList<>();
    }

    protected void enqueue(int x) {
        this.list.add(x);
    }

    protected int dequeue() {
        int x = this.list.getFirst();
        this.list.remove(0);
        return x;
    }

    protected int first() {
        return this.list.getFirst();
    }

}

