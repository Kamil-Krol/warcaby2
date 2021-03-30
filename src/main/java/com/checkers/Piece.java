package com.checkers;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Piece extends Circle {
    private final int x;
    private final int y;
    private PieceType type;
    private double mouseX, mouseY, oldX, oldY;

    private boolean isChosen = false;




    public PieceType getType()
    {
        return type;
    }

    public Piece(PieceType type, double x, double y) {
        super(x, y, Configurations.SIDE_SIZE * 0.4, choosePaint(type));
        this.type = type;
        this.x = (int) x;
        this.y = (int) y;

        this.setOnMouseClicked(event -> Controller.getInstance().pieceClicked(this));
    }
    private static Paint choosePaint( PieceType type) {
        if(type == PieceType.WHITE)
        {
            return Color.WHITE;
        }
        else
        {
            return Color.BLACK;
        }


    }

    public boolean isChosen() {
        return isChosen;
    }

    public void setChosen(boolean chosen) {
        isChosen = chosen;
    }

    public int getCol() {
        return x;
    }

    public int getRow() {
        return y;
    }

    public void move(int x, int y)
    {
        oldX = x * Configurations.SIDE_SIZE;
        oldY = y * Configurations.SIDE_SIZE;
        relocate(oldX,oldY);
    }
    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Piece piece = (Piece) o;

        if (x != piece.x)
            return false;
        return y == piece.y;
    }

    @Override public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }


}
