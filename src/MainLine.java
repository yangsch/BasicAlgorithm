import java.util.*;
public class MainLine {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()){
            String line = s.nextLine();
            StringBuilder sb = new StringBuilder();
            String[] str = line.split("[ ]+");
            for(int i=str.length-1;i>0;i--){
                sb.append(str[i]);
                sb.append(" ");
            }
            sb.append(str[0]);
            System.out.println(sb.toString());

        }
    }
}
