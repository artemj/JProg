/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perevorot;

/**
 *
 * @author Artem
 */
public class Perevorot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String s, res = "";
        String s1[];
        int k=0;
        s = "Мама мыла раму";        
        for (int i=s.length()-1; i>=0; i--)
        {
            res += s.substring(i,i+1);
        }
        s1 = res.split(" ");
        String s2[] = new String[s1.length];
        k = s1.length;
        for(int i=0; i<s1.length;i++)
        {
            s2[k-1]=s1[i];
            k--;
        }
        for (int i=0; i<s2.length;i++)
        {
            System.out.print(s2[i]+" ");
        }        
    }
    
}
