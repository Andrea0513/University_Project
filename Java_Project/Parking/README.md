# 🅿️ Smart Parking Lot & Vehicle Grid Manager (Gestione Parcheggio)

Hi everyone! 👋 Welcome to my Java OOP project called **Smart Parking Lot & Vehicle Grid Manager** [source: 102]! 

I developed this application to simulate how an automated parking facility manages vehicle arrivals, checks parking space availability on a physical 2D grid, and calculates hourly parking fees [source: 97, 99, 100, 101]. The coolest part about this project is that different vehicles occupy different physical sizes on the grid: a motorcycle takes just one spot, while a car takes up two consecutive spots (either horizontally or vertically) [source: 100]!

The whole software architecture is built using fundamental Object-Oriented Programming (OOP) concepts like abstract classes, inheritance, polymorphism, custom checked exceptions, and 2D matrix manipulation [source: 97, 98, 99, 100, 101]!

---

## 💡 What is this project about?

Basically, the software manages a general vehicle (`Veicolo`) entering a parking area (`AreaParcheggio`) [source: 99, 100]. Every vehicle has a license plate (*targa*) and target grid coordinates (*riga*, *colonna*) where the driver wants to park [source: 99].

Because a parking lot receives different types of vehicles, I divided the general class into two specific subclasses [source: 97, 101]:
* **Motorcycles (`Moto`)**: Compact two-wheeled vehicles categorized as either mopeds (*CICLOMOTORE*) or standard motorcycles (*MOTOCICLETTA*) [source: 97]. They occupy exactly **1 cell** on the parking grid [source: 100]. Their hourly tariff is 2.0 euros for mopeds and 3.0 euros for motorcycles [source: 97].
* **Cars (`Auto`)**: Larger four-wheeled vehicles categorized by size: *PICCOLA* (Small), *MEDIA* (Medium), or *GRANDE* (Large) [source: 101]. Because of their length, cars occupy exactly **2 consecutive cells** on the grid [source: 100]! When registering a car, you must specify its orientation (*orientamento*): if it's *ORIZZONTALE*, it takes cell `(riga, colonna)` and cell `(riga, colonna + 1)`; if it's *VERTICALE*, it takes cell `(riga, colonna)` and cell `(riga + 1, colonna)` [source: 100]! Their tariffs range from 4.0 up to 5.0 euros per hour [source: 101].

---

## 🛠️ How the Code is Structured

To keep the project clean, modular, and well-organized, I divided the logic into 6 specialized files [source: 97, 98, 99, 100, 101, 102]:

* **`PostoNonValidoException`**: A custom checked exception extending `Exception`, thrown whenever a vehicle tries to park outside the grid boundaries or in a spot that is already taken by another vehicle [source: 98, 100]!
* **`Veicolo`**: The abstract superclass storing common attributes (license plate, row, column) and declaring abstract methods for grid symbols (`getSymbol()`) and hourly tariffs (`getTariffaOraria()`) [source: 99].
* **`Moto` & `Auto`**: Subclasses extending `Veicolo` [source: 97, 101]. They override the tariff math and return their specific grid symbols: `'M'` for motorcycles and `'A'` for cars [source: 97, 101].
* **`AreaParcheggio`**: The core controller class representing our physical parking lot [source: 100]. It manages a **2D matrix (`Veicolo[5][7]`)** representing a 35-slot grid and a 1D waiting list array (`Veicolo[35]`) [source: 100]. It performs collision checks, places vehicles on the matrix, calculates occupancy percentages, and prints the visual parking map [source: 100]!
* **`GestioneParcheggio`**: The main execution class containing the `main` method where we test the whole system by creating mopeds and cars, triggering out-of-bounds exceptions, testing collision rejections, and printing the final parking bills [source: 102]!

---

## 🌟 Key Features

1. **Dual-Cell Grid Validation**: This is one of the most technical parts of the project! When the `occupaCella()` method places an `Auto`, it doesn't just check the starting coordinate [source: 100]. It uses polymorphic logic to determine the car's orientation and calls `verificaCellaLibera()` on **both required cells** before placing the vehicle [source: 100]. If the second cell is out of bounds or already occupied, the entire car is rejected safely without corrupting the grid [source: 100]!
2. **Defensive Collision Screening**: Before assigning any spot on the `5x7` matrix, the system checks if the target row and column are within bounds (`0 <= riga < 5` and `0 <= colonna < 7`) and verifies that the matrix cell is completely empty (`== null`) [source: 100]. If a collision is detected, a `PostoNonValidoException` is thrown immediately [source: 98, 100]!
3. **Automatic Waiting List Cleanup**: If a vehicle fails to park because its spot is taken or out of bounds, the exception catch block automatically removes that vehicle from the waiting list array (`areaparc`) [source: 100]. This prevents the system from charging parking fees to drivers who couldn't actually enter the lot [source: 100]!
4. **Visual Matrix Mapping**: The `stampaArea()` method loops through the 2D matrix using nested `for` loops to print a visual map of the parking lot on the console, showing `'M'` for bikes, `'A'` for cars, and dots `'.'` for empty spaces [source: 100]!
