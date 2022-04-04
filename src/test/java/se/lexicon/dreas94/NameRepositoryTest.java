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
    public void clear()
    {
        NameRepository.clear();
        int expectedSize = 0;
        assertEquals(NameRepository.getSize(), expectedSize);
    }

    @Test
    public void findAll()
    {
        NameRepository.clear();
        String[] data = {"Erik Svensson", "Ulf Bengtsson"};

        NameRepository.setNames(data);

        assertArrayEquals(NameRepository.findAll(), data);
    }

    @Test
    public void find()
    {
        NameRepository.clear();
        String[] data = new String[] {"Erik Svensson", "Andreas Eriksson", "Mehrdad Javan", "Ulf Bengtsson"};

        NameRepository.setNames(data);

        String name = data[3];

        assertEquals(NameRepository.find(name), name);
    }

    @Test
    public void add()
    {
        NameRepository.clear();
        String[] data = new String[] {"Erik Svensson", "Andreas Eriksson", "Mehrdad Javan", "Ulf Bengtsson"};

        NameRepository.setNames(data);

        String name = "Tabea Teufel";

        assertTrue(NameRepository.add(name));
        assertEquals(NameRepository.find(name), name);
    }

    @Test
    public void add_false()
    {
        NameRepository.clear();
        String[] data = new String[] {"Erik Svensson", "Andreas Eriksson", "Mehrdad Javan", "Ulf Bengtsson"};

        NameRepository.setNames(data);

        String name = "Andreas Eriksson";

        assertFalse(NameRepository.add(name));
    }

    // add other methods
}
