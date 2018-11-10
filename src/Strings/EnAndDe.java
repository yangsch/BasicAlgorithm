package Strings;

import java.util.*;

public class EnAndDe {
    private static String encode(String en){
        char[] encode = en.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<encode.length;i++){
            if(encode[i]<='9'&&encode[i]>='0'){
                if(encode[i]=='9'){
                    encode[i] = '0';
                }else{
                    encode[i] = (char)((int)encode[i]+1);
                }
                sb.append(encode[i]);
            }else if(encode[i]<='z'&&encode[i]>='a'){
                if(encode[i]=='z'){
                    encode[i] = 'A';
                }else{
                    encode[i] = (char)((int)encode[i]+1-32);
                }
                sb.append(encode[i]);
            }else{
                if(encode[i]=='Z'){
                    encode[i] = 'a';
                }else{
                    encode[i] = (char)((int)encode[i]+1+32);
                }
                sb.append(encode[i]);
            }
        }
        return sb.toString();
    }

    private static String decode(String de){
        char[] decode = de.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<decode.length;i++){
            if(decode[i]<='9'&&decode[i]>='0'){
                if(decode[i]=='0'){
                    decode[i] = '9';
                }else{
                    decode[i] = (char)((int)decode[i]-1);
                }
                sb.append(decode[i]);
            }else if(decode[i]<='z'&&decode[i]>='a'){
                if(decode[i]=='a'){
                    decode[i] = 'Z';
                }else{
                    decode[i] = (char)((int)decode[i]-1-32);
                }
                sb.append(decode[i]);
            }else{
                if(decode[i]=='A'){
                    decode[i] = 'z';
                }else{
                    decode[i] = (char)((int)decode[i]-1+32);
                }
                sb.append(decode[i]);
            }
        }
        return sb.toString();

    }

    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        while(s.hasNext()){
            String en = s.next();
            String de = s.next();
            System.out.println(encode(en));
            System.out.println(decode(de));
        }

    }
}
