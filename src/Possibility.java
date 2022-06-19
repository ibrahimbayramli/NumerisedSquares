import java.util.List;

public class Possibility {
    private int currentElement;
    private Coordinate currentCoordinate;
    private int possibleMoves;
    private int triedMoves;
    private List<Coordinate> possibleCoordinates;

    public int getCurrentElement() {
        return currentElement;
    }

    public void setCurrentElement(int currentElement) {
        this.currentElement = currentElement;
    }

    public Coordinate getCurrentCoordinate() {
        return currentCoordinate;
    }

    public void setCurrentCoordinate(Coordinate currentCoordinate) {
        this.currentCoordinate = currentCoordinate;
    }

    public int getPossibleMoves() {
        return possibleMoves;
    }

    public void setPossibleMoves(int possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public int getTriedMoves() {
        return triedMoves;
    }

    public void setTriedMoves(int triedMoves) {
        this.triedMoves = triedMoves;
    }

    public List<Coordinate> getPossibleCoordinates() {
        return possibleCoordinates;
    }

    public void setPossibleCoordinates(List<Coordinate> possibleCoordinates) {
        this.possibleCoordinates = possibleCoordinates;
    }
}
