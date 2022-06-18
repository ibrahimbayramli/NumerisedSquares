public class Main {
    public static void main(String[] args) {


        int col=(int)(Math.random()*10)-1;
        int row=(int)(Math.random()*10)-1;

        Game.start(row,col);
        Game.printGameBoard();

        System.out.println(" ");
        System.out.println("ROW: "+row);
        System.out.println("COL: "+col);
    }

}