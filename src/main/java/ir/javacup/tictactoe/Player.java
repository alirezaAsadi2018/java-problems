package ir.javacup.tictactoe;

public class Player {
	
	private IBoard board;
	private PlayerMark mark;

	public Player(IBoard board, PlayerMark mark) {
		this.board = board;
		this.mark = mark;
	}

	public boolean isWinner() {
		String[][] state = board.getState();
		boolean okLeft = true;
		boolean okRight = true;
		for (int i = 0; i < state.length; i++) {
			if(!state[i][i].equals(mark.toString())) {
				okLeft = false;
			}
			if(!state[i][state.length - i - 1].equals(mark.toString())) {
				okRight = false;
			}
			boolean okRow = true;
			boolean okCol = true;
			for (int j = 0; j < state[i].length; j++) {
				if(!state[i][j].equals(mark.toString())) {
					okRow = false;
				}
				if(!state[j][i].equals(mark.toString())) {
					okCol = false;
				}
			}
			if(okRow || okCol)
				return true;
		}
		if(okLeft || okRight)
			return true;
		return false;
	}

	public BoardCell move() {
		String[][] state = board.getState();
		int forZigRightCount = 0;
		int agZigRightCount = 0;
		int forZigLeftCount = 0;
		int agZigLeftCount = 0;
		for (int i = 0; i < state.length; i++) {
			if(state[i][i].equals(mark.toString())) {
				++forZigLeftCount;
			}else if(!state[i][i].equals("-")){
				++agZigLeftCount;
			}
			if(state[i][state.length - i - 1].equals(mark.toString())) {
				++forZigRightCount;
			}else if(!state[i][state.length - i - 1].equals("-")){
				++agZigRightCount;
			}
		}
		// condition one
		if(forZigLeftCount == state.length - 1){
			for (int i = 0; i < state.length; i++) {
				if(state[i][i].equals("-"))
					return new BoardCell(i, i);
			}
		}
		if(forZigRightCount == state.length - 1){
			for (int i = 0; i < state.length; i++) {
				if(state[i][state.length - i - 1].equals("-"))
					return new BoardCell(i, state.length - i - 1);
			}
		}

		for (int i = 0; i < state.length; i++) {
			int forRowCount = 0;
			int forColCount = 0;
			for (int j = 0; j < state[i].length; j++) {
				if(state[i][j].equals(mark.toString())) {
					++forRowCount;
				}
				if(state[j][i].equals(mark.toString())){
					++forColCount;
				}
			}
			if(forRowCount == state.length - 1){
				for (int j = 0; j < state[i].length; j++) {
					if(state[i][j].equals("-"))
						return new BoardCell(i, j);
				}
			}
			if(forColCount == state.length - 1){
				for (int j = 0; j < state[i].length; j++) {
					if(state[j][i].equals("-"))
						return new BoardCell(j, i);
				}
			}
		}
		// condition two
		if(agZigLeftCount == state.length - 1){
			for (int i = 0; i < state.length; i++) {
				if(state[i][i].equals("-"))
					return new BoardCell(i, i);
			}
		}
		if(agZigRightCount == state.length - 1){
			for (int i = 0; i < state.length; i++) {
				if(state[i][state.length - i - 1].equals("-"))
					return new BoardCell(i, state.length - i - 1);
			}
		}
		for (int i = 0; i < state.length; i++) {
			int agRowCount = 0;
			int agColCount = 0;
			for (int j = 0; j < state[i].length; j++) {
				if (!state[i][j].equals(mark.toString()) && !state[i][j].equals("-")) {
					++agRowCount;
				}
				if (!state[j][i].equals(mark.toString()) && !state[j][i].equals("-")) {
					++agColCount;
				}
			}
			if(agRowCount == state.length - 1){
				for (int j = 0; j < state[i].length; j++) {
					if(state[i][j].equals("-"))
						return new BoardCell(i, j);
				}
			}
			if(agColCount == state.length - 1){
				for (int j = 0; j < state[i].length; j++) {
					if(state[j][i].equals("-"))
						return new BoardCell(j, i);
				}
			}
		}
		// condition three
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state[i].length; j++) {
				if(state[i][j].equals("-"))
					return new BoardCell(i, j);
			}
		}

		return null;
	}

}
