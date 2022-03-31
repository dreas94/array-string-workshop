package se.lexicon.dreas94;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        NameRepository nameRepository = new NameRepository();
        String[] names = new String[] {"Erik", " ", "Svensson"};
        nameRepository.setNames(names);
        printAboutNameRepository(nameRepository);
        nameRepository.clear();
        printAboutNameRepository(nameRepository);
    }

    private static void printAboutNameRepository(NameRepository nameRepository)
    {
        System.out.println("The Array has " + nameRepository.getSize() + " Strings and contains the following: " + Arrays.toString(nameRepository.findAll()));
    }
}
