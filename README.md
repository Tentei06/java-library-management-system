# Java Library Management System

A Java console-based library management application developed for a Programming II coursework assignment at Colorado State University Global.

The project demonstrates object-oriented programming, inventory management, Java collections, menu-driven interaction, and exception handling through a fictional library called **Raven Hall Library**.

The application allows users to add books, borrow and return books, search the available collection by title, and display the current inventory.

## Project Overview

Raven Hall Library is a menu-driven Java application that manages a small collection of books.

The system uses three classes:

- `Book` — Represents an individual book and its information.
- `Inventory` — Manages available and borrowed books.
- `LibrarySystem` — Provides the interactive console menu and handles user input.

The application maintains two separate `ArrayList<Book>` collections: one for books currently available in the library and another for books that have been borrowed.

When a book is borrowed, it moves from the available inventory to the borrowed collection. When returned, it moves back into the available inventory.

This demonstrates how multiple classes can work together to manage a shared collection of objects.

## Features

- Interactive console menu with six options
- Add new books to the library inventory
- Borrow books using their ID numbers
- Return previously borrowed books
- Search available books by full or partial title
- Case-insensitive title searching
- Display all currently available books
- Store book information using Java objects
- Manage available and borrowed books with `ArrayList`
- Handle invalid numerical input using exceptions
- Continue displaying the menu until the user exits
- Includes screenshots of development, execution, and testing

## Technologies Used

- **Java** — Application logic and object-oriented programming
- **Java Collections Framework** — `ArrayList` for inventory management
- **Java Scanner** — Console input handling
- **Exception Handling** — `try/catch` and `InputMismatchException`
- **Object-Oriented Programming** — Classes, constructors, encapsulation, and methods
- **Command Line** — Application compilation and execution

No external libraries are required.

## Application Menu

When launched, the program displays the following menu:

```text
====================================
|        Raven Hall Library        |
|      Collection Management       |
====================================
| [1] Add Book                     |
| [2] Borrow Book                  |
| [3] Return Book                  |
| [4] Search by Title              |
| [5] Print All Books              |
| [6] Exit                         |
====================================
Choose an option:
```

The menu continues to appear after each operation until the user selects option 6.

## Application Functionality

### 1. Add Book

Users can add a new book to the library by entering:

- Book ID
- Title
- Author
- ISBN
- Number of pages

The application creates a new `Book` object and adds it to the available inventory.

Example:

```text
Choose an option: 1
Enter book ID: 101
Enter title: The Hobbit
Enter author: J.R.R. Tolkien
Enter ISBN: 9780547928227
Enter number of pages: 300

Book added to the library.
```

Book information is stored in memory while the application is running.

### 2. Borrow Book

Users can borrow an available book by entering its ID.

When a matching book is found, the inventory system removes it from the available collection and adds it to the borrowed collection.

Example:

```text
Choose an option: 2
Enter book ID to borrow: 101

Book successfully borrowed.
```

If the book is unavailable or the ID cannot be found, the application displays:

```text
Book not found or already borrowed.
```

### 3. Return Book

Users can return a previously borrowed book by entering its ID.

The system searches the borrowed collection and moves the matching book back to the available inventory.

Example:

```text
Choose an option: 3
Enter book ID to return: 101

Book successfully returned.
```

If the book is not in the borrowed collection, the application displays an appropriate message.

### 4. Search by Title

Users can search the available inventory using a full or partial book title.

The search is case-insensitive.

For example, searching for `hobbit` will match an available book titled `The Hobbit`.

```text
Choose an option: 4
Enter full or partial title: hobbit
────────────────────────────
ID: 101
Title: The Hobbit
Author: J.R.R. Tolkien
ISBN: 9780547928227
Pages: 300
────────────────────────────
```

The search uses Java's `toLowerCase()` and `contains()` methods.

Only books currently in the available inventory are included in search results.

### 5. Print All Books

Users can display all books currently available in the library.

Each book is displayed with its ID, title, author, ISBN, and page count.

Example:

```text
Choose an option: 5
────────────────────────────
ID: 101
Title: The Hobbit
Author: J.R.R. Tolkien
ISBN: 9780547928227
Pages: 300
────────────────────────────
```

If the available inventory is empty, the program displays:

```text
No books in inventory.
```

Borrowed books are not included in the available inventory listing.

### 6. Exit

Selecting option 6 ends the menu loop and closes the application.

```text
Choose an option: 6

Exiting program. Goodbye!
```

## Object-Oriented Programming Concepts

### Encapsulation

The `Book` class stores its attributes in private instance variables.

```java
private int id;
private String title;
private String author;
private String isbn;
private int numberOfPages;
```

Public getter and setter methods provide access to these attributes.

This demonstrates encapsulation by keeping the object's data within the class and providing methods to access or modify it.

### Constructors

The `Book` class provides both a default constructor and a parameterized constructor.

The parameterized constructor initializes a book's information when the object is created.

```java
Book newBook = new Book(id, title, author, isbn, pages);
```

This allows the application to create book objects using information entered by the user.

