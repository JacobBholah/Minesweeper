package com.tsi.training.bholah.jacob.minesweepertest;
import com.tsi.training.bholah.jacob.minesweeper.Bomb;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BombTest {

    @Test
    public void testbomb()
    {
        Bomb testbomb = new Bomb(1,1,true,false);
        assertEquals(9,testbomb.getvalue(),"this is not a bomb");
    }
}
