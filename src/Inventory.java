import java.util.ArrayList;

import java.util.ArrayList;

public class Inventory
{
    private ArrayList<Book> mainInventory; // stores books currently available in the library
    private ArrayList<Book> borrowedBooks; // stores books that have been borrowed

    // constructor initializes both inventory lists
    public Inventory()
    {
        mainInventory = new ArrayList<Book>();
        borrowedBooks = new ArrayList<Book>();
    }

    // adds a new book to the main inventory
    public void addBook(Book book)
    {
        mainInventory.add(book);
    }

    // borrows a book by moving it from available inventory to the borrowed books list
    public boolean borrowBook(int id)
    {
        for (int i = 0; i < mainInventory.size(); i++)
        {
            Book book = mainInventory.get(i);

            if (book.getId() == id)
            {
                borrowedBooks.add(book);
                mainInventory.remove(i);
                return true;
            }
        }

        return false; // book not found
    }

    // returns a borrowed book back to main inventory
    public boolean returnBook(int id)
    {
        for (int i = 0; i < borrowedBooks.size(); i++)
        {
            Book book = borrowedBooks.get(i);

            if (book.getId() == id)
            {
                mainInventory.add(book);
                borrowedBooks.remove(i);
                return true;
            }
        }

        return false; // book was not found in borrowed inventory
    }

    // prints all books currently available in the library
    public void printAll()
    {
        if (mainInventory.isEmpty())
        {
            System.out.println("No books in inventory.");
            return;
        }

        for (Book book : mainInventory)
        {
            book.printBookInfo();
        }
    }

    // searches for books using a full or partial title match
    // search is case-insensitive
    public void searchByTitle(String title)
    {
        boolean found = false;

        for (Book book : mainInventory)
        {
            if (book.getTitle().toLowerCase()
                    .contains(title.toLowerCase()))
            {
                book.printBookInfo();
                found = true;
            }
        }

        if (!found)
        {
            System.out.println("No matching book found.");
        }
    }

    // returns the number of books currently available
    public int getMainInventoryCount()
    {
        return mainInventory.size();
    }
}

    public void printAll() // prints all books currently available in the library
    {
        if (mainInventory.isEmpty())
        {
            System.out.println("No books in inventory.");
            return;
        }

        for (Book book : mainInventory)
        {
            book.printBookInfo();
        }
    }

    public void searchByTitle(String title) // search for books using a full or partial title match
    {                                       // search is case-insensitive
        boolean found = false;

        for (Book book : mainInventory)
        {
            if (book.getTitle().toLowerCase()
                    .contains(title.toLowerCase()))
                {
                    book.printBookInfo();
                    found = true;
                }
        }

        if (!found)
        {
            System.out.println("No matching book found.");
        }
    }

    public int getMainInventoryCount() // returns the number of books currently available
    {
        return mainInventory.size();
    }
}
