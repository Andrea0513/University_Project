# 📦 Warehouse & Shipment Management System (Gestione Spedizione)

Hi everyone! 👋 Welcome to my Java project called **Warehouse & Shipment Management System**[cite: 48]. 

I developed this application to simulate how a logistics center manages storage boxes, calculates shipping tariffs, and organizes inventory based on physical volume and identification codes[cite: 47, 48, 50]. The whole system is built using Object-Oriented Programming (OOP) concepts like class inheritance, interfaces, polymorphism, and Java Generics[cite: 44, 45, 47, 50, 51, 53]!

---

## 💡 What is this project about?

Basically, the software helps a warehouse manager control boxes before they are shipped out. When items arrive at the warehouse, they are placed inside a generic `Box`[cite: 48, 50]. Every box has three physical dimensions (width, height, depth) used to calculate its total physical volume[cite: 50].

The system manages two different kinds of goods inside the boxes[cite: 48, 53]:
* **Normal Items (`ColloNormale`)**: Standard goods (like books) where the shipping cost is simply calculated by multiplying the unit price by the item quantity[cite: 48, 52].
* **Special Items (`ColloSpeciale`)**: Delicate or hazardous goods (like fragile glass vases or flammable chemicals)[cite: 48, 53]. These items require an extra insurance cost[cite: 53]. Furthermore, if an item is labeled as *"fragile"*, the system automatically adds a fixed surcharge of 30 euros to the final price to cover extra packaging[cite: 53]!

---

## 🛠️ How the Code is Structured

To keep the project clean and modular, I organized the classes and interfaces into logical components[cite: 44, 45, 46, 47, 50, 51, 52, 53]:

* **`CalcolaTariffa`**: An interface that forces item classes to implement a method to calculate their shipping price (`calcolaTariffa`)[cite: 51].
* **`Comparable<T>` & `Comparator<T>`**: Custom interfaces that define natural sorting (by Box ID) and external sorting (by Box Volume)[cite: 44, 45, 46, 50].
* **`ColloNormale` & `ColloSpeciale`**: The domain model classes representing the items inside the boxes[cite: 52, 53]. `ColloSpeciale` extends `ColloNormale` and overrides the tariff formula to include insurance and fragility bonuses[cite: 53].
* **`Box<T extends ColloNormale>`**: A generic container class that holds an item, stores the box dimensions, calculates the physical volume, and computes the total box cost[cite: 50].
* **`Cpv`**: A custom comparator class that compares two boxes by looking at their physical volume using `Double.compare()`[cite: 46].
* **`DepositoBox<T extends Box<?>>`**: The core controller class representing the warehouse storage[cite: 47]. It manages a `LinkedList` of boxes, checks volume capacities before admitting new boxes, executes sorting algorithms (Bubble Sort), and exports data to text files[cite: 47].
* **`GestioneSpedizione`**: The main execution class where we test the system by creating different items and boxes, adding them to the warehouse, and generating output reports[cite: 48].

---

## 🌟 Key Features

1. **Volume Capacity Checking**: The warehouse has a maximum capacity ceiling (set to 15,000 volume units in our test)[cite: 48]. Before adding a box, the `add()` method checks if there is enough space left[cite: 47]. If a box is too huge (like our test box `BX004`), the system rejects it automatically!
2. **Dynamic Tariff Calculation**: As you can see in the code, the total shipping cost is calculated dynamically at runtime depending on whether the item is normal or special, plus a base calculation depending on the box volume[cite: 50, 52, 53].
3. **Dual Sorting Algorithms**: The warehouse can sort its inventory in two different ways using Bubble Sort:
   * By **ID Code** in ascending order (e.g., BX001, BX002, BX003)[cite: 47, 50].
   * By **Physical Volume** from the smallest box to the largest box using the `Cpv` comparator[cite: 46, 47].
4. **File Exporting**: The system can automatically sort the inventory by volume and export the complete list directly into an external text file called `output.txt`.
