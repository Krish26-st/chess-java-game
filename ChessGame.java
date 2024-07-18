import java.util.Scanner;

public class ChessGame {
    private final Board board;
    private String currentPlayer;
    private final Checkmate checkmate;

    public ChessGame() {
        board = new Board();
        currentPlayer = "white";
        checkmate = new Checkmate();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.printBoard();
            if (checkmate.isInCheck(currentPlayer, board)) {
                if (checkmate.isCheckmate(currentPlayer, board)) {
                    System.out.println(currentPlayer + " is in checkmate. " + (currentPlayer.equals("white") ? "Black" : "White") + " wins!");
                    break;
                }
                System.out.println(currentPlayer + " is in check!");
            } else if (checkmate.isStalemate(currentPlayer, board)) {
                System.out.println("Stalemate! It's a draw!");
                break;
            }

            System.out.println(currentPlayer + "'s turn");
            System.out.print("Enter move (e.g., e2 e4): ");
            String move = scanner.nextLine();
            String[] parts = move.split(" ");
            int startX = parts[0].charAt(1) - '1';
            int startY = parts[0].charAt(0) - 'a';
            int endX = parts[1].charAt(1) - '1';
            int endY = parts[1].charAt(0) - 'a';

            Piece piece = board.getPiece(startX, startY);
            if (piece != null && piece.getColor().equals(currentPlayer) &&
                    piece.isValidMove(startX, startY, endX, endY, board)) {
                Piece capturedPiece = board.getPiece(endX, endY);
                board.setPiece(endX, endY, piece);
                board.setPiece(startX, startY, null);
                if (checkmate.isInCheck(currentPlayer, board)) {
                    board.setPiece(startX, startY, piece);
                    board.setPiece(endX, endY, capturedPiece);
                    System.out.println("Invalid move, you cannot put yourself in check. Try again.");
                } else {
                    currentPlayer = currentPlayer.equals("white") ? "black" : "white";
                }
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.play();
    }
}