### ArrayList Collections

The `Inventory` class maintains two collections:

```java
private ArrayList<Book> mainInventory;
private ArrayList<Book> borrowedBooks;
```

The collections represent:

- `mainInventory` — Books currently available in the library.
- `borrowedBooks` — Books currently checked out.

The application uses `add()`, `remove()`, `isEmpty()`, and `size()` to manage these collections.

### Separation of Responsibilities

The project divides functionality between three classes.

The `Book` class stores individual book information.

The `Inventory` class manages the collections and performs inventory operations.

The `LibrarySystem` class handles user interaction and calls the appropriate inventory methods.

This demonstrates how a Java application can be organized into separate classes with different responsibilities.

### Methods and Return Values

The inventory system uses boolean return values to communicate whether borrowing or returning a book was successful.

For example:

```java
if (inventory.borrowBook(id))
{
    System.out.println("\nBook successfully borrowed.");
}
else
{
    System.out.println("\nBook not found or already borrowed.");
}
```

This separates the inventory operation from the message displayed to the user.

## Input Validation and Exception Handling

The application uses Java's `InputMismatchException` to handle invalid numerical input.

For example, entering text instead of a number when selecting a menu option produces an error message rather than immediately terminating the application.

```java
catch (InputMismatchException e)
{
    System.err.println("\nInvalid input. Please enter a number.");
    input.nextLine();
}
```

The `input.nextLine()` statement clears the invalid input so the application can continue.

Similar exception handling is used when entering book IDs and page counts.

The application also checks whether a menu selection falls within the supported range of 1 through 6.

This demonstrates introductory input validation and exception handling in a console application.

## Project Structure

```text
java-library-management-system/
├── src/
│   ├── Book.java
│   ├── Inventory.java
│   └── LibrarySystem.java
├── Screenshots/
│   └── Development and testing screenshots
├── .gitignore
├── LICENSE
└── README.md
```

### Source Files

| File | Purpose |
|------|---------|
| `Book.java` | Defines book attributes, constructors, getters, setters, and display formatting |
| `Inventory.java` | Manages available and borrowed books, title searches, and inventory display |
| `LibrarySystem.java` | Contains the main menu, user input, and application workflow |

## How to Run

### Requirements

- Java Development Kit (JDK)
- Terminal or command prompt

### Instructions

1. Clone or download the repository.

2. Open a terminal in the repository's root directory.

3. Compile the Java source files:

   ```bash
   javac src/*.java
   ```

4. Run the application:

   ```bash
   java -cp src LibrarySystem
   ```

5. Follow the menu prompts to interact with the library.

6. Select option 6 to exit.

No external dependencies or additional setup are required.

## Example Workflow

The following example demonstrates a typical sequence of operations:

1. Launch the application.
2. Select **Add Book** and enter the book's information.
3. Select **Print All Books** to confirm the book appears in the available inventory.
4. Select **Search by Title** to locate the book using part of its title.
5. Select **Borrow Book** and enter its ID.
6. Select **Print All Books** to confirm the borrowed book is no longer available.
7. Select **Return Book** and enter the same ID.
8. Select **Print All Books** to confirm the book has returned to the available inventory.
9. Select **Exit** to close the application.

This workflow demonstrates how book objects move between the available and borrowed collections.

## Development and Testing Screenshots

The `Screenshots/` directory contains 20 images documenting the original coursework.

These include:

- Java source code for all three classes
- Initial application execution
- Adding books to inventory
- Borrowing books
- Returning borrowed books
- Searching by full and partial titles
- Displaying available inventory
- Testing an empty inventory
- Testing invalid menu selections
- Testing exception handling with non-numerical input
- Original GitHub repository documentation

[View the Screenshots Directory](Screenshots/)

The screenshots preserve the original development and testing process.

## Current Limitations

This project was developed as an introductory object-oriented programming assignment.

Its current limitations include:

- Book data is stored in memory and is lost when the application closes.
- The system does not use a database or external file for persistent storage.
- Book IDs are not checked for duplicates.
- Book titles, authors, and ISBNs are not validated for empty values.
- Page counts are not checked for negative or zero values.
- The application does not maintain borrower names or due dates.
- Borrowed books cannot be listed through a dedicated menu option.
- Searches include only books currently available in inventory.
- The application uses a console interface rather than a graphical interface.

These limitations reflect the educational scope of the original assignment rather than a production-ready library management system.

## Educational Context

This application was developed for a Programming II course at Colorado State University Global.

The project provided practical experience with:

- Creating and organizing Java classes
- Applying encapsulation with private fields
- Using constructors, getters, and setters
- Creating and managing objects
- Working with `ArrayList` collections
- Implementing menu-driven applications
- Processing keyboard input with `Scanner`
- Using loops and conditional statements
- Implementing methods with return values
- Handling invalid input using exceptions
- Performing case-insensitive string searches
- Managing objects across multiple collections
- Testing application behavior and edge cases

The original coursework implementation has been preserved to demonstrate progression in Java programming and object-oriented application design.

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.
