package StringSolutions;
import java.util.*;
/*最优解答*/
/*这题是简化目录，每一级目录前面都有一个斜杠，我可以首先对斜杠进行分割，
分割之后得到的结果无外乎4种情况：正常目录名称，空字符，".",".."。
对于“.”和空字符我们忽略它，对于正常的目录名称我们直接压入栈，
对于"..",我们把栈清空。通过这些处理之后，如果栈为空我们就返回根目录，
如果栈不为空我们就逐个出栈并在每个元素前面加一个斜杠，最先出的位于路径的最后面。*/
public class SimplePath {
    public static String simplifyPath(String path) {

        String[] pathArray=path.split("/");
        int length=pathArray.length;
        Stack< String> stack=new Stack<>();
        String result="";
        for(int i=0;i<length;i++)
        {
            if(pathArray[i].equals("")||pathArray[i].equals("."))
            {}
            else if(pathArray[i].equals(".."))
            {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }

            }
            else {
                stack.push(pathArray[i]);
            }
        }
        if(stack.isEmpty())
            return "/";
        while(!stack.isEmpty())
        {
            result="/"+stack.pop()+result;
        }

        return result;

    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String path = s.nextLine();
        SimplePath sp = new SimplePath();
        String simple = sp.simplifyPath(path);
        System.out.println(simple);


    }
}
