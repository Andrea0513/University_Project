# 🍽️ Restaurant Table Booking & Linked List Manager (Gestione Tavoli)

Hi everyone! 👋 Welcome to my Java OOP project called **Restaurant Table Booking & Linked List Manager**[cite: 138]! 

I created this software to simulate how a restaurant host manages table bookings, checks table capacities, and frees up tables when customers leave[cite: 136, 140, 141]. The coolest part about this project is that instead of using standard Java collections like `ArrayList`, I built a **custom singly-linked list** from scratch to store and manage the restaurant's floor plan[cite: 141]!

The whole application is built using fundamental Object-Oriented Programming (OOP) concepts like abstract classes, interfaces, inheritance, composition, polymorphism, custom node pointers, and text file parsing[cite: 136, 137, 139, 140, 141]!

---

## 💡 What is this project about?

Basically, the software manages a general restaurant table (`Tavolo`)[cite: 136]. Every table holds important seating data: a table identification number (*numero*), a maximum seating capacity (*numPosti*), and a boolean flag indicating if the table is currently reserved (*prenotato*)[cite: 136].

Because a modern restaurant offers different dining atmospheres, I divided the general class into two specific subclasses[cite: 137, 139]:
* **Outdoor Tables (`Esterno`)**: Tables located outside the restaurant[cite: 137]. They include a boolean flag (*sottoPortico*) indicating whether the table is placed under a covered porch to protect customers from bad weather[cite: 137]! When you reserve an outdoor table, the system automatically runs a weather check simulation (`specificaPrenotazione()`)[cite: 137]!
* **Indoor Tables (`Interno`)**: Tables located inside the dining room[cite: 139]. They include a boolean flag (*nearWindow*) indicating if the table offers a window view[cite: 139]. When reserved, the system checks the table's position relative to the kitchen and the window[cite: 139]!

---

## 🛠️ How the Code is Structured

To keep the project clean, modular, and well-organized, I divided the logic into 6 specialized files[cite: 136, 137, 138, 139, 140, 141]:

* **`Reservable`**: An interface defining the core booking contract: `prenota()` (to book a table), `libera()` (to free a table), and `isPrenotato()` (to check its current status)[cite: 140].
* **`Tavolo`**: The abstract superclass implementing `Reservable`[cite: 136]. It stores the common table data, manages the reservation state, and declares the abstract `specificaPrenotazione()` method[cite: 136].
* **`Esterno` & `Interno`**: Subclasses extending `Tavolo`[cite: 137, 139]. They override the reservation details method to print specific outdoor weather checks or indoor location details[cite: 137, 139].
* **`Ristorante`**: The core controller class representing our **custom linked list**[cite: 141]! It uses an internal `Nodo` class with `testa` (head) and `coda` (tail) pointers to link tables together[cite: 141]. It loads tables from an external text file, searches for available tables by seat capacity, reserves them, and releases them when customers leave[cite: 141]!
* **`GestioneTavoli`**: The main execution class containing the `main` method where we test the whole system[cite: 138]! We instantiate the "Marinella" restaurant, load the floor plan from `Tavoli.txt`, display all tables, simulate several booking requests for different group sizes, and release a table[cite: 138]!

---

## 🌟 Key Features

1. **Custom Linked-List Architecture**: As you can see in the `Ristorante` class, tables are stored inside dynamically allocated nodes (`Nodo`)[cite: 141]. The `addTable()` method uses head and tail pointers (`testa` and `coda`) to append new tables directly in $O(1)$ constant time without wasting memory on empty array slots[cite: 141]!
2. **Automated Floor Plan Loading**: Instead of hardcoding tables inside the source code, the system uses a `Scanner` to read data directly from an external text file (`Tavoli.txt`)[cite: 141, 142]. It reads token strings like `"Esterno"` or `"Interno"`, parses the seat numbers and boolean flags, and instantiates the correct subclass dynamically[cite: 141]!
3. **Smart Seat Matching**: When the `reserveTable(num)` method is called, it traverses the linked list (`while(temp != null)`) searching for a table that exactly matches the requested number of seats[cite: 141]. If it finds a matching table that isn't already reserved, it books it instantly[cite: 141]! If all matching tables are taken, it alerts the host that no seats are available[cite: 141].
4. **Safe Node Searching & Releasing**: The `findTable(table)` method safely traverses the list looking for a specific table number[cite: 141]. By checking `temp != null` first, it avoids null pointer crashes if you search for a table ID that doesn't exist in the restaurant[cite: 141]!
