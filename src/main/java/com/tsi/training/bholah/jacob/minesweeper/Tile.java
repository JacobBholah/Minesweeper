package com.tsi.training.bholah.jacob.minesweeper;

public abstract class Tile {
    /////attributes////
    private int value;// if the tile is a bomb or number
    private int x, y;// where on the board the tile is
    private boolean revealstate;// if the tile is revealed or not
    private boolean flagstate;// if the tile is revealed or not

    ////constructors////
    public Tile(int value, int x, int y, boolean revealstate, boolean flagstate) {
        this.value = value;
        this.x = x;
        this.y = y;
        this.revealstate = revealstate;
        this.flagstate = flagstate;
    }

    ////methods////
    public abstract void reveal(int x, int y);


    public void flag(int position) {
        // if the state of the tile is unrevealed then a flag can be placed
        System.out.println(x + y + "was flagged");
    }

    public void unflag(int position) {
        // if the tile is flagged then it can be unflaged
        System.out.println(x + y + "was unflaged");
    }

    @Override
    public String toString() // sets a deeptostring for the Tile
    {
        if (revealstate==true)//prints either a reveal or unrevealed board
        {
            return value + "";
        }
        else
        {
            return "?";
        }
    }

    public void setRevealstate(boolean revealstate) {
        this.revealstate = revealstate;
    }

    public int getvalue() {
        return value;
    }

    //public void setBreed(int value) {this.value = value;}
}