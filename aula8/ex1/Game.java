package aula8.ex1;



public class Game {
	public final char JOGADOR_X;
	public final char JOGADOR_O;
	
	private static char [][] board;
	public static int victoryX;
	public static int victoryO;
	public static int draw;
	public static int nGames;
	public static char lastPlayer;
	private int lastLine;
	private int lastColumn;
	private int nMoves;
	
	public Game(char jx,char jo) {
		board = new char[3][3];
		for(int i = 0; i < 3; i++) {
			for(int k = 0; i < 3; i++) {
				board[i][k] = '\0';
			}
		}
		JOGADOR_X = jx;
		JOGADOR_O = jo;
		lastPlayer = '\0';
		lastLine = -1;
		lastColumn = -1;
		nMoves = 0;
	}
	
	public char getLastPlayer() {
		return lastPlayer;
	}
	public int getnMoves() {
		return nMoves;
	}
	
	public boolean lastPlayerWon() {
		boolean result;
		result = validate(lastLine,lastColumn,-1,0) + 1 + validate(lastLine,lastColumn,+1,0)  == 3;
		if (result == false) 
			result = validate(lastLine,lastColumn,0,-1) + 1 + validate(lastLine,lastColumn,0,+1) == 3;
		if (result == false)
			result = validate(lastLine,lastColumn,-1,-1) + 1 + validate(lastLine,lastColumn,+1,+1) == 3;
		if(result == false)
			result = validate(lastLine,lastColumn,-1,+1) + 1 + validate(lastLine,lastColumn,+1,-1) == 3;
		return result;
	}
	private int validate(int line,int column, int dline,int dcolumn) {
		int l = line + dline;
		int c = column + dcolumn;
		int validate = 0;
		if(l >= 0 && l < 3 && c >= 0 && c < 3 && board[l][c] == lastPlayer) {
			validate = 1 + validate(l,c,dline,dcolumn);
		}
		return validate;
		
	}
	public boolean finished() {
		return lastPlayer != '\0' && lastPlayerWon() || nMoves >= 9;
	}
	private boolean isValid(int line,int column) {
		return (board[line-1][column-1] == '\0') && finished() == false;
	}
	
	public void play(int line,int column) {
		assert isValid(line,column);
		lastPlayer = (lastPlayer != JOGADOR_X) ? JOGADOR_X : JOGADOR_O;
		lastLine = line - 1;
		lastColumn = column -1;
		board[lastLine][lastColumn] = lastPlayer;
		nMoves ++;
		
	}
	
}
