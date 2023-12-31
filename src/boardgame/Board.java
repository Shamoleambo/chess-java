package boardgame;

public class Board {
	private Integer rows;
	private Integer columns;
	private Piece[][] pieces;

	public Board(Integer rows, Integer columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least one row and one column");
		}
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public Piece piece(Integer row, Integer column) {
		if(!this.positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return this.pieces[row][column];
	}

	public Piece piece(Position position) {
		if(!this.positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return this.pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if(!this.positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		this.pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}

	private Boolean positionExists(Integer row, Integer column) {
		return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
	}

	public Boolean positionExists(Position position) {
		return this.positionExists(position.getRow(), position.getColumn());
	}
	
	public Boolean thereIsAPiece(Position position) {
		if(!this.positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return this.piece(position) != null;
	}

}
