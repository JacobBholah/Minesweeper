package com.tsi.training.bholah.jacob.minesweeper;

import com.tsi.training.bholah.jacob.minesweeper.Tile;

import java.util.Arrays;

public class Board {
    ////attributes/////

    Tile[][] board = new Tile[10][10];//2d array of tile objects
    public int length = board.length;
    public int width = board[0].length;
    public int numberofbombs = 10;

    ////constructors////

    public Board() {
        int bombx;
        int bomby;
        int i;
        int j;

        for (i = 0; i < numberofbombs; i += 1) {
            bombx = (int) (Math.random() * 10);
            bomby = (int) (Math.random() * 10);

            board[bombx][bomby] = new Bomb(bombx, bomby, true, false);//placing a bomb in the array(on the board)
        }

        for (i = 0; i < length; i += 1) {
            for (j = 0; j < width; j += 1) {
                if (board[i][j] != null)
                    continue;

                int z = 0;
                if (i - 1 > 0 && board[i - 1][j] != null && board[i - 1][j].getvalue() == 9)
                    z += 1;
                if (i - 1 > 0 && j + 1 < 10 && board[i - 1][j + 1] != null && board[i - 1][j + 1].getvalue() == 9)
                    z += 1;
                if (j + 1 < 10 && board[i][j + 1] != null && board[i][j + 1].getvalue() == 9)
                    z += 1;
                if (i + 1 < 10 && j + 1 < 10 && board[i + 1][j + 1] != null && board[i + 1][j + 1].getvalue() == 9)
                    z += 1;
                if (i + 1 < 10 && board[i + 1][j] != null && board[i + 1][j].getvalue() == 9)
                    z += 1;
                if (i + 1 < 10 && j - 1 > 0 && board[i + 1][j - 1] != null && board[i + 1][j - 1].getvalue() == 9)
                    z += 1;
                if (j - 1 > 0 && board[i][j - 1] != null && board[i][j - 1].getvalue() == 9)
                    z += 1;
                if (i - 1 > 0 && j - 1 > 0 && board[i - 1][j - 1] != null && board[i - 1][j - 1].getvalue() == 9)
                    z += 1;

                board[i][j] = new Empty(z, i, j, true, false);//placing emptys into the board
            }
        }


    }

    /////method//////


    public int getlength() {
        return length;
    }

    public int getwidth() {
        return width;
    }

    public void reveal(int i, int j)
    {
        if (i>9 || i<0 || j>9 || j<0)
        {
            System.out.println("No tile here");
        }
        else if (board[i][j].getvalue() == 9)//if theres a bomb
        {
            board[i][j].setRevealstate(true);
            System.out.println("Game over Loser");
        }

        else if (board[i][j].getvalue() == 0)//if theres an empty space
        {
            //int[][]revealarray = {{i-1,j},{i-1,j+1},{i,j+1},{i+1,j+1},{i+1,j},{i+1,j-1},{i,j-1},{i-1,j-1}};
            //for(int i:revealarray)
            board[i][j].setRevealstate(true);
            reveal(i - 1,j);
            reveal(i - 1,j + 1);
            reveal(i,j + 1);
            reveal(i+1,j+1);
            reveal(i +1,j);
            reveal(i + 1,j-1);
            reveal(i,j-1);
            reveal(i - 1,j-1);
        }
        else if (board[i][j].getvalue()>0 && board[i][j].getvalue()<9)
        {
            board[i][j].setRevealstate(true);
            System.out.println("no bomb boss");
        }

        }

    @Override// sets a deeptostring for the board
    public String toString() {
        String str = "";
        for (Tile[] tile : board) {
            str += Arrays.toString(tile) + "\n";
        }
        return str;
    }
}


