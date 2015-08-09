import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Field> s = readFile(fileNameList);
        selectionPerson(s);
    }

    public static String fileNameList = "D://list.txt";
    public static String fileNameLinks = "D://links.txt";

    private static void  checkExists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }

    public static ArrayList<Field> readFile (String fileName) throws IOException {
        File file = new File(fileName);
        ArrayList<Field> listNames = new ArrayList<Field>();
        checkExists(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    String nameArr[] = line.split(" ");
                    int number = Integer.valueOf(nameArr[0]);
                    String name = nameArr[1];
                    Field element = new Field(number,name);
                    listNames.add(element);
                }
            } finally {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listNames;
    }

    public static String selectionPerson (ArrayList<Field> listNames) throws IOException {
        System.out.println("Enter a number from 1 to "+listNames.size());
        int numberFirstPerson = System.in.read()-48;
        Random random = new Random();
        System.out.println(numberFirstPerson);
        String nameFirstPerson = null;
        String nameSecondPerson = null;
        String link = null;
        int numberSecondPerson;
        for (int i=0; i<listNames.size();i++){
            if(listNames.get(i).number == numberFirstPerson){
                nameFirstPerson = listNames.get(i).name;
            }
        }
        String links = readFileConnection(fileNameLinks);
        String arrayLink [] = links.split("\t");
        for (int i = 0; i < arrayLink.length; i++) {
            String bothDue[] = arrayLink[i].split(", ");
            if (bothDue[0].equals(nameFirstPerson)) {
                nameSecondPerson = bothDue[1];
                link = (nameFirstPerson + ", " + nameSecondPerson);
                break;
            }
        }
        if (nameSecondPerson == null) {
            while (true) {
                numberSecondPerson = random.nextInt(listNames.size()) + 1;
                if (numberSecondPerson != numberFirstPerson) {
                    break;
                }
            }
            nameSecondPerson = listNames.get(numberSecondPerson - 1).name;
            link = (nameFirstPerson + ", " + nameSecondPerson);
            writeFileConnection(link);
        }
        System.out.println(link+" связаны судьбой!");
        return link;
    }

    public static void writeFileConnection (String link){
        try(FileWriter writer = new FileWriter("D://links.txt", true)){
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

class Field {
    int number;
    String name;

    Field(int number, String name){
        this.number = number;
        this.name = name;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Field field = (Field) o;

        if (number != field.number) return false;
        if (name != null ? !name.equals(field.name) : field.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
