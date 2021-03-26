package com.checkers;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Field extends Rectangle {
    private final int x;
    private final int y;

    public Field(double x, double y) {
        super(x, y, choosePaint(x, y));
        this.setHeight(Configurations.SIDE_SIZE);
        this.setWidth(Configurations.SIDE_SIZE);
        this.x = (int) x;
        this.y = (int) y;
        //this.setOnMouseClicked(event -> Controller.getInstance().onClick(this));
    }

    private static Paint choosePaint(double x, double y) {
        if ((x + y) % 2 == 0) {
            return Color.WHITE;
        }
        return Color.BURLYWOOD;
    }

    public int getCol() {
        return x;
    }

    public int getRow() {
        return y;
    }
}
