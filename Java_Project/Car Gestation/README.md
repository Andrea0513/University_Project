# 🚗 Car Quotation & Accessory Configurator (Gestione Preventivi)

Hi everyone! 👋 Welcome to my Java OOP project called **Car Quotation & Accessory Configurator**. 

I developed this application to simulate how a car dealership software works when configuring vehicle quotations[cite: 57]. The system allows users to customize different cars with optional accessories and calculates the final price by considering engine types, environmental taxes, battery costs, and government incentives[cite: 55, 56, 57]!

The whole architecture is built using fundamental Object-Oriented Programming (OOP) concepts like abstract classes, inheritance, polymorphism, and a **custom linked list** built completely from scratch[cite: 55, 56, 57, 58, 60]!

---

## 💡 What is this project about?

Basically, the software manages vehicle price quotations (`Autovettura`)[cite: 57]. When a customer configures a car, they start with a base price and then add custom accessories (`Accessorio`), like GPS Navigation or Leather Seats[cite: 54, 57, 59].

To make it realistic, I divided cars into two specific subclasses[cite: 55, 56]:
* **Combustion Cars (`AutoACombustione`)**: Traditional gasoline or diesel cars[cite: 55, 59]. When calculating their final quotation, the software automatically adds an environmental tax (*tassa ambientale / malus*) due to CO2 emissions[cite: 55].
* **Electric Cars (`AutoElettrica`)**: Modern eco-friendly vehicles[cite: 56]. These cars require adding the cost of the high-voltage battery (`costoBatteria`)[cite: 56]. However, the software automatically subtracts a government bonus discount (*incentivo statale*) to reward eco-friendly buyers, significantly reducing the final price[cite: 56]!

---

## 🛠️ How the Code is Structured

I tried to keep the project clean, modular, and well-organized by dividing the logic into 7 specialized files[cite: 54, 55, 56, 57, 58, 59, 60]:

* **`Comparable<T>`**: A custom interface that requires classes to implement a `compareTo()` method for price/cost comparisons[cite: 58].
* **`Accessorio`**: Represents an optional feature (like parking sensors)[cite: 54, 59]. It encapsulates the accessory name and its base price[cite: 54].
* **`ListaAccessori`**: This is one of the coolest parts of the project! Instead of using standard Java libraries like `ArrayList`, I built a **custom singly-linked list** from scratch using an internal `Nodo` class[cite: 60]. It can add new accessories, search for existing ones to prevent duplicates, and safely remove items (even if they are at the head of the list!)[cite: 60].
* **`Autovettura`**: The abstract superclass representing a generic vehicle[cite: 57]. It holds the brand, model, base price, and the custom linked list of accessories[cite: 57]. It also implements `Comparable` to compare total vehicle quotations[cite: 57].
* **`AutoACombustione` & `AutoElettrica`**: Subclasses extending `Autovettura`[cite: 55, 56]. They override the abstract method `calcolaPreventivo()` to apply their specific math formulas (adding taxes or subtracting state incentives)[cite: 55, 56].
* **`GestionePreventivi`**: The main execution class containing the `main` method where we test the whole configurator. We create a Fiat Panda (combustion) and a Fiat 500 (electric), equip them with accessories, compare their final quotations, and test accessory removal!

---

## 🌟 Key Features

1. **Dynamic Quotation Math**: As you can see in the code, the final quotation is dynamically computed at runtime by combining base costs, optional accessories total, and engine-specific bonuses or taxes[cite: 55, 56, 57].
2. **Custom Linked List Management**: The `ListaAccessori` class manages pointers (`testa` and `next`) directly[cite: 60]. I implemented protective logic: if you try to add two "Alloy Wheels" (*Cerchi in lega*), the list detects the duplicate and blocks the insertion!
3. **Head-Node Safe Deletion**: In my custom list, the `elimina()` method safely checks if the item you want to remove is located right at the first node (`testa`), adjusting the head pointer cleanly without causing memory leaks[cite: 60].
4. **Precision Comparisons**: Both accessories and car quotations use `Double.compare()` inside their `compareTo` methods[cite: 54, 57]. This makes sure that decimal prices are compared with 100% mathematical precision without losing cents due to integer casting!
