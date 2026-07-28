# 🏭 Industrial Machinery & Energy Consumption Manager (Gestione Macchinari)

Hi everyone! 👋 Welcome to my Java project called **Industrial Machinery & Energy Consumption Manager**[cite: 72]! 

I created this software to simulate how a smart factory or an industrial plant monitors different production machines and calculates their electrical power consumption[cite: 70, 71, 74, 75, 76]. The whole application is built using fundamental Object-Oriented Programming (OOP) concepts like abstract classes, custom interfaces, inheritance, polymorphism, and dynamic array resizing[cite: 70, 71, 74, 75, 76]!

---

## 💡 What is this project about?

Basically, the software manages a catalog of general factory machines (`Macchinario`)[cite: 71, 74]. Every machine has an identification name, an operating time (*tempoUtilizzo*) expressed in minutes, a base electrical power (*potenza*), and an operating mode multiplier (*mode*, which is automatically set to 4 by default)[cite: 74].

Because an industrial plant utilizes different robotic systems, I divided the general machine class into two specific subclasses[cite: 75, 76]:
* **Mechanical Presses (`Pressa`)**: Heavy machinery characterized by their mechanical speed, measured in strikes per minute (*colpiAlMinuto*)[cite: 75]. To calculate their energy consumption, the software divides their operating time by 60 to obtain the hours, multiplies it by their base power, and applies the mode multiplier[cite: 75].
* **Robotic Arms (`Robot`)**: Advanced automation units that can be equipped with an optional Artificial Intelligence vision system (*visioneArtificiale*)[cite: 76]. If a robot uses artificial vision, its energy consumption factor increases significantly by 30% due to the extra processing power required by the optical sensors[cite: 76]!

---

## 🛠️ How the Code is Structured

To keep the project modular and clean, I organized the code into 7 specialized files[cite: 70, 71, 72, 73, 74, 75, 76]:

* **`Configurabile`**: An interface that defines a single behavioral contract: `consumi()` (which calculates and returns the electrical consumption in kWh)[cite: 70].
* **`Macchinario`**: The abstract superclass implementing the `Configurabile` interface[cite: 74]. It stores common variables like name, time, power, and operational mode[cite: 74].
* **`Pressa` & `Robot`**: Subclasses extending `Macchinario`[cite: 75, 76]. They override the `consumi()` method to apply their specific mathematical formulas[cite: 75, 76].
* **`ElencoMacchinari`**: The core controller class managing a dynamically resized array of machines (`Macchinario[]`)[cite: 71]. It reads data directly from an external text file, monitors remaining capacity, doubles the array memory when needed, calculates the total factory power consumption, and filters machines above a critical threshold[cite: 71]!
* **`GestioneMacchinari`**: The main execution class containing the `main` method where we test the whole system by loading the file, printing the inventory, and asking the user to input a consumption threshold via keyboard[cite: 72]!
* **`Macchinari.txt`**: The input text file acting as our database, storing the initial array capacity and the individual specifications for presses and robots[cite: 73].

---

## 🌟 Key Features

1. **Dynamic Array Resizing**: As you can see in the `ElencoMacchinari` class, the inventory starts with a fixed array capacity read from the text file[cite: 71, 73]. However, whenever the remaining empty space drops below a safety margin (`RESIZE = 2`), the `add()` method automatically allocates a new array with double the capacity and copies all existing pointers safely without losing data[cite: 71]!
2. **Polymorphic Consumption Calculations**: When the system loops through the inventory array to calculate the total power consumption, it simply calls `consumi()` on each item[cite: 71]. Java automatically executes the correct mathematical formula at runtime depending on whether the object is a Press or a Robot[cite: 71, 75, 76]!
3. **Locale-Safe Parsing**: By using `Locale.US`, both the file scanner and the keyboard input scanner correctly interpret decimal numbers separated by dots (like `10.0` or `7.8`), preventing runtime crashes across different operating systems[cite: 71, 72, 73].
4. **Energy Threshold Filtering**: The user can input a custom energy threshold from the keyboard, and the software will immediately scan the array to print out only the machines that exceed that power limit, helping plant managers identify energy-hungry equipment[cite: 71, 72]!
