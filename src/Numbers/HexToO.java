package Numbers;

//自带的Integer.parseInt(s,radix)可以转化，其中s为输入字符串，radix为进制数，返回值为int型十进制整数。
import java.util.Scanner;



public class HexToO {
    public static void main(String[] args) {

        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            fun(input);
        }
    }

    public static void fun(String input) {
        String subString = input.substring(2, input.length());
        int result = 0;
        for (int i = 0; i < subString.length(); i++) {
            if (subString.charAt(i) >= 'A' &&subString.charAt(i) <= 'F') {
                result += result * 15 + subString.charAt(i) - 'A' + 10;
            } else if (subString.charAt(i) >= 'a' &&  subString.charAt(i) <= 'f') {
                result += result * 15 + subString.charAt(i) - 'a' + 10;
            } else {
                result += result * 15 + subString.charAt(i) - '0';
            }
        }
        System.out.println(result);
    }
}

