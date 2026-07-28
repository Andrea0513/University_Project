# 🤖 Autonomous Service Robot & Module Fleet Manager (Gestione Robot)

Hi everyone! 👋 Welcome to my Java OOP project called **Autonomous Service Robot & Module Fleet Manager**[cite: 87]! 

I created this software to simulate how a robotic command center monitors a fleet of modular autonomous robots[cite: 85, 87]. The coolest part about this project is that every robot is made of different swappable hardware components (`Modulo`), like sensors, cameras, motors, and batteries[cite: 84, 87]! 

The whole architecture is built using fundamental Object-Oriented Programming (OOP) concepts like abstract classes, inheritance, polymorphism, custom checked exceptions, and dynamic array shifting[cite: 84, 85, 86, 88, 89]!

---

## 💡 What is this project about?

Basically, the software manages a general robotic unit (`Robot`) equipped with an internal array of up to 5 hardware modules (`Modulo[]`)[cite: 85]. Every module has an identification type (*tipo*), an operational status flag (*isOperative*), and an emergency alarm indicator (*alert*)[cite: 84].

Because a smart facility needs different robots for different tasks, I divided the general robot class into two specialized subclasses[cite: 88, 89]:
* **Maintenance & Monitoring Robots (`MM`)**: Specialized robots designed to check the environment[cite: 89]. When their security scan (`monitora()`) detects any module in an alert state, the system immediately throws an `AlarmException` to warn the operators[cite: 89]! Furthermore, when a maintenance robot fixes a malfunction (`ripristina()`), it simply repairs and reactivates the damaged modules without removing them[cite: 89]!
* **Entertainment & Interaction Robots (`MI`)**: Specialized social robots that interact with humans (`intrattieni()`), which requires an energy level (*livelloEnergia*) of at least 10 units[cite: 88]! Unlike maintenance robots, if an entertainment robot suffers a hardware failure, its recovery protocol (`ripristina()`) physically ejects and deletes the damaged modules from its internal array to prevent safety hazards around humans[cite: 88]!

---

## 🛠️ How the Code is Structured

To keep the project clean, modular, and well-organized, I divided the logic into 6 specialized files[cite: 84, 85, 86, 87, 88, 89]:

* **`Modulo`**: Represents a single hardware component (like a sensor or battery)[cite: 84, 87]. It encapsulates the module type, operational status, and alarm toggle methods[cite: 84].
* **`AlarmException`**: A custom checked exception extending `Exception`, thrown whenever a maintenance robot scans its components and detects an active hardware alarm[cite: 86, 89]!
* **`Robot`**: The superclass representing a generic robot[cite: 85]. It manages a fixed-size array of modules (`Modulo[5]`), handles safe module insertion, tracks the active module count using an index pointer (`indxmod`), and performs array shifting when modules are removed[cite: 85]!
* **`MM` & `MI`**: Subclasses extending `Robot`[cite: 88, 89]. They override the `ripristina()` method to execute completely different repair behaviors (reactivating vs. deleting damaged components)[cite: 88, 89]. `MM` also implements alarm monitoring, while `MI` implements energy-checked human entertainment[cite: 88, 89].
* **`GestioneRobot`**: The main execution class containing the `main` method where we test the whole fleet[cite: 87]! We create an `MM` robot and an `MI` robot, equip them with sensors and cameras, simulate multiple hardware failures, trigger polymorphic recovery protocols, and test alarm exceptions[cite: 87]!

---

## 🌟 Key Features

1. **Polymorphic Failure Recovery**: This is one of the best examples of polymorphism in my project! When the command center calls `ripristina()` on the robot fleet array (`flotta`), Java automatically executes the correct recovery behavior at runtime[cite: 87]: Robot `MM` repairs its broken sensors by turning them back on, while Robot `MI` physically ejects its broken camera from the array!
2. **Safe Array Shifting & Deletion**: In the `eliminaModulo()` method, when a module is removed, the robot shifts all subsequent array elements one position to the left (`moduli[j] = moduli[j + 1]`) and explicitly nullifies the trailing reference[cite: 85]. When called inside a loop during recovery, the index is safely decremented to ensure no components are skipped during the diagnostic scan[cite: 85, 88]!
3. **Automated Index Tracking**: Instead of manually searching for empty `null` cells every time we add a module, the robot automatically increments its internal pointer (`indxmod`) during insertion, preventing array overflow errors[cite: 85].
4. **Defensive Alarm Screening**: By using the custom `AlarmException`, the monitoring method safely interrupts robot operations whenever a hardware sensor reports a critical alert, preventing damaged robots from operating autonomously[cite: 86, 89]!
