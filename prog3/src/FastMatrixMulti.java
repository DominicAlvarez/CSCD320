import java.io.File;
import java.util.Scanner;
public class FastMatrixMulti {
    // Declare local 2-D arrays 
    static int[][] m;
    static int[][] a;
    static void matrixchainorder(int [] p){
        int n = p.length - 1;
        m = new int[p.length][p.length];
        a = new int[p.length][p.length];
        for (int i = 1; i < n + 1; ++i){
            m[i][i] = 0;
        }
        for (int s = 1; s < n; ++s){
            for (int i = 1; i < n - s + 1; ++i){
                int j = i + s;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k){
                    int q = m[i][k] + m[k + 1][j] + (p[i - 1] * p[k] * p[j]);
                    if (q < m[i][j]){
                        m[i][j] = q;
                        a[i][j] = k;
                    } // end if
                } // end for k
            } // end for i
        } // end for s
    } // end matrixchainorder
    static int printoptimalparens(int[][] a, int i, int j){
        if(i == j){
            System.out.print("A" + i);
        }
        else{
            System.out.print("(");
            printoptimalparens(a, i, a[i][j]);
            printoptimalparens(a, a[i][j] + 1, j);
            System.out.print(")");
        }
        return m[i][j];
    }// end printoptimalparens
    public static void main(String [] args){
       try{
           File file = new File(args[0]);
           Scanner reader = new Scanner(file);
           int count = 0;
           while(reader.hasNextInt()){
               count++;
               reader.nextInt();
           }
           Scanner read = new Scanner(file);
           int[] arr = new int[count];
           for(int i = 0; i < arr.length; i++){
               arr[i] = read.nextInt();
           }
           matrixchainorder(arr);
           int n = a.length - 1;
           System.out.print("\n" + printoptimalparens(a, 1, n));
           read.close();
           reader.close();
       }catch(Exception e){
           return;
       }

    }
}

