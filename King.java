public class King extends Piece {
    public King(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Board board) {
        return Math.abs(startX - endX) <= 1 && Math.abs(startY - endY) <= 1;
    }

    @Override
    public char getSymbol() {
        return color.equals("white") ? 'K' : 'k';
    }
}
