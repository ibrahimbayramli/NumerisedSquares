public class Game {
    static  int[][] gameBord=new int[10][10];
    static int[] coordinate=new int[2];
    static int step=1;
    public static int[][] start(int row,int col){
        for(int i=0;i<gameBord.length;i++){
            for(int j=0;j<gameBord[i].length;j++){
                gameBord[i][j]=0;
            }
        }
        gameBord[row][col]=step;
        step++;
        return gameBord;

    }
    public static boolean isEmpty(int col,int row){

        if(gameBord[row][col]==0) return true;
        return false;
    }
    public static void printGameBoard(){

        for (int[] i:gameBord){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println("");

        }
    }

}
