import java.awt.Button;

public class ButtonPM {
    private int col;
    private int row;
    private Button [][] buttons;

    ButtonPM(int col,int row) {
        this.col = col;
        this.row = row;
        this.buttons = new Button[this.row][this.col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.buttons[i][j] = new Button("");
            }
        }
    }

    Button getButton(int row, int col) {
        return this.buttons[row][col];
    }

    int getCol() {
        return this.col;
    }
    
    int getRow() {
        return this.row;
    }
}

