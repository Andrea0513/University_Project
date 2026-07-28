# 📚 Digital & Paper Library Management System (Biblioteca)

Hi everyone! 👋 Welcome to my Java OOP project called **Library Management System**. 

I created this software to simulate how a modern library manages different kinds of books[cite: 61, 64, 65]. The coolest part about this project is that it can handle both physical paper books (`LibroCartaceo`) and modern audiobooks (`AudioLibro`), allowing users to "consume" or read them in completely different ways[cite: 61, 64, 68]!

The whole application is built using fundamental Object-Oriented Programming (OOP) concepts like abstract classes, interfaces, polymorphism, and sorting algorithms[cite: 61, 64, 66, 67, 68].

---

## 💡 What is this project about?

Basically, the library manages a general collection of books (`Libro`)[cite: 65, 68]. Every book has a title, a main author (*primoAutore*), and the actual text content inside it[cite: 68]. 

Because a library has different media types, I divided the general book class into two specific subclasses[cite: 61, 64]:
* **Paper Books (`LibroCartaceo`)**: Traditional books that have a specific page count (*numPagine*) and a target filename[cite: 61]. When a user wants to "consume" or read a paper book, the system automatically exports and prints the whole text content directly into an external text file (like `Manzoni.txt` or `Tolkien.txt`)[cite: 61, 62, 63]!
* **Audiobooks (`AudioLibro`)**: Digital books that have a narrator voice (*voceNarrante*) and a duration in minutes[cite: 64]. When a user "consumes" an audiobook, the software simulates audio playback by printing the narrator's intro and reading the text out loud on the console[cite: 64]!

---

## 🛠️ How the Code is Structured

To keep the project modular and clean, I organized the code into 7 specialized files[cite: 61, 64, 65, 66, 67, 68]:

* **`Comparable<T>`**: A custom interface requiring classes to implement a `compareTo()` method for alphabetical sorting[cite: 66].
* **`Fruibile`**: An interface defining a single contract method: `consuma()` (which means *to consume* or *to use*)[cite: 67].
* **`Libro`**: The abstract superclass implementing both `Comparable` and `Fruibile`[cite: 68]. It stores the common information (title, author, content) and implements alphabetical sorting by title[cite: 68].
* **`LibroCartaceo` & `AudioLibro`**: Subclasses extending `Libro`[cite: 61, 64]. They override the `consuma()` method to perform domain-specific actions (file writing vs. console playback)[cite: 61, 64].
* **`ElencoLibri`**: The core controller class managing a `LinkedList` of books[cite: 65]. It can add new books, search for titles, sort the collection alphabetically from A to Z using Bubble Sort, and trigger polymorphic consumption for all items!
* **`Biblioteca`**: The main execution class with the `main` method where we test the whole system by creating famous books like *The Lord of the Rings* and *The Betrothed* (*I Promessi Sposi*), sorting them, and generating their files[cite: 62, 63, 65]!

---

## 🌟 Key Features

1. **Polymorphic Media Consumption**: As you can see in the `fruisciLibri()` method, the system loops through a single mixed list of paper books and audiobooks[cite: 65]. When it calls `consuma()`, Java automatically executes the correct behavior at runtime (writing to disk or printing to screen)[cite: 61, 64]!
2. **Automatic File Exporting**: Using `PrintWriter`, the paper book class automatically creates formatted text files in the project directory, saving the book title, author, and full content[cite: 61].
3. **Alphabetical Sorting**: The collection can sort itself alphabetically by title using a custom Bubble Sort algorithm that relies on `compareToIgnoreCase()`[cite: 68].
4. **Targeted Book Search**: You can search the catalog for a specific title, and the software will instantly display the book's format, author, and details[cite: 65]!
