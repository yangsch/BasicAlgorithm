package DynamicProgramming;
/*深度优先搜索：

   之前我们求最短路径用的广度优先搜索，这个题看似是最短路径问题，
   其实不是，因为题目上说了只有一条通路，而且还要输出这个路径，
   那么深度优先搜索比较合适，当然广度优先搜索也可以。
   深度优先搜索的思想是沿着一个方向搜到底，如果行不通，则返回来试其他的路径。
   就一直这样直到找到一条通路输出就可以了*/
import java.util.*;
public class Maze {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] map = new int[m][n];//定义一个Map矩阵，用来保存地图
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();//输入地图
                }
            }
            int[][] dir = {{1, 0}, {0,  1}};//定义两个方向横着走或者竖着走（题目中说只走这两个方向，当前也可以定义多个方向）
            Stack<Node> stack = new  Stack<Node>();//定义一个栈，保存路径
            int[][] visited = new  int[m][n];//标记是否被访问，这个要和Map大小对应
            Node start = new Node(0, 0);//定义起始位置
            Node end = new Node(m - 1, n - 1);//定义目的位置
            visited[start.x][start.y] = 1;//将起始点标记为访问
            stack.push(start);//将起始点加入队列
            while (!stack.isEmpty())  {//如果对了为空了还没有找到解，说明就没有通路，当然本题不存在无解，题目上说了一定存在一个通路。
                boolean flag = false;//标记是否找了一个方向
                Node pek = stack.peek();//获取栈顶元素，注意不需要出栈
                if (pek.x == end.x && pek.y == end.y) {//如果到达目的地则跳出循环
                    break;
                } else {
                    for (int i = 0; i < 2; i++) {//循环两个方向
                        Node nbr = new Node(pek.x + dir[i][0],  pek.y + dir[i][1]);//找到当前位置的邻居位置坐标并判断是否合法
                        if (nbr.x >= 0 && nbr.x <  m && nbr.y >= 0 && nbr.y < n &&  map[nbr.x][nbr.y] == 0 && visited[nbr.x][nbr.y] == 0){//判断邻居节点是否合法
                            stack.push(nbr);//合法将邻居位置加入栈
                            visited[nbr.x][nbr.y] =  1;//并标记该节点已经访问
                            flag = true;//找到了一个方向
                            break;//找到了就停止循环，顺着这个方向一直搜索
                        }
                    }
                    if (flag) {//找到了方向，就不用执行下面的出栈，沿着这个方向一直搜下去
                        continue;
                    }
                    stack.pop();//如果两个方向都不能通过，则出栈。
                }
            }
            Stack<Node> stkRev = new  Stack<Node>();//将路径反过来，因为栈中输出的路径是反的
            while (!stack.isEmpty()) {
                stkRev.push(stack.pop());
            }
            while (!stkRev.isEmpty()) {
                System.out.println("(" + stkRev.peek().x + "," + stkRev.peek().y + ")");
                stkRev.pop();
            }
        }
    }
}
class Node{
    int x;
    int y;
    Node(int x,int y){
        this.x=x;
        this.y=y;
    }
}
