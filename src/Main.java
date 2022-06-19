import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int matrisLength = 5;
    static int[][] gameBoard = new int[matrisLength][matrisLength];

    public static void main(String[] args) {

        List<Possibility> possibilities = new ArrayList<>();

        boolean result = false;

        for (int startXPosition = 0; startXPosition<matrisLength; startXPosition++) {
            for (int startYPosition = 0; startYPosition<matrisLength; startYPosition++) {

                gameBoard = new int[matrisLength][matrisLength];

                int startElement = 1;
                gameBoard[startXPosition][startYPosition] = startElement;

                Possibility possibility = GetPossibleMoves(startXPosition, startYPosition, startElement);
                possibilities.add(possibility);
                result = IteratePossibility(possibilities);
                if (result) {
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        if (result){
            System.out.println(Arrays.deepToString(gameBoard));
        } else {
            System.out.println("istenen sonuca ulasilamadi!");
        }
    }

    private static boolean IteratePossibility(List<Possibility> possibilities) {
        if (possibilities.size()==0){
            return false;
        }
        Possibility possibility = possibilities.get(possibilities.size()-1);
        if (possibility.getCurrentElement() == matrisLength*matrisLength){
            return true;
        }
        if(possibility.getTriedMoves()<possibility.getPossibleMoves()){
            Coordinate coordinate = possibility.getPossibleCoordinates().get(possibility.getTriedMoves());
            possibility.setTriedMoves(possibility.getTriedMoves()+1);
            Possibility possibility_ = GetPossibleMoves(coordinate.getX(), coordinate.getY(), possibility.getCurrentElement()+1);
            possibilities.add(possibility_);
            if(possibility_.getPossibleMoves()>0){
                boolean result = IteratePossibility(possibilities);
                if(result){return result;}
            } else {
                if (possibility_.getCurrentElement() == matrisLength*matrisLength){
                    return true;
                } else {
                    boolean result = IteratePossibility(possibilities);
                    if(result){return result;}
                }
            }
        } else {
            if(possibility.getCurrentCoordinate() != null) {
                gameBoard[possibility.getCurrentCoordinate().getX()][possibility.getCurrentCoordinate().getY()] = 0;
            }
            possibilities.remove(possibilities.size()-1);
            boolean result = IteratePossibility(possibilities);
            if(result){return result;}
        }
        return false;
    }

    private static Possibility GetPossibleMoves(int x, int y, int element) {
        Possibility possibility = new Possibility();
        List<Coordinate> coordinates = new ArrayList<>();
        int possibleMoves = 0;

        if(x==3 && y==3){
            String a = "bora";
        }

        if(element==matrisLength*matrisLength){
            if(gameBoard[x][y]==0){
                gameBoard[x][y]=element;
                possibility.setCurrentElement(element);
            }
        }

        if((x+3)<matrisLength) {
            if (gameBoard[x+3][y]==0){
                possibleMoves++;
                Coordinate coordinate = new Coordinate();
                coordinate.setX(x+3);
                coordinate.setY(y);
                coordinates.add(coordinate);
            }
        }
        if((x-3)>=0) {
            if (gameBoard[x-3][y]==0){
                possibleMoves++;
                Coordinate coordinate = new Coordinate();
                coordinate.setX(x-3);
                coordinate.setY(y);
                coordinates.add(coordinate);
            }
        }
        if((y+3)<matrisLength) {
            if (gameBoard[x][y+3]==0){
                possibleMoves++;
                Coordinate coordinate = new Coordinate();
                coordinate.setX(x);
                coordinate.setY(y+3);
                coordinates.add(coordinate);
            }
        }
        if((y-3)>=0) {
            if (gameBoard[x][y-3]==0){
                possibleMoves++;
                Coordinate coordinate = new Coordinate();
                coordinate.setX(x);
                coordinate.setY(y-3);
                coordinates.add(coordinate);
            }
        }
        if((x+2)<matrisLength && (y+2)<matrisLength) {
            if (gameBoard[x+2][y+2]==0){
                possibleMoves++;
                Coordinate coordinate = new Coordinate();
                coordinate.setX(x+2);
                coordinate.setY(y+2);
                coordinates.add(coordinate);
            }
        }
        if((x+2)<matrisLength && (y-2)>=0) {
            if (gameBoard[x+2][y-2]==0){
                possibleMoves++;
                Coordinate coordinate = new Coordinate();
                coordinate.setX(x+2);
                coordinate.setY(y-2);
                coordinates.add(coordinate);
            }
        }
        if((x-2)>=0 && (y+2)<matrisLength) {
            if (gameBoard[x-2][y+2]==0){
                possibleMoves++;
                Coordinate coordinate = new Coordinate();
                coordinate.setX(x-2);
                coordinate.setY(y+2);
                coordinates.add(coordinate);
            }
        }
        if((x-2)>=0 && (y-2)>=0) {
            if (gameBoard[x-2][y-2]==0){
                possibleMoves++;
                Coordinate coordinate = new Coordinate();
                coordinate.setX(x-2);
                coordinate.setY(y-2);
                coordinates.add(coordinate);
            }
        }

        if(possibleMoves>0){
            gameBoard[x][y]=element;
            Coordinate currentCoordinate = new Coordinate();
            currentCoordinate.setX(x);
            currentCoordinate.setY(y);
            possibility.setCurrentCoordinate(currentCoordinate);
            possibility.setPossibleMoves(possibleMoves);
            possibility.setCurrentElement(element);
            possibility.setPossibleCoordinates(coordinates);
        }

        return possibility;
    }

}