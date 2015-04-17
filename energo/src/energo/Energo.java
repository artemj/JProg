
package energo;

import java.io.*;
import java.util.ArrayList;

public class Energo {
    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }
    
    public static String read(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        exists(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            }
            finally {
                in.close();
            }
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    
    public static ArrayList<Integer> masList(String s){
        ArrayList<Integer> str = new ArrayList<>();
        int a;
        int n = 0;
        String sNew = s.replace('\n',' ').replace('\t', ' ');
        String sMas[] = sNew.split(" ");
        for (int i=0; i<sMas.length; i+=3){
            if(i+3<sMas.length){
                if(sMas[i].equals(sMas[i+3])){
                    a = Integer.valueOf(sMas[i+2]);
                    n += a;
                }
                else{    
                    a = Integer.valueOf(sMas[i+2]);
                    n += a;
                    str.add(n);
                    n = 0; 
                }
            }
            else{
                a = Integer.valueOf(sMas[i+2]);
                n += a;
                str.add(n);
            }
        }
        return str;
    }
    
    public static void grafik(ArrayList<Integer> str){
        int razmer = 0;
        System.out.println(str);
        int c = str.get(1);
        System.out.println("^");
        for (int i = str.size()-1; i >= 0; i--){
            System.out.print("|");
            for (int j = 0; j <= str.get(i); j++){
                if (razmer<str.get(i)){
                    razmer = str.get(i);
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
    
     private static File file = new File("D://энерго.txt");

    public static void main(String[] args) throws FileNotFoundException {
        String ss = Energo.read("D://энерго.txt");
        ArrayList<Integer> ob = Energo.masList(ss);
        grafik(ob);
    }           
}
