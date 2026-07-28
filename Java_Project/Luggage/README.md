# Airport Luggage & Security Screening Management System (Gestione Bagagli)

A robust Java application designed to simulate airport luggage packing, security regulations enforcement, and weight limit validation. The software utilizes Object-Oriented Programming (OOP) principles, custom checked exceptions, and a custom LIFO (Last-In, First-Out) Stack data structure implemented via a linked list.

---

## 📌 Project Overview

This system models the process of packing personal effects (`EffettoPersonale`) into a passenger's luggage (`Bagaglio`). During the packing phase, items undergo strict airport security validations:
* **Liquids (`Liquido`)**: Must not exceed the standard 100 ml security threshold[cite: 17].
* **Clothing (`Indumento`)**: Must not be excessively bulky (e.g., oversized "XL" items are flagged and rejected)[cite: 24].
* **Weight Constraints**: The total weight of all packed items must strictly adhere to the luggage's maximum weight capacity (default: 20 kg)[cite: 20].

---

## 🏗️ System Architecture & Class Structure

The application is structured around a decoupled architecture using interfaces, abstract classes, and generic transport handlers[cite: 18, 19, 20, 22]:

### 1. Interfaces
* **`Trasportabile`**: Defines the fundamental contract for transportable entities, requiring methods to retrieve current weight (`getPeso`) and validate additional weight capacity (`checkPeso`)[cite: 19].

### 2. Domain Models & Exceptions
* **`EffettoPersonale` (Abstract Superclass)**: Represents a generic personal belonging, encapsulating item type (`tipo`) and weight (`peso`)[cite: 22]. Enforces the implementation of the security screening method `preparaPerViaggio()`[cite: 22].
* **`Liquido` (Subclass)**: Represents liquid items. Overrides `preparaPerViaggio()` to check volume against the 100 ml limit[cite: 17]. Throws `LiquidNotAllowed` if the threshold is breached[cite: 17].
* **`Indumento` (Subclass)**: Represents clothing items. Overrides `preparaPerViaggio()` to validate item bulkiness (`ingombro`)[cite: 24]. Throws `ClothesNotAllowed` if the item is categorized as "XL"[cite: 24].
* **`LiquidNotAllowed` & `ClothesNotAllowed`**: Custom checked exceptions extending `Exception`, used to signal security or sizing violations during the packing process[cite: 21, 25].

### 3. Data Structures & Controllers
* **`Bagaglio` (Implements `Trasportabile`)**: The core collection class modeled as a **Custom Stack (LIFO)** using an internal singly-linked node structure (`Nodo`)[cite: 20]:
  * **`push(EffettoPersonale)`**: Evaluates item security regulations and weight constraints before pushing the node onto the head of the stack[cite: 20]. Internally catches and handles screening exceptions[cite: 20].
  * **`pop(String)`**: Performs a search-and-remove operation, traversing the linked list to locate and extract a specific item by its type name while safely updating the current weight[cite: 20].
  * **`getLiquido()`**: Traverses the internal node structure to filter and return a dynamically sized array containing only valid `Liquido` objects[cite: 20].
  * **`checkPeso(double)`**: Prevents stack insertion if the new item would cause the total weight to exceed the `pesoMax` threshold[cite: 20].
* **`NastroTrasportatore<T extends Trasportabile>`**: A generic conveyor belt handler designed to process collections (Queues) of transportable luggage items[cite: 18].
* **`GestioneBagagli`**: The main execution entry point (`main` method) demonstrating packing attempts, exception handling, item extraction, and liquid filtering[cite: 23].

---

## ⚙️ Key Features & Technical Highlights

1. **Custom Linked-List Stack**: Eliminates reliance on standard Java collection libraries by implementing a raw node-based LIFO stack (`testa` pointer), demonstrating low-level data structure manipulation[cite: 20].
2. **Safe Graph/List Traversal**: Implements defensive null-checking (`temp.next != null`) during node deletion (`pop`) to guarantee immunity against `NullPointerException` when searching for non-existent items[cite: 20].
3. **Dynamic Array Allocation**: Calculates exact matching node counts during sub-collection filtering (`getLiquido`), preventing `ArrayIndexOutOfBoundsException` and memory waste[cite: 20].
4. **Resilient Exception Handling**: The insertion mechanism (`push`) uses defensive `try-catch` blocks to silently intercept security rejections without interrupting the overall execution flow of the packing sequence[cite: 20].
