
public class CrosswordPuzzle {
	private Square[][] puzzle;

	public CrosswordPuzzle(boolean[][] blackSquares) {
		int labelCounter = 1;
		puzzle = new Square[blackSquares.length][blackSquares[0].length];
		for (int row = 0; row < blackSquares.length; row++) {
			for (int column = 0; column < blackSquares.length; column++) {
				if (blackSquares[row][column] == true) {
					puzzle[row][column] = new Square(true, 0);
				} else {
					if (toBeLabeled(row, column, blackSquares) == true) {
						puzzle[row][column] = new Square(false, labelCounter);
						labelCounter++;
					} else {
						puzzle[row][column] = new Square(false, 0);
					}
				}
			}
		}
	}

	private boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {
		if ((r == 0 || c == 0) || blackSquares[r - 1][c] == true || blackSquares[r][c - 1] == true) {
			return true;
		}
		return false;
	}
}
