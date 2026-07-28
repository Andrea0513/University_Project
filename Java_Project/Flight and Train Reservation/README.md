# ✈️🚄 Train & Flight Travel Booking Manager (Gestione Prenotazioni)

Hi everyone! 👋 Welcome to my Java OOP project called **Train & Flight Travel Booking Manager**[cite: 112]! 

I created this software to simulate how a travel agency or a transport station manages different passenger bookings[cite: 112, 115, 116, 117]. The coolest part about this project is that instead of using standard Java collections like `ArrayList`, I built a **custom singly-linked list** from scratch to store all the bookings and filter them by departure date and time[cite: 111]!

The whole application is built using fundamental Object-Oriented Programming (OOP) concepts like class inheritance, composition, polymorphism, custom node pointers, and file I/O operations[cite: 109, 110, 111, 112, 114, 115, 116, 117]!

---

## 💡 What is this project about?

Basically, the software manages a general travel booking (`Prenotazione`)[cite: 111, 115]. Every booking holds important passenger and scheduling data: a booking code (*codice*), origin city, destination city, travel date, a custom departure time object (`DepTime`), and a passenger profile (`Persona`)[cite: 110, 114, 115].

Because a travel agency manages completely different transport methods, I divided the general class into two specific subclasses[cite: 116, 117]:
* **Train Bookings (`Treno`)**: Traditional railway bookings[cite: 112, 116]. They encapsulate train-specific details, such as the carriage number (*carrozza*) and the specific seat number (*posto*) assigned to the passenger[cite: 116].
* **Flight Bookings (`Volo`)**: Airport airline bookings[cite: 112, 117]. Along with the airplane seat number, they encapsulate the gate closing time (*gate*), alerting passengers how many minutes before departure the boarding gate will close[cite: 117]!

---

## 🛠️ How the Code is Structured

To keep the project modular, clean, and well-organized, I divided the logic into 8 specialized files[cite: 109, 110, 111, 112, 114, 115, 116, 117]:

* **`Comparable<T>`**: A custom interface requiring classes to implement a `compareTo()` method for potential sorting[cite: 109].
* **`Persona` & `DepTime`**: Helper helper classes[cite: 110, 114]. `Persona` stores passenger first and last names, while `DepTime` encapsulates departure hours and minutes, formatting them cleanly (like `09:30`)[cite: 110, 114]!
* **`Prenotazione`**: The superclass storing all common travel scheduling data and implementing the base `stampaPrenotazione()` method[cite: 115].
* **`Treno` & `Volo`**: Subclasses extending `Prenotazione`[cite: 116, 117]. They override the printing and `toString()` methods to append carriage numbers or gate closing alerts[cite: 116, 117].
* **`Elenco`**: The core controller class representing our **custom linked list**[cite: 111]! It uses an internal `Nodo` class to link bookings together (`testa` pointer), pushes new bookings to the top of the list, counts matching trips, and filters the list by date and departure time[cite: 111]!
* **`Gestione`**: The main execution class containing the `main` method where we test the whole system[cite: 112]! We register train and flight bookings for passengers, ask the user to input a target search date and time via keyboard, print the filtered results, and export the tickets directly into a text file[cite: 112]!

---

## 🌟 Key Features

1. **Custom Linked-List Management**: As you can see in the `Elenco` class, bookings are stored inside dynamically allocated nodes (`Nodo`)[cite: 111]. The `push()` method inserts new elements directly at the head of the list (`testa = q`), allowing fast insertions without wasting memory on empty array slots[cite: 111]!
2. **Targeted Date & Time Filtering**: The `filtraElenco()` method allows users to search the linked list for trips departing after a specific date and time[cite: 111, 112]. It traverses the pointers cleanly (`while(temp != null)`), checks if the departure date matches, and verifies if the departure hour and minutes are greater than or equal to the user's input[cite: 111]!
3. **Automatic File Exporting**: Using `PrintWriter`, the `stampaSuFile()` method takes the filtered array of bookings and automatically exports the printable tickets directly into an external text file called `Nuovofile.txt` in the project directory[cite: 112, 113]!
4. **Polymorphic Type Counting**: When the filtered array is passed to `contaClassi()`, the system loops through the trips and uses the `instanceof` keyword to dynamically check whether each booking is a `Volo` or a `Treno`, printing an exact statistical breakdown of the transport types[cite: 112]!
