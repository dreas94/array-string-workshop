package se.lexicon.dreas94;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class NameRepositoryTest
{
    private String[] data = null;

    @Before
    public void setUp() {
        NameRepository.clear();
        String[] starterData = {"Mehrdad Javan", "Simon Elbrink", "Marcus Gudmundsen"};
        data = starterData;
        NameRepository.setNames(starterData);
    }

    @Test
    public void getSize() {
        int expectedSize = 3;
        int actual = NameRepository.getSize();

        assertEquals(actual, expectedSize);
    }

    @Test
    public void setNames() {
        NameRepository.clear();
        String[] data = {"Erik Svensson", "Ulf Bengtsson"};
        int expectedSize = 2;

        NameRepository.setNames(data);

        assertEquals(NameRepository.getSize(), expectedSize);
    }

    @Test
    public void clear() {
        // todo: implement the method
    }

    @Test
    public void findAll() {
        // todo: implement the method
    }

    @Test
    public void find() {
        // todo: implement the method
    }

    @Test
    public void add() {
        // todo: implement the method
    }

    @Test
    public void add_false(){
        // todo: implement the method
    }

    // add other methods
}
