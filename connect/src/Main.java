import java.io.*;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        HashMap<Integer, String> s = readFile(fileNumbersNames);
        selectionPerson(s);
    }

    public static String fileNumbersNames = "D://list.txt";
    public static String fileExistingLinks = "D://links.txt";
    public static String nameFirstPerson = null;
    public static String nameSecondPerson = null;
    public static String link = null;
    public static int numberFirstPerson;
    public static int numberSecondPerson;

    private static void  checkExists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static HashMap <Integer, String> readFile (String fileName) throws IOException {
        File file = new File(fileName);
        HashMap <Integer, String> listNames = new HashMap <>();
        checkExists(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    String nameArr[] = line.split(" ");
                    int number = Integer.valueOf(nameArr[0]);
                    String name = nameArr[1];
                    listNames.put(number, name);
                }
            } finally {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listNames;
    }

    public static String selectionPerson (HashMap <Integer, String> listNames) throws IOException {
        /*Ввод номера человека с клавиатуры*/
        System.out.println("Enter a number from 1 to "+listNames.size());
        char x = (char)System.in.read();
        numberFirstPerson = Character.getNumericValue(x);
        /*Выбор имени человека по номеру, который мы ввели*/
        if(listNames.containsKey(numberFirstPerson)){
            nameFirstPerson = listNames.get(numberFirstPerson);
        }
        /*Проверка наличия ранее созданой связи в файле*/
        checkExistsLinks();
        /*Создание новой связи рандомно, если нет в файле*/
        createNewLink(listNames);
        /*Вывод на экран созданной или уже существующей связи*/
        System.out.println(link+" связаны судьбой!");
        return link;
    }

    public static String checkExistsLinks() throws FileNotFoundException {
        checkExists(fileExistingLinks);
        String links = readFileConnection(fileExistingLinks); // открываем файл
        String arrayLink [] = links.split("\t"); // в него ранее записывалось так: связь имя1, имя2 таб. По табу разбиваем на отдельные связи в массив
        for (int i = 0; i < arrayLink.length; i++) { // теперь каждую из них рассматриваем
            String bothDue[] = arrayLink[i].split(", "); //разбиваем в массив на отдельные два имя
            if (bothDue[0].equals(nameFirstPerson)) { //если нулевой элемент массива (тоесть первое имя) совпадет с тем, что мы ввели - значит связь уже существует просто берем второе имя записываем
                nameSecondPerson = bothDue[1];
                link = (nameFirstPerson + ", " + nameSecondPerson);
                break;
            }
        }
        return link;
    }

    public static String createNewLink(HashMap <Integer, String> listNames){
        Random random = new Random();
        if (nameSecondPerson == null) { //делаем проверку на то, нашли ли мы в файле связь, если нет, то значит и второе имя мы не записали, значит оно равно нул
            while (true) { //запускаем бесконечный цикл
                numberSecondPerson = random.nextInt(listNames.size()) + 1; // берем рандомное число
                if (numberSecondPerson != numberFirstPerson) { //если рандомное совпало с первым, тем что мы ввели с клавиатуры, то нужно другое рандомное число
                    break; //выбрасывает из цикла, если рандом и нами введенное числа не совпали
                }
            }
            nameSecondPerson = listNames.get(numberSecondPerson);
            link = (nameFirstPerson + ", " + nameSecondPerson);
            writeFileConnection(link);
        }
        return link;
    }

    /*запись в файл созданной связи*/
    public static void writeFileConnection (String link){
        try(FileWriter writer = new FileWriter(fileExistingLinks, true)){
            writer.write(link+'\t');
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public  static String readFileConnection (String nameFile){
        String str = new String();
        try(FileReader reader = new FileReader(nameFile)) {
            int c;
            while((c=reader.read())!=-1){
                str += (char)c;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return str;
    }
}