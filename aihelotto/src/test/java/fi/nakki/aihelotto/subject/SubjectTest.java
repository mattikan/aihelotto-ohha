/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.nakki.aihelotto.subject;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nakki
 */
public class SubjectTest {

    /**
     * Test of toString method, of class Subject.
     */
    @Test
    public void testToString() {
        Subject instance = new Subject("asdf", "fgsfds", "xkcd");
        String expResult = "Name: asdf\nGroup: fgsfds\nDescription: xkcd";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToStringNoDescription() {
        Subject instance = new Subject("asdf", "fgsfds");
        assertEquals("Name: asdf\nGroup: fgsfds", instance.toString());
    }

    @Test
    public void testGetName() {
        Subject instance = new Subject("asdf", "fgsfds", "xkcd");
        assertEquals("asdf", instance.getName());
    }

    @Test
    public void testGetGroup() {
        Subject instance = new Subject("asdf", "fgsfds", "xkcd");
        assertEquals("fgsfds", instance.getGroup());
    }

    @Test
    public void testGetDescription() {
        Subject instance = new Subject("asdf", "fgsfds", "xkcd");
        assertEquals("xkcd", instance.getDescription());
    }
}
