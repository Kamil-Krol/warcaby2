package com.checkers;

public class MoveResult {
    private MoveType moveType;

    public MoveType getMoveType() {
        return moveType;
    }
    private Piece piece;

    public Piece getPiece()
    {
        return piece;
    }

    public MoveResult(MoveType moveType)
    {
        this(moveType, null);
    }

    public MoveResult(MoveType moveType, Piece piece) {
        this.moveType = moveType;
        this.piece = piece;
    }
}
