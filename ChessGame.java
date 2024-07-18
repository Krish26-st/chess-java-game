import java.util.Scanner;

public class ChessGame {
    private final Board board;
    private String currentPlayer;

    public ChessGame() {
        board = new Board();
        currentPlayer = "white";
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.printBoard();
            System.out.println(currentPlayer + "'s turn");

            // Get user input for move
            System.out.print("Enter move (e.g., e2 e4): ");
            String move = scanner.nextLine();
            String[] parts = move.split(" ");
            int startX = parts[0].charAt(1) - '1';
            int startY = parts[0].charAt(0) - 'a';
            int endX = parts[1].charAt(1) - '1';
            int endY = parts[1].charAt(0) - 'a';

            // Validate and make move
            Piece piece = board.getPiece(startX, startY);
            if (piece != null && piece.getColor().equals(currentPlayer) &&
                    piece.isValidMove(startX, startY, endX, endY, board)) {
                board.setPiece(endX, endY, piece);
                board.setPiece(startX, startY, null);
                currentPlayer = currentPlayer.equals("white") ? "black" : "white";
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
