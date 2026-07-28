# 🚌⛴️ Bus & Ferry Travel Booking Network (Gestione Viaggi)

Hi everyone! 👋 Welcome to my Java OOP project called **Bus & Ferry Travel Booking Network**! 

I created this application to simulate how a national transport station manages different passenger trips across Italy and Europe[cite: 118, 120, 121]. The coolest part about this project is that instead of using basic Java collections like `ArrayList`, I built a **custom singly-linked list** from scratch to store all the trips and filter them by target destination[cite: 122]!

The whole software architecture is built using fundamental Object-Oriented Programming (OOP) concepts like abstract classes, interfaces, inheritance, composition, polymorphism, custom checked exceptions, and text file parsing[cite: 118, 119, 120, 122, 125, 126, 127]!

---

## 💡 What is this project about?

Basically, the software manages a catalog of general travel departures (`Viaggio`)[cite: 119, 122]. Every trip holds an identification number (*idViaggio*), an origin city, a target destination, and an assigned transport vehicle (`Mezzo`)[cite: 119].

Because a national transport network utilizes completely different transport methods, I divided the general vehicle class into two specific subclasses[cite: 118, 120, 125]:
* **Coaches & Buses (`Autobus`)**: Standard road transport vehicles[cite: 118, 120]. They keep track of their maximum seating capacity (*nPosti*) and their currently available passenger seats (*nPostiDisponibili*)[cite: 120]. Whenever someone books a bus trip, the system automatically decreases the available seat counter by 1[cite: 120]!
* **Passenger Ferries (`Traghetto`)**: Large maritime vessels[cite: 118, 121]. Unlike buses, ferries have two different inventory counters: available passenger cabins (*nCabineDisponibili*) and available garage parking spots for passenger cars (*nPostiAutoDisponibili*)[cite: 118]! When a booking occurs, the system decreases both cabin and vehicle availability[cite: 118]!

---

## 🛠️ How the Code is Structured

To keep the project clean, modular, and well-organized, I divided the logic into specialized files[cite: 118, 119, 120, 121, 122, 123, 124, 125, 126, 127]:

* **`Searchable<T>`**: An interface requiring classes to implement a generic `matches()` method for filtering purposes[cite: 127].
* **`MatchPerString` & `MatchPerInteger`**: Concrete helper classes implementing `Searchable` to allow safe, case-insensitive string matching and exact integer ID comparisons[cite: 123, 124].
* **`PostiEsauritiException`**: A custom checked exception extending `Exception`, thrown whenever a passenger tries to book a trip on a bus or ferry that is completely sold out[cite: 118, 120, 126]!
* **`Mezzo`**: The abstract superclass storing the transport ID and declaring abstract methods for capacity and booking actions[cite: 125].
* **`Autobus` & `Traghetto`**: Subclasses extending `Mezzo`[cite: 118, 120]. They override the `prenota()` method to decrease their specific seat or cabin availability counters[cite: 118, 120].
* **`Viaggio`**: The domain class representing a specific scheduled route[cite: 119]. It encapsulates the origin, destination, and the assigned vehicle object[cite: 119].
* **`ListaViaggi`**: The core controller class representing our **custom linked list**[cite: 122]! It uses an internal `Nodo` class to link trips together (`testa` pointer), appends new trips to the end of the line, searches by ID, filters by destination city, and triggers polymorphic booking commands[cite: 122]!
* **`GestioneViaggi`**: The main execution class containing the `main` method where we test the whole network[cite: 121]! We open and read an external text file (`viaggi.txt`), parse bus and ferry specifications, load them into the linked list, simulate several bookings, and display the updated availability[cite: 121]!

---

## 🌟 Key Features

1. **Custom Linked-List Architecture**: As you can see in the `ListaViaggi` class, trips are stored inside dynamically allocated nodes (`Nodo`)[cite: 122]. The `append()` method traverses the list pointers (`while(temp.next != null)`) to attach new trips directly to the end of the chain, allowing flexible inventory growth without array bounds limits[cite: 122]!
2. **Automated File Ingestion**: Instead of hardcoding departures inside the code, the system uses a `Scanner` to read data directly from an external text file (`viaggi.txt`)[cite: 121]. It parses token strings like `"AUTOBUS"` or `"TRAGHETTO"`, reads the different numerical parameters, and instantiates the correct subclass dynamically[cite: 121]!
3. **Polymorphic Booking & Exception Screening**: When the `prenota()` method triggers a reservation on a trip, it simply calls `prenotaViaggio()`[cite: 119, 122]. Java automatically executes the correct behavior at runtime depending on the vehicle subclass[cite: 118, 119, 120]! If the vehicle is full (like bus ID 110 which starts with 0 seats), the method catches the `PostiEsauritiException` and alerts the user without crashing the network simulation[cite: 118, 120, 122]!
4. **Targeted City Filtering**: The `filtra()` method allows users to search the linked list for trips arriving at a specific city (like `"Napoli"`)[cite: 121, 122]. It loops through the entire node chain using case-insensitive comparison and prints out all available departures leading to that destination[cite: 122]!
