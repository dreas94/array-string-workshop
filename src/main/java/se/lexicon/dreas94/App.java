package se.lexicon.dreas94;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    private static NameRepository nameRepository = new NameRepository();

    public static void main( String[] args )
    {
        String[] names = new String[] {"Erik Svensson", "Andreas Eriksson", "Mehrdad Javan"};
        nameRepository.setNames(names);
        printAboutNameRepository();
        nameRepository.clear();
        printAboutNameRepository();

        addNameToNameRepository("Leo Yoosefi");
        addNameToNameRepository("Leo Yoosefi");
        addNameToNameRepository("Pär Törnell");
        addNameToNameRepository("Simon Elbrink");

        printAboutNameRepository();
    }

    private static void printAboutNameRepository()
    {
        System.out.println("The Array has " + nameRepository.getSize() + " Strings and contains the following: " + Arrays.toString(nameRepository.findAll()));
    }

    private static void addNameToNameRepository(final String fullName)
    {
        if(!nameRepository.add(fullName))
            System.out.println(fullName + " is already in the repository!");
    }
}
