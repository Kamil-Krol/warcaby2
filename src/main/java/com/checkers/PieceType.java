package com.checkers;

public enum PieceType {
    WHITE(1),BLACK(-1);
    final int moveDir;

    PieceType(int moveDir)
    {
        this.moveDir = moveDir;
    }
}
