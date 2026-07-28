# 🔔 Circular Priority Notification Queue System (Gestione Notifiche)

Hi everyone! 👋 Welcome to my Java OOP project called **Circular Priority Notification Queue System**! 

I developed this software to simulate how a smartphone or an operating system manages different push notifications, alerts, and text messages using a specialized circular buffer[cite: 80, 82]. The whole application is built using fundamental Object-Oriented Programming (OOP) concepts like abstract classes, interfaces, inheritance, polymorphism, custom checked exceptions, and circular array math[cite: 77, 78, 79, 80, 81, 83]!

---

## 💡 What is this project about?

Basically, the software manages a stream of general notifications (`Notifica`)[cite: 77, 80]. Every notification has a priority level (*priority*) ranging from 0 up to a maximum ceiling of 5[cite: 77, 80].

Because a modern device receives different kinds of alerts, I divided the general notification class into two specific subclasses[cite: 79, 83]:
* **Standard Messages (`Messaggio`)**: General text communications (like chat messages or meeting reminders) that encapsulate a text string (*msg*)[cite: 83].
* **System Alerts (`Avviso`)**: Critical system notifications that must strictly follow a specific security format[cite: 79]. Every alert contains an identification code (*codice*)[cite: 79]. To be considered valid, the code must be exactly 4 characters long, starting with the capital letter `'A'` followed by 3 numeric digits (for example, `"A401"`)[cite: 79]! If an invalid code like `"B123"` is submitted, the system rejects it immediately[cite: 82]!

---

## 🛠️ How the Code is Structured

To keep the project clean, modular, and well-organized, I divided the logic into 7 specialized files[cite: 77, 78, 79, 80, 81, 82, 83]:

* **`Notificabile`**: An interface that defines a single behavioral contract: `showNotification()` (which forces classes to implement a display method)[cite: 78].
* **`Notifica`**: The abstract superclass implementing `Notificabile`[cite: 77]. It stores the priority level and ensures that any priority higher than 5 is automatically capped at 5[cite: 77].
* **`Messaggio` & `Avviso`**: Subclasses extending `Notifica`[cite: 79, 83]. They override the `showNotification()` method to print formatted strings[cite: 79, 83]. `Avviso` also implements the `checkCode()` security validation algorithm[cite: 79].
* **`EccezioneNotifica`**: A custom checked exception extending `Exception`, used to alert the system whenever an alert with an invalid security code is pushed into the queue[cite: 81].
* **`CodaNotifiche`**: The core controller class representing our circular buffer (`Notifica[]`)[cite: 80]. It manages insertion pointers (`coda`), extraction pointers (`testa`), handles priority replacements when the buffer is full, removes elements, and filters the array by notification type or priority[cite: 80]!
* **`GestioneNotifiche`**: The main execution class containing the `main` method where we test the whole system by filling the queue, triggering security exceptions, testing priority overwriting, filtering messages, and extracting items from the head of the buffer[cite: 82]!

---

## 🌟 Key Features

1. **Circular Buffer Math**: As you can see in the `CodaNotifiche` class, the array is managed as a circular queue using the modulo operator (`%`)[cite: 80]. When the tail pointer reaches the end of the array capacity, it automatically wraps around to index 0 (`coda = (coda + 1) % capacita`), optimizing memory usage without shifting array elements[cite: 80]!
2. **Smart Priority Overwriting**: When the buffer is completely full (`piena()`) and a new notification arrives, the queue does not simply reject it[cite: 80]. Instead, it scans the existing buffer to find an element with a lower priority than the incoming one, replacing it dynamically to ensure high-priority alerts are always stored[cite: 80]!
3. **Defensive Code Screening**: Before any `Avviso` is inserted into the queue, the system verifies its code string using `Character.isDigit()` inside a loop[cite: 79, 80]. If the code is invalid, an `EccezioneNotifica` is thrown, protecting the queue from corrupted data[cite: 80, 81, 82]!
4. **Targeted Array Filtering**: The `filtra()` method allows users to extract specific subsets of notifications without modifying the main queue[cite: 80]. By passing parameter `0`, it extracts only `Messaggio` objects; by passing a priority number (like `5`), it extracts only `Avviso` objects matching that exact priority[cite: 80]!
