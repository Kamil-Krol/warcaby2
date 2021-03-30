package com.checkers;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Checkers extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Checkers");
        GridPane gridPane = new GridPane();
        Controller.getInstance().setGridPane(gridPane);

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {

                Field field = new Field(x, y);
                gridPane.add(field, x, y);
                Controller.getInstance().addField(field);

               if(x%2==0 && y%2==1 || x%2==1 && y%2==0)
               {
                   if(y<=2)
                   {
                       Piece piece = new Piece(PieceType.WHITE,x, y);
                       gridPane.add(piece,x,y);
                       Controller.getInstance().addPiece(piece);
                   }
                   if (y>=5)
                   {
                       Piece piece = new Piece(PieceType.BLACK,x, y);
                       gridPane.add(piece,x,y);
                       Controller.getInstance().addPiece(piece);
                   }

               }


            }
        }

        Scene scene = new Scene(gridPane, 8 * Configurations.SIDE_SIZE, 8 * Configurations.SIDE_SIZE);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}

