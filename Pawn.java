public class Pawn extends Piece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Board board) {
        int direction = color.equals("white") ? 1 : -1;
        if (startX + direction == endX && startY == endY && board.getPiece(endX, endY) == null) {
            return true;
        }
        if (startX == (color.equals("white") ? 1 : 6) && startX + 2 * direction == endX && startY == endY && board.getPiece(endX, endY) == null && board.getPiece(startX + direction, startY) == null) {
            return true;
        }
        if (startX + direction == endX && Math.abs(startY - endY) == 1 && board.getPiece(endX, endY) != null && !board.getPiece(endX, endY).getColor().equals(color)) {
            return true;
        }
        return false;
    }

    @Override
    public char getSymbol() {
        return color.equals("white") ? 'P' : 'p';
    }
}
