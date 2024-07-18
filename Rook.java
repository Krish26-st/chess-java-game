public class Rook extends Piece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Board board) {
        if (startX == endX) {
            for (int i = Math.min(startY, endY) + 1; i < Math.max(startY, endY); i++) {
                if (board.getPiece(startX, i) != null) return false;
            }
            return true;
        }
        if (startY == endY) {
            for (int i = Math.min(startX, endX) + 1; i < Math.max(startX, endX); i++) {
                if (board.getPiece(i, startY) != null) return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public char getSymbol() {
        return color.equals("white") ? 'R' : 'r';
    }
}
