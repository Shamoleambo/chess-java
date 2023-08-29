package chess;

import boardgame.Position;

public class ChessPosition {
	private Integer row;
	private Character column;

	public ChessPosition(Character column, Integer row) {
		if (row < 1 || row > 8 || column < 'a' || column > 'h') {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.row = row;
		this.column = column;
	}

	public Integer getRow() {
		return row;
	}

	public Character getColumn() {
		return column;
	}

	protected Position toPosition() {
		return new Position(8 - this.row, this.column - 'a');
	}

	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + this.column + this.row;
	}

}
