# 🗃️ Lost & Found Archive Management System (Gestione Archivio)

Hi everyone! 👋 Welcome to my Java OOP project called **Lost & Found Archive Management System** [source: 94]! 

I developed this application to simulate how a school or city lost-and-found office manages missing items [source: 90, 95, 96]. The coolest part about this project is that instead of using basic Java collections like `ArrayList`, I built a **custom singly-linked list** from scratch to store and manage all the records [source: 92]! 

The whole software architecture is built using fundamental Object-Oriented Programming (OOP) concepts like abstract classes, interfaces, inheritance, polymorphism, custom checked exceptions, and dynamic node pointers [source: 90, 91, 92, 93, 95, 96]!

---

## 💡 What is this project about?

Basically, the software manages an archive (`Archivio`) of general lost items (`Oggetti`) [source: 92, 95]. Every item has a description (*descrizione*), a finding location (*luogoDiRitrovo*), and a unique numerical identification code (*codiceIdentificativo*) [source: 95].

Because a lost-and-found office receives completely different kinds of items, I divided the general class into two specific subclasses [source: 90, 96]:
* **Personal Items (`OggettiPersonali`)**: Standard everyday belongings (like sunglasses or wallets) that include a specific category tag (*categoria*) [source: 94, 96]. When the system generates their custom tracking code (`restituisciCodiceTracciamento()`), it automatically attaches a `"PERS-"` prefix before their ID number [source: 96]!
* **School Items (`OggettiScolastici`)**: Educational items (like math textbooks) that include a school level tag (*livelloScolastico*), such as elementary, middle school, or high school (*liceo*) [source: 90, 94]. Their custom tracking codes automatically receive a `"SCOL-"` prefix [source: 90]!

---

## 🛠️ How the Code is Structured

To keep the project clean, modular, and well-organized, I divided the logic into 7 specialized files [source: 90, 91, 92, 93, 94, 95, 96]:

* **`Comparable<T>`**: A custom interface requiring classes to implement a `compareTo()` method for numerical ID comparisons [source: 93].
* **`Oggetti`**: The abstract superclass implementing `Comparable` [source: 93, 95]. It stores common variables (description, finding location, ID code) and declares the abstract tracking code method [source: 95].
* **`OggettiPersonali` & `OggettiScolastici`**: Subclasses extending `Oggetti` [source: 90, 96]. They override `toString()` and the tracking method to append their specific prefixes and tags [source: 90, 96].
* **`OggettoDuplicatoException`**: A custom checked exception extending `Exception`, used to alert the system whenever someone tries to register an item that already exists in the archive [source: 91, 92]!
* **`Archivio`**: The core controller class representing our **custom linked list** [source: 92]! It uses an internal `Nodo` class to link items together (`testa` pointer), pushes new items to the head of the list, extracts items by ID (`pop`), and screens for duplicate records [source: 92]!
* **`GestioneArchivio`**: The main execution class containing the `main` method where we test the whole system by inserting personal and school items, triggering duplicate exceptions, searching by location, and returning items to their owners [source: 94]!

---

## 🌟 Key Features

1. **Custom Linked-List Architecture**: As you can see in the `Archivio` class, the items are stored inside dynamically allocated nodes (`Nodo`) [source: 92]. The `push()` method inserts new elements directly at the head of the list (`testa = q`), allowing constant-time insertions without wasting memory on empty array slots [source: 92]!
2. **Defensive Duplicate Screening**: Before inserting any new item, the `push()` method traverses the linked list to check if another object has the exact same description and ID number [source: 92]. If a duplicate is detected, it throws an `OggettoDuplicatoException`, preventing corrupted data [source: 91, 92, 94]!
3. **Safe Node Deletion (`pop`)**: When an owner comes to claim their lost item, the `pop()` method traverses the list to find the matching ID code [source: 92]. It safely unlinks the node by updating the pointers (`temp.next = temp.next.next`) and returns the object without breaking the rest of the chain [source: 92]!
4. **Targeted Location Filtering**: The `stampaPerLuogo()` method allows users to search the archive by location (like `"stazione"` or `"biblioteca"`) [source: 92, 94]. It loops through the entire linked list and prints out the details and tracking codes for all matching items found in that area [source: 92]!

