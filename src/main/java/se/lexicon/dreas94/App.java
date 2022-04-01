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
        printFromNameRepositoryByFirstOrLastName(null, "aefadfaf");
        printFromNameRepositoryByFirstOrLastName("Leo", null);

        printAboutNameRepository();
        updateName("Simone Elbrink", "Andre Jansson");
        printAboutNameRepository();
        updateName("Sione Elbrink", "Andreas Eriksson");
        removeNameFromNameRepository("Leo Yoosefi");
        removeNameFromNameRepository("Leo Yoosefi");
        removeNameFromNameRepository("Pär Törnell");
        printAboutNameRepository();
    }

    private static void printAboutNameRepository()
    {
        System.out.println("Name Repository has " + NameRepository.getSize() + " Strings and contains the following: " + Arrays.toString(NameRepository.findAll()) + "\n");
    }

    private static void clearNameRepository()
    {
        NameRepository.clear();
        System.out.println("Name Repository has been cleared of all values");
    }

    private static void addNameToNameRepository(final String fullName)
    {
        if(!NameRepository.add(fullName))
            System.out.println(fullName + " is already in the repository!\n");
        else
            System.out.println(fullName + " was added to the repository!\n");
    }

    private static void removeNameFromNameRepository(final String fullName)
    {
        if(!NameRepository.remove(fullName))
            System.out.println(fullName + " is not in the repository and hence cannot be removed!\n");
        else
            System.out.println(fullName + " was removed to the repository!\n");
    }

    private static void printFromNameRepositoryByFirstOrLastName(final String firstName, final String lastName)
    {
        String[] arrStr;
        if(firstName != null)
        {
            arrStr = NameRepository.findByFirstName(firstName);
            if(arrStr != null)
            {
                System.out.println("Here are all names in repository which has the first name " + firstName + ": " + Arrays.toString(arrStr) + "\n");
            }
            else
            {
                System.out.println("Repository does not contain any names with the first name " + firstName + "\n");
            }
        }
        else if(lastName != null)
        {
            arrStr = NameRepository.findByLastName(lastName);
            if(arrStr != null)
            {
                System.out.println("Here are all names in repository which has the last name " + lastName + ": " + Arrays.toString(arrStr) + "\n");
            }
            else
            {
                System.out.println("Repository does not contain any names with the last name " + lastName + "\n");
            }
        }
    }

    private static void updateName(final String original, final String updatedName)
    {
        if(NameRepository.update(original, updatedName))
        {
            System.out.println(original + " was replaced with " + updatedName + ".\n");
        }
        else
        {
            System.out.println("There is no " + original + "to replace.\n");
        }
    }
}
