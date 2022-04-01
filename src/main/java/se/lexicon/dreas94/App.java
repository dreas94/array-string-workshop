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
        String[] names = new String[] {"Erik Svensson", "Andreas Eriksson", "Mehrdad Javan"};
        NameRepository.setNames(names);
        printAboutNameRepository();
        NameRepository.clear();
        printAboutNameRepository();

        addNameToNameRepository("Leo Yoosefi");
        addNameToNameRepository("Leo Yoosefi");
        addNameToNameRepository("Pär Törnell");
        addNameToNameRepository("Simon Elbrink");

        printAboutNameRepository();

        addNameToNameRepository("Simone Elbrink");
        addNameToNameRepository("Peter Törnell");
        addNameToNameRepository("Leo Eriksson");

        printFromNameRepositoryByFirstOrLastName(null, "Elbrink");
        printFromNameRepositoryByFirstOrLastName(null, "aefadfaf dafsafggha");
        printFromNameRepositoryByFirstOrLastName("Leo", null);

        printAboutNameRepository();
        updateName("Simone Elbrink", "Andreas Eriksson");
        printAboutNameRepository();
    }

    private static void printAboutNameRepository()
    {
        System.out.println("The Array has " + NameRepository.getSize() + " Strings and contains the following: " + Arrays.toString(NameRepository.findAll()));
    }

    private static void addNameToNameRepository(final String fullName)
    {
        if(!NameRepository.add(fullName))
            System.out.println(fullName + " is already in the repository!");
    }

    private static void printFromNameRepositoryByFirstOrLastName(final String firstName, final String lastName)
    {
        String[] arrStr;
        if(firstName != null)
        {
            arrStr = NameRepository.findByFirstName(firstName);
            if(arrStr != null)
            {
                System.out.println("Here are all names in repository which has the first name " + firstName + ": " + Arrays.toString(arrStr));
            }
            else
            {
                System.out.println("Repository does not contain any names with the first name " + firstName);
            }
        }
        else if(lastName != null)
        {
            arrStr = NameRepository.findByLastName(lastName);
            if(arrStr != null)
            {
                System.out.println("Here are all names in repository which has the last name " + lastName + ": " + Arrays.toString(arrStr));
            }
            else
            {
                System.out.println("Repository does not contain any names with the last name " + lastName);
            }
        }
    }

    private static void updateName(final String original, final String updatedName)
    {
        if(NameRepository.update(original, updatedName))
        {
            System.out.println(original + " was replaced with " + updatedName + ".");
        }
        else
        {
            System.out.println("There is no " + original + "to replace.");
        }
    }
}
