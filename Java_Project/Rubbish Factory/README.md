# ♻️ Waste Classification & Disposal Center Manager (Gestione Rifiuti)

Hi everyone! 👋 Welcome to my Java OOP project called **Waste Classification & Disposal Center Manager**[cite: 129]! 

I developed this application to simulate how a smart waste management facility classifies different materials and processes them inside specialized recycling centers[cite: 128, 133, 134]. The coolest part about this project is that it uses a **custom generic class** (`CentroSmaltimento<T extends Riciclabile>`) backed by a linked list to collect and filter accepted waste[cite: 128]! 

The whole software architecture is built using fundamental Object-Oriented Programming (OOP) concepts like interfaces, polymorphism, Java Generics, parallel arrays, and custom checked exceptions[cite: 128, 130, 131, 133, 134, 135]!

---

## 💡 What is this project about?

Basically, the software manages general recyclable items (`Riciclabile`)[cite: 131]. Every item can be analyzed against a reference database table (`Tabella`) to find its actual waste category (like glass, plastic, or paper)[cite: 131, 132, 135]. 

Because an urban waste network deals with items from completely different origins, I created two specific implementing classes[cite: 133, 134]:
* **Domestic Waste (`RifiutoDomestico`)**: Standard household garbage (like bottles or jars) that holds a description and a material code (for example, `"PL01"` or `"VE01"`)[cite: 133]. Its category is looked up directly inside the reference table[cite: 133, 135]!
* **Industrial Waste (`ScartoIndustriale`)**: Complex waste originating from industrial sectors (like mechanical, chemical, or sanitary)[cite: 129, 134]. Along with its material code, it holds a boolean flag indicating if it is dangerous (*pericoloso*)[cite: 134]. When the system classifies industrial waste, if the item is marked as dangerous or originates from the `"CHIMICO"` or `"SANITARIO"` sectors, it automatically overrides the table lookup and classifies the item as `"SPECIALE"` (hazardous waste)[cite: 134]!

---

## 🛠️ How the Code is Structured

To keep the project clean, modular, and well-organized, I divided the logic into 8 specialized files[cite: 128, 129, 130, 131, 132, 133, 134, 135]:

* **`Riciclabile`**: An interface requiring classes to implement a `findCat()` method that returns the waste category string[cite: 131].
* **`Tabella`**: A reference database using parallel arrays (`codice[]` and `categoria[]`) to map material codes to categories[cite: 135]. It can be loaded dynamically from an external text file (`Rifiuti.txt`) or manually via keyboard input[cite: 132, 135]!
* **`RifiutoDomestico` & `ScartoIndustriale`**: The domain classes implementing `Riciclabile`[cite: 133, 134]. They apply polymorphic classification rules to determine their category[cite: 133, 134].
* **`NonSmaltibileException`**: A custom checked exception extending `Exception`, thrown whenever an item's code is not found in the table or when a disposal center rejects an incompatible material[cite: 128, 130, 135]!
* **`CentroSmaltimento<T extends Riciclabile>`**: A generic controller class representing a specialized recycling facility (for example, a center dedicated exclusively to `"VETRO"`)[cite: 128, 129]. It manages an internal `LinkedList` and screens incoming items before accepting them[cite: 128]!
* **`GestioneRifiuti`**: The main execution class containing the `main` method where we test the whole system[cite: 129]! We initialize the classification table, test polymorphic material identification, and simulate sending various industrial waste items to a glass disposal center[cite: 129]!
* **`Rifiuti.txt`**: The text file storing the standard mapping codes for plastics, glass, organic waste, paper, metals, and unsorted garbage[cite: 132].

---

## 🌟 Key Features

1. **Parallel Array Mapping**: As you can see in the `Tabella` class, the database maps material codes to categories using two synchronized arrays (`codice[]` and `categoria[]`)[cite: 135]. The `categoriaPerCodice()` method scans the array cleanly and throws a `NonSmaltibileException` if a code is missing[cite: 135]!
2. **Polymorphic Safety Overrides**: This is one of the coolest parts of the project! When calling `findCat()` on a mixed array of items, domestic waste simply returns its mapped table category[cite: 133]. However, industrial waste dynamically checks its sector and danger flags at runtime, instantly reclassifying chemical or sanitary waste as `"SPECIALE"` to prevent environmental contamination[cite: 134]!
3. **Generic Disposal Screening**: The `CentroSmaltimento` class uses Java Generics (`<T extends Riciclabile>`) to ensure type safety[cite: 128]. When the `conferisci()` method processes an item, it verifies that the item's category matches the center's specialization[cite: 128]. If someone tries to dispose of chemical waste or paper inside a glass recycling center, the method blocks the insertion and throws a `NonSmaltibileException`[cite: 128, 129]!
