public class Bishop extends Piece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Board board) {
        if (Math.abs(startX - endX) == Math.abs(startY - endY)) {
            int xDirection = startX < endX ? 1 : -1;
            int yDirection = startY < endY ? 1 : -1;
            int x = startX + xDirection;
            int y = startY + yDirection;
            while (x != endX && y != endY) {
                if (board.getPiece(x, y) != null) return false;
                x += xDirection;
                y += yDirection;
            }
            return true;
        }
        return false;
    }

    @Override
    public char getSymbol() {
        return color.equals("white") ? 'B' : 'b';
    }
}
