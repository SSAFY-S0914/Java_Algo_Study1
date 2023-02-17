import java.util.Scanner;

public class JUN_9663_Jisangil {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][n];
        for(int i =0;i<n;i++){
            arr[0][i]=1;
            dfs(arr,1);
            arr[0][i]=0;
        }
        System.out.println(answer);
    }
    private static void dfs(int[][] arr, int start){
        if(start == arr.length){
            answer++;
            return;
        }

        for(int j =0;j<arr.length;j++){
            if(arr[start][j]==1){
                continue;
            }
            if(check(arr,start,j)){
                arr[start][j]=1;
                dfs(arr,start+1);
                arr[start][j]=0;
            }
        }
    }
    private static boolean check(int [][]arr, int x, int y){
        for(int i=0; i<arr.length;i++){
            if(arr[x][i]==1){
                return false;
            }
        }
        for(int i=0; i<arr.length;i++){
            if(arr[i][y]==1){
                return false;
            }
        }
        int tmpx=x,tmpy=y;
        while(tmpx>0 && tmpy>0){
            tmpx--;
            tmpy--;
        }
        for(int i=0;i<arr.length;i++){
            if(tmpx+i>=arr.length || tmpy+i>=arr.length){
                continue;
            }

            if(arr[tmpx+i][tmpy+i]==1){
                return false;
            }
        }
        while(y<arr.length-1 && x>0){
            x--;
            y++;
        }
        for(int i =0;i<arr.length;i++){
            if(x+i>=arr.length|| y-i <0){
                continue;
            }
            if(arr[x+i][y-i]==1){
                return false;
            }
        }
        return true;
    }
}
