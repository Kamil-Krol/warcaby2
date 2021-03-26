package com.checkers;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Controller {
    private static final Controller INSTANCE = new Controller();
    private List<Field> fields = new ArrayList<>();
    private List<Piece> pieces = new ArrayList<>();
    private Piece chosenPiece;
    private GridPane gridPane;

    private Controller() {
    }

    public static Controller getInstance() {
        return INSTANCE;
    }

    void addField(Field field) {
        fields.add(field);
    }

    void addPiece(Piece piece)
    {
        pieces.add(piece);
    }


    public void onFieldClick(Field field) {
        int col = field.getCol();
        int row = field.getRow();
        System.out.println("Element clicked col=" + col + ", row=" + row);

        if(chosenPiece == null){
            System.out.println("No piece chosen");
            return;
        }

        Piece piece = new Piece(PieceType.BLACK,col, row);
        gridPane.add(piece,col,row);

        int oldCol = chosenPiece.getCol();
        int oldRow = chosenPiece.getRow();
        gridPane.getChildren().remove(new Piece(PieceType.BLACK, oldCol, oldRow));
        chosenPiece = null;

    }

    public void pieceClicked(Piece piece) {
        if(piece.getType().equals(PieceType.WHITE)){
            System.out.println("Hey, you're playing using BLACK not WHITE");
            return;
        }

        System.out.println("Piece clicked "+piece.getCol()+ " " +piece.getRow());
        if(piece.isChosen()){ //clicked second type
            piece.setFill(Color.valueOf(piece.getType().name()));
            chosenPiece = null;
        }else {
            piece.setFill(Color.RED);
            chosenPiece = piece;
        }
        piece.setChosen(!piece.isChosen());


    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }
}
