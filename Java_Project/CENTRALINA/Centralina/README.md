# Smart Home Automation & Device Management System (Domotica Centralina)

A robust Java application developed to simulate a centralized control unit (`Centralina`) for smart home automation. The software manages various electrical appliances, enforces device state constraints (ON/OFF/Disconnected), handles dynamic memory expansion, and utilizes Object-Oriented Programming (OOP) paradigms including polymorphism, inheritance, and custom checked exceptions.

---

## 📌 Project Overview

This project models an automated home environment (`Abitazione`) where a central controller manages different categories of smart devices (`Dispositivo`), such as **Lighting Systems** (`Illuminazione`) and **Air Conditioning Units** (`Condizionamento`)[cite: 26, 28, 31, 32]. 

The system provides core home automation functionalities:
* **Global Action Control**: Turning all connected devices ON or OFF simultaneously[cite: 31].
* **Energy Management**: Automatically isolating and disconnecting devices that are currently powered off (`disconnettiSpenti`)[cite: 31].
* **Dynamic Capacity Expansion**: Resizing the internal storage array dynamically when the home automation controller reaches its maximum capacity (`estendiCentralina`)[cite: 31].

---

## 🏗️ System Architecture & Class Structure

The project is engineered around a decoupled architecture using behavioral interfaces, abstract base classes, and domain-specific exceptions[cite: 26, 30, 31, 32, 33]:

### 1. Interfaces
* **`Actionable`**: Defines the fundamental behavioral contract for all controllable appliances, mandating the implementation of `accendi()` (turn ON) and `spegni()` (turn OFF) methods[cite: 30].

### 2. Domain Models & Exceptions
* **`Dispositivo` (Superclass)**: Implements `Actionable`[cite: 33]. Represents a generic smart device, encapsulating essential attributes: unique identifier (`codice`), power state (`acceso`), and connection status (`disconnesso`)[cite: 33]. Implements state-validation logic to prevent turning ON an already active device or turning OFF an already off device[cite: 33].
* **`Illuminazione` (Subclass of `Dispositivo`)**: Represents a smart light bulb or lighting fixture[cite: 26]. Automatically regulates brightness (`livelloluce`) to 50 when switched ON, and drops to 0 when switched OFF[cite: 26].
* **`Condizionamento` (Subclass of `Dispositivo`)**: Represents a smart HVAC/air conditioning unit[cite: 32]. Automatically regulates environmental metrics when activated: setting temperature (`temperatura`) to 23°C and humidity (`umidita`) to 40%[cite: 32].
* **`AccendiExt` & `SpegniExt`**: Custom checked exceptions extending `Exception`, thrown when an invalid state transition is attempted (e.g., trying to power on an appliance that is already active)[cite: 27, 29, 33].

### 3. Controllers & Execution
* **`Centralina`**: The core management unit acting as the database and controller for the smart home[cite: 31]:
  * **Duplicate Prevention (`inserisci`)**: Scans existing records before registration to prevent duplicate device codes[cite: 31].
  * **Safe Deletion (`elimina`)**: Locates a target device by its code, shifts array elements to fill the memory gap, and safely decrements the active device counter (`count`) to prevent memory leaks or duplicate pointers[cite: 31].
  * **Dynamic Array Resizing (`estendiCentralina`)**: When the number of active devices reaches the array threshold (`MaxDevices`), the system allocates a new array expanded by `extSize` and migrates all existing device pointers[cite: 31].
  * **State Auditing (`showConfig`)**: Filters and displays active versus disconnected devices, providing a real-time system health report[cite: 31].
* **`Abitazione`**: The main execution entry point (`main` method) simulating a real-world scenario of registering devices, triggering batch commands, testing array expansion, and removing faulty units.

---

## ⚙️ Key Features & Technical Highlights

1. **Memory-Safe Array Shifting**: Implements precise index manipulation during device removal (`elimina`), ensuring that trailing duplicate references are explicitly nullified (`dispositivi[count] = null`) after shifting elements left[cite: 31].
2. **Polymorphic State Transitions**: Leveraging the `Actionable` interface, the controller iterates through heterogeneous collections of lights and air conditioners, triggering domain-specific state behaviors (like temperature or lumen adjustments) via a single polymorphic command (`accendiTutti`)[cite: 26, 31, 32].
3. **Defensive State Exception Handling**: Prevents logical state corruption by throwing checked exceptions (`AccendiExt`, `SpegniExt`) whenever illegal operations are attempted, ensuring appliances maintain synchronized state representations[cite: 27, 29, 33].
4. **On-Demand Capacity Expansion**: Replaces fixed-size limitations with an intelligent resizing algorithm that expands memory by user-defined blocks (`extSize`) only when physical capacity is fully exhausted[cite: 31].
