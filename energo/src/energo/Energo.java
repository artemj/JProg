
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
    private static File file = new File("D://энерго.txt");
    
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
        } finally {
            in.close();
        }
    } catch(IOException e) {
        throw new RuntimeException(e);
    }
    return sb.toString();
}

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> ob = new ArrayList<>();
        int a;
        int n = 0;
    String ss = Energo.read("D://энерго.txt");
    String sNew = ss.replace('\n',' ').replace('\t', ' ');
        String sMas[] = sNew.split(" ");
//        for (int i=0; i<sMas.length;i++){
//            System.out.println(sMas[i]);            
//        }
        for (int i=0; i<sMas.length; i+=3){
            if(i+3<sMas.length){
                if(sMas[i].equals(sMas[i+3])){
                    a = Integer.valueOf(sMas[i+2]);
                    n += a;
                }
                else{    
                    a = Integer.valueOf(sMas[i+2]);
                    n += a;
                   ob.add(n);
                    n = 0; 
                }
            }
            else{
                a = Integer.valueOf(sMas[i+2]);
                    n += a;
                   ob.add(n);
            }
        }
        int razmer = 0;
        System.out.println(ob);
        int c = ob.get(1);
        System.out.println("^");
        for (int i = ob.size()-1; i >= 0; i--){
            System.out.print("|");
            for (int j = 0; j <= ob.get(i); j++){
                if (razmer<ob.get(i)){
                    razmer = ob.get(i);
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
}
