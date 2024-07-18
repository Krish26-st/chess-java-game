public class Knight extends Piece {
    public Knight(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Board board) {
        int dx = Math.abs(startX - endX);
        int dy = Math.abs(startY - endY);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

    @Override
    public char getSymbol() {
        return color.equals("white") ? 'N' : 'n';
    }
}
