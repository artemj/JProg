package perevorot_v1.pkg2;
public class Perevorot_v12 {
    public static void main(String[] args) {
        String s = "Мама Мыла Раму", res = "";
        int k=0,t=0;   
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)==' '){
                k=i;
                for(int j = k; j>=t; j--){
                    res += s.charAt(j);
                }
                t=k;
            }  
        }
        if (s.toCharArray()[s.length()-1]==' '){}
        else{
            for(int o=s.length()-1;o>=k;o--){
                res += s.charAt(o);
            }          
        }
        System.out.println(res);  
    }
}
