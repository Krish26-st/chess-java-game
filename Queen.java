public class Queen extends Piece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Board board) {
        Rook rookMove = new Rook(color);
        Bishop bishopMove = new Bishop(color);
        return rookMove.isValidMove(startX, startY, endX, endY, board) || bishopMove.isValidMove(startX, startY, endX, endY, board);
    }

    @Override
    public char getSymbol() {
        return color.equals("white") ? 'Q' : 'q';
    }
}
