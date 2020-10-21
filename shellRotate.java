package TwoDArray;
import java.util.*;
public class shellRotate {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();
        int m = scn.nextInt();

        int [][]a = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                a[i][j] = scn.nextInt();
            }
        }


        int s = scn.nextInt();
        int r = scn.nextInt();

        shellRotate(a,s,r);
    }

    public static void shellRotate(int [][]a, int s, int r){
        int []arr = fill(a,s);
        rotate(arr,r);
        defill(a,arr,s);
        display(a);
    }

    public static int[] fill(int [][]a, int s){
        int row = a.length - 2 * (s-1);
        int col = a[0].length - 2 * (s-1);
        int ans = 2 * (row+col) - 4;
        int []arr = new int[ans];

        int minr = s - 1;
        int maxr = a.length-s;
        int minc = s - 1;
        int maxc = a[0].length - s;

        int cc = 0;

        for(int i=minr; i<=maxr ; i++){
            arr[cc] = a[i][minc];
            cc++;
        }

        minc++;

        for(int i=minc; i<=maxc; i++){
            arr[cc] = a[maxr][i];
            cc++;
        }

        maxr--;

        for(int i=maxr; i>=minr; i--){
            arr[cc] = a[i][maxc];
            cc++;
        }

        maxc--;

        for(int i=maxc; i>=minc; i--){
            arr[cc] = a[minr][i];
            cc++;
        }
        return arr;
    }


    public static void rotate(int []arr, int r){
        r =  r % arr.length;
        if(r<0){
            r = r + arr.length;
        }

        reverse(arr,0, arr.length-r-1);
        reverse(arr,arr.length-r, arr.length-1);
        reverse(arr,0,arr.length-1);
    }

    public static void reverse(int []a, int l, int r){
        while(l<r){
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
            l++;
            r--;
        }
    }

    public static void defill(int [][]a, int []arr, int s){
        int minr = s - 1;
        int maxr = a.length-s;
        int minc = s - 1;
        int maxc = a[0].length - s;

        int cc = 0;

        for(int i=minr; i<=maxr ; i++){
            a[i][minc] = arr[cc];
            cc++;
        }

        minc++;

        for(int i=minc; i<=maxc; i++){
            a[maxr][i]= arr[cc];
            cc++;
        }

        maxr--;

        for(int i=maxr; i>=minr; i--){
            a[i][maxc]= arr[cc];
            cc++;
        }

        maxc--;

        for(int i=maxc; i>=minc; i--){
            a[minr][i] = arr[cc];
            cc++;
        }
    }

    public static void display(int [][]a){
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                System.out.print(a[i][j] + " ");
            }

            System.out.println();
        }
    }
}
