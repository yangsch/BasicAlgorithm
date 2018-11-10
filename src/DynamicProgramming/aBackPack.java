package DynamicProgramming;
/*将问题一般化，求背包能够获得的最大总价值，即求前i个物体放入容量为m(kg)背包的最大价值c[i][m]。
  而前i个物体放入容量为m（kg）的背包，又可以转化成前(i-1)个物体放入背包的问题。
　　表达式中各个符号的具体含义。
　　w[i] :  第i个物体的重量；
　　p[i] : 第i个物体的价值；
　　c[i][m] ： 前i个物体放入容量为m的背包的最大价值；
　　c[i-1][m] ： 前i-1个物体放入容量为m的背包的最大价值；若不放入第i个物体，c[i][m]=c[i-1][m]
　　c[i-1][m-w[i]] ： 前i-1个物体放入容量为m-w[i]的背包的最大价值(满足m-w[i]>=0)；若放入第i个物体，c[i][m]=c[i-1][m-w[i]]+p[i]
　　由此可得：c[i][m]=max{c[i-1][m-w[i]]+p[i] , c[i-1][m]}*/
public class aBackPack {
    public static void main(String[] args) {
        int m = 10;
        int n = 3;
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        int c[][] = BackPack_Solution(m, n, w, p);
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                System.out.print(c[i][j]+"\t");
                if(j==m){
                    System.out.println();
                }
            }
        }
        //printPack(c, w, m, n);

    }
    /**
     * @param m 表示背包的最大容量
     * @param n 表示商品个数
     * @param w 表示商品重量数组
     * @param p 表示商品价值数组
     */
    public static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            c[i][0] = 0;
        for (int j = 0; j < m + 1; j++)
            c[0][j] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //(1)在不包括第i个物品的背包子集中,最优子集的价值c[i][j]为c[i-1][j]的值
                //(2)在包括第i个物品(重量为w[i-1])的背包子集中，背包剩余重量为j-w[i-1]>=0,
                //   最优子集的价值c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值p[i - 1]
                if (w[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1]))
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                    else
                        c[i][j] = c[i - 1][j];
                } else
                    c[i][j] = c[i - 1][j];
            }
        }
        return c;
    }
}
