import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DZ2 {
    public static void main(String[] args) {
        //ex1("/dsds/dsds/d//stest1.txt", "очень важная инфа");
        //System.out.println(ex2());
        int[] ar = {92,4,8,4,6,8,9};
        ex3(ar);
        System.out.println(Arrays.toString(ar));
    }
    static void ex3(int[] arr){

        Logger logger = Logger.getAnonymousLogger();
        SimpleFormatter forat = new SimpleFormatter();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("logEx3.txt", true);
            fileHandler.setFormatter(forat);
        } catch ( Exception e){
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length-1; j++) {
                if (arr[j] > arr[j + 1]){
                    logger.log(Level.INFO, "все ок");
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void ex3WraeatFileLog(String message){
        // нераюотает создает кол-во файлов равное колву итераций) интересно
        Logger logger = Logger.getAnonymousLogger();
        SimpleFormatter forat = new SimpleFormatter();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("logex3.txt", true);
            fileHandler.setFormatter(forat);
        } catch ( Exception e){
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);
        logger.log(Level.INFO, message);
    }
    static String ex2(){
        File file = new File("test.json");
        StringBuilder stringBuilder = new StringBuilder();
        try(Scanner scanner = new Scanner(file, StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()){
                stringBuilder.append(scanner.nextLine());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    static void ex1(String filePath, String s){
        /*Создать метод, который запишет результат работы в файл Обработайте исключения и запишите ошибки в лог файл*/

        Logger logger = Logger.getAnonymousLogger();
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt", true);
            fileHandler.setFormatter(simpleFormatter);
        } catch (IOException e) {
           e.printStackTrace();
        }

        logger.addHandler(fileHandler);

        try(FileWriter fileWriter = new FileWriter(filePath);) {
            fileWriter.write(s);
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage());
//            e.printStackTrace();
        }
    }

    static String ex0(){
        File file = new File("test.json");
        StringBuilder stringBuilder = new StringBuilder();

        try(Scanner scanner = new Scanner(file, StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()){
                stringBuilder.append(scanner.nextLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        ArrayList<String> sList = new ArrayList<>();

        String[] sArr = stringBuilder.toString().replace("[", "").replace("]", "").
                replace("{", "").replace("}", "").replace(" ", "").
                replace('"','~').replace("~", "").split(",");

        for (int i = 0; i < sArr.length; i++) {
            sList.add(sArr[i].split(":")[1]);
        }
        Object[] resArray = sList.toArray();
        String res = "";
        for (int i = 0; i < resArray.length; i+=3) {
            res += "Студент "  + resArray[i] + " получил " + resArray[i+1] + " по предмету " + resArray[i+2] + "\n";
        }
       return res;

    }

    static String getType(Object x){
        return x.getClass().getSimpleName();
    }
}
