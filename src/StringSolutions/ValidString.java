package StringSolutions;
import java.util.*;
/*最优解答*/
/*使用两个stack，分别存放左括号和星号的位置，遍历字符串，
当遇到星号时，压入星号栈star，当遇到左括号时，压入左括号栈left，
当遇到右括号时，此时如果left和star均为空时，直接返回false；
如果left不为空，则pop一个左括号来抵消当前的右括号；
否则从star中取出一个星号当作左括号来抵消右括号。
当循环结束后，我们希望left中没有多余的左括号，
就算有，我们可以尝试着用星号来抵消，当star和left均不为空时，进行循环，
如果left的栈顶左括号的位置在star的栈顶星号的右边，那么就组成了 *( 模式，直接返回false；
否则就说明星号可以抵消左括号，各自pop一个元素。
最终退出循环后我们看left中是否还有多余的左括号，没有就返回true，否则false*/
public class ValidString {
    public boolean checkValidString(String s) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(')
                st1.add(i);
            else if (c == '*')
                st2.add(i);
            else {
                if (!st1.isEmpty())
                    st1.pop();
                else if (!st2.isEmpty())
                    st2.pop();
                else
                    return false;
            }
        }
        while (!st1.isEmpty()) {
            int n1 = st1.pop();
            if (st2.isEmpty())
                return false;
            int n2 = st2.pop();
            if (n1 > n2)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String path = s.nextLine();
        ValidString vs = new ValidString();
        boolean answer = vs.checkValidString(path);
        System.out.println(answer);
    }
}
