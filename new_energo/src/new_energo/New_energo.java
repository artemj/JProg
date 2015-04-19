
package new_energo;

import java.io.*;
import java.util.ArrayList;

public class New_energo {
    
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<NewFields> ss = New_energo.read("D://энерго.txt");
        ArrayList<Integer> ob = New_energo.masList(ss);
        grafik(ob);
    } 
    
    public static ArrayList<NewFields> read(String fileName) throws FileNotFoundException {
        ArrayList<NewFields> listElements = new ArrayList<>();
        exists(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    String sMas[] = s.split("\t");
                    int a = Integer.valueOf(sMas[0]);
                    Object b = sMas[1];
                    int c = Integer.valueOf(sMas[2]);
                    NewFields elem = new NewFields(a,b,c); 
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
    
    public static ArrayList<Integer> masList(ArrayList<NewFields> listElements){
        ArrayList<Integer> resList = new ArrayList<>();
        int n = 0;
        for(int i=0;i<listElements.size()-1;i++){
            NewFields a = listElements.get(i);
            NewFields b = listElements.get(i+1);
            if(i<listElements.size()-2){                
                if(a.number == b.number){
                    n += a.obj;               
                } else {
                    n += a.obj;
                    resList.add(n);
                    n = 0;
                }
            } else {
                n += b.obj;
                resList.add(n);
            }
        }
        return resList;
    }
    
    public static void grafik(ArrayList<Integer> resList){
        int razmer = 0;
        int c = resList.get(1);
        System.out.println("^");
        for (int i = resList.size()-1; i >= 0; i--){
            System.out.print("|");
            for (int j = 0; j <= resList.get(i); j++){
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
    
    static class NewFields { 
        private int number;
        private Object date;
        private int obj;
        
        public NewFields (int x, Object y, int z){
            this.number = x;
            this.date = y;
            this.obj = z;
        }
    }
    
    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }
    
    private static final File file = new File("D://энерго.txt");    
}

