public class Checkmate {
    public boolean isInCheck(String color, Board board) {
        int[] kingPosition = findKing(color, board);
        int kingX = kingPosition[0];
        int kingY = kingPosition[1];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getPiece(i, j);
                if (piece != null && !piece.getColor().equals(color)) {
                    if (piece.isValidMove(i, j, kingX, kingY, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int[] findKing(String color, Board board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getPiece(i, j);
                if (piece instanceof King && piece.getColor().equals(color)) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public boolean isCheckmate(String color, Board board) {
        if (!isInCheck(color, board)) {
            return false;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getPiece(i, j);
                if (piece != null && piece.getColor().equals(color)) {
                    for (int x = 0; x < 8; x++) {
                        for (int y = 0; y < 8; y++) {
                            Piece temp = board.getPiece(x, y);
                            if (piece.isValidMove(i, j, x, y, board)) {
                                board.setPiece(x, y, piece);
                                board.setPiece(i, j, null);
                                if (!isInCheck(color, board)) {
                                    board.setPiece(i, j, piece);
                                    board.setPiece(x, y, temp);
                                    return false;
                                }
                                board.setPiece(i, j, piece);
                                board.setPiece(x, y, temp);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isStalemate(String color, Board board) {
        if (isInCheck(color, board)) {
            return false;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getPiece(i, j);
                if (piece != null && piece.getColor().equals(color)) {
                    for (int x = 0; x < 8; x++) {
                        for (int y = 0; y < 8; y++) {
                            Piece temp = board.getPiece(x, y);
                            if (piece.isValidMove(i, j, x, y, board)) {
                                board.setPiece(x, y, piece);
                                board.setPiece(i, j, null);
                                if (!isInCheck(color, board)) {
                                    board.setPiece(i, j, piece);
                                    board.setPiece(x, y, temp);
                                    return false;
                                }
                                board.setPiece(i, j, piece);
                                board.setPiece(x, y, temp);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
