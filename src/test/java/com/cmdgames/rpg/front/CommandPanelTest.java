package com.cmdgames.rpg.front;

import static org.junit.Assert.*;
import org.junit.Test;


public class CommandPanelTest {


    @Test
    public void validateInitialCommandTest(){
        assertEquals(true, CommandPanel.isStartOptionValid("1"));
        assertEquals(true, CommandPanel.isStartOptionValid("2"));
        assertNotEquals(true, CommandPanel.isStartOptionValid("0"));
        assertNotEquals(true, CommandPanel.isStartOptionValid("3"));
        assertNotEquals(true, CommandPanel.isStartOptionValid("A"));
        assertNotEquals(true, CommandPanel.isStartOptionValid(" "));
    }

    @Test
    public void isStringValidTest(){
        assertFalse(CommandPanel.isStringValid(" "));
        assertFalse(CommandPanel.isStringValid(""));
    }


}
