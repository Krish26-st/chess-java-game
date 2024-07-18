public class Board {
    private final Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        setupBoard();
    }

    private void setupBoard() {
        // Initialize pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("white");
            board[6][i] = new Pawn("black");
        }

        // Initialize rooks
        board[0][0] = new Rook("white");
        board[0][7] = new Rook("white");
        board[7][0] = new Rook("black");
        board[7][7] = new Rook("black");

        // Initialize knights
        board[0][1] = new Knight("white");
        board[0][6] = new Knight("white");
        board[7][1] = new Knight("black");
        board[7][6] = new Knight("black");

        // Initialize bishops
        board[0][2] = new Bishop("white");
        board[0][5] = new Bishop("white");
        board[7][2] = new Bishop("black");
        board[7][5] = new Bishop("black");

        // Initialize queens
        board[0][3] = new Queen("white");
        board[7][3] = new Queen("black");

        // Initialize kings
        board[0][4] = new King("white");
        board[7][4] = new King("black");
    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public void setPiece(int x, int y, Piece piece) {
        board[x][y] = piece;
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j].getSymbol() + " ");
                }
            }
            System.out.println();
            }

        }
    }
