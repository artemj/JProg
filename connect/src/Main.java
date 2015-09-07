import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        HashMap<Integer, String> s = readFile(fileNumbersNames);
        selectionPerson(s);
    }

    final static String fileNumbersNames = "D://list.txt";
    final static String fileExistingLinks = "D://links.txt";

    /*Проверка наличия файла*/
    private static void  checkExists(String fileName)
            throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*Чтение файла*/
    public static HashMap<Integer, String> readFile(String fileName)
            throws IOException {
        File file = new File(fileName);
        HashMap<Integer, String> listNames = new HashMap<>();
        checkExists(fileName);
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(file.getAbsoluteFile()));
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] nameArr = line.split(" ");
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

    /* Выбор личностей и образование рандомной связи */
    public static String selectionPerson(HashMap<Integer, String> listNames)
            throws IOException {
        String nameFirstPerson = null;
        String existLink;
        /*Ввод номера человека с клавиатуры*/
        System.out.println("Enter a number from 1 to " + listNames.size());
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String numberEnterInKeyboard = br.readLine();
        int numberFirstPerson = Integer.parseInt(numberEnterInKeyboard);
        if (listNames.containsKey(numberFirstPerson)) {
            nameFirstPerson = listNames.get(numberFirstPerson);
        }
        /*Проверка наличия ранее созданой связи в файле*/
        existLink = checkExistsLinks(nameFirstPerson);
        String link = existLink;
        /*Создание новой связи рандомно, если нет в файле*/
        if (existLink == null) {
            link = createNewLink(listNames, existLink, nameFirstPerson, numberFirstPerson);
        }
        /*Вывод на экран созданной или уже существующей связи*/
        System.out.println(link + " связаны судьбой!");
        return link;
    }

    /*Проверка наличия существующей уже связи*/
    public static String checkExistsLinks(String nameFirstPerson)
            throws FileNotFoundException {
        String existLink = null;
        String nameSecondPerson;
        checkExists(fileExistingLinks);
        StringBuilder links = readFileConnection(fileExistingLinks);
        String[] arrayLink = links.toString().split("\t");
        for (int i = 0; i < arrayLink.length; i++) {
            String[] bothDue = arrayLink[i].split(", ");
            if (bothDue[0].equals(nameFirstPerson)) {
                nameSecondPerson = bothDue[1];
                existLink = (nameFirstPerson + ", " + nameSecondPerson);
                break;
            }
        }
        return existLink;
    }

    /*Создание новой связи*/
    public static String createNewLink(HashMap<Integer, String> listNames,
                                       String existLink,
                                       String nameFirstPerson,
                                       int numberFirstPerson)
            throws IOException {
        listNames.remove(numberFirstPerson);
        String createLink = null;
        Random random = new Random();
        String[] remainderOfTheList = listNames.values().toArray(new String[listNames.size()]);
        if (existLink == null) {
            int numberSecondPerson = random.nextInt(remainderOfTheList.length);
            String nameSecondPerson = remainderOfTheList[numberSecondPerson];
            createLink = writeFileConnection(nameFirstPerson, nameSecondPerson);
        }
        return createLink;
    }

    /*запись в файл созданной связи*/
    public static String writeFileConnection(String nameFirstPerson,
                                             String nameSecondPerson)
            throws IOException {
        String link = nameFirstPerson + ", " + nameSecondPerson;
        try (FileWriter writer = new FileWriter(fileExistingLinks, true)) {
            writer.write(link + '\t');
        }
        catch (IOException e) {
            throw e;
        }
        return link;
    }

    /*Чтение данных из файла созданных связей*/
    public  static StringBuilder readFileConnection(String nameFile) {
        StringBuilder str = new StringBuilder();
        try (FileReader reader = new FileReader(nameFile)) {
            int c;
            while ((c = reader.read()) != -1) {
                str.append((char) c);
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return str;
    }
}