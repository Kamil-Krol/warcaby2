package com.checkers;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Piece extends Circle {
    private final int x;
    private final int y;
    private PieceType type;

    public PieceType getType()
    {
        return type;
    }

    public Piece (PieceType type, double x, double y )
    {
        //super(x, y, choosePaint(type));
        super(x,y,Configurations.SIDE_SIZE*0.4,choosePaint(type));
        this.setCenterX(Configurations.SIDE_SIZE);
        this.setCenterY(Configurations.SIDE_SIZE);
        //this.setRadius(Configurations.SIDE_SIZE*0.1);
        this.type = type;
        this.x = (int) x;
        this.y = (int) y;

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

    public int getCol() {
        return x;
    }

    public int getRow() {
        return y;
    }

}
