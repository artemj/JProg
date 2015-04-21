
package new_energo;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Energo {
    
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        ArrayList<Fields> textFile = readFile("D://энерго.txt");
        ArrayList<Integer> listMeter = meterReading(textFile);
        plot(listMeter);
    } 
    
    public static ArrayList<Fields> readFile(String fileName) throws FileNotFoundException, ParseException {
        File file = new File(fileName); 
        ArrayList<Fields> listElements = new ArrayList<>();
        checkExists(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                DateFormat format;
                format = new SimpleDateFormat("dd-MM-yy");
                String line;
                while ((line = in.readLine()) != null) {
                    String sMas[] = line.split("\t");
                    int a = Integer.valueOf(sMas[0]);                  
                    Date b = format.parse(sMas[1]);
                    int c = Integer.valueOf(sMas[2]);
                    Fields elem = new Fields(a,b,c); 
                    listElements.add(elem);
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return listElements;
    }   
    
    public static ArrayList<Integer> meterReading(ArrayList<Fields> listElements){
        ArrayList<Integer> resList = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<listElements.size()-1;i++){
            Fields firstFlatNumber = listElements.get(i);
            Fields nextFlatNumber = listElements.get(i+1);
            if(i<listElements.size()-2){                
                if(firstFlatNumber.number == nextFlatNumber.number){
                    sum += firstFlatNumber.meter;               
                } else {
                    sum += firstFlatNumber.meter;
                    resList.add(sum);
                    sum = 0;
                }
            } else {
                sum += nextFlatNumber.meter;
                resList.add(sum);
            }
        }
        return resList;
    }
    
    public static void plot(ArrayList<Integer> resList){
        int razmer = 0;
        System.out.println("^");
        for (int i = resList.size()-1; i >= 0; i--){
            System.out.print("|");
            for (int j = 0; j < resList.get(i); j++){
                if (razmer<resList.get(i)){
                    razmer = resList.get(i);
                }
                System.out.print("0");
            }
            System.out.println();
        }
        for (int i = 0; i <= razmer+1; i++){
            System.out.print("-");
        }
        System.out.println(">");
    }
    
    static class Fields { 
        private int number;
        private final Date date;
        private int meter; 
        
        public Fields (int x, Date y, int z) {
            this.number = x;
            this.date = y;
            this.meter = z;
        }
    }
    
    private static void  checkExists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }     
}

