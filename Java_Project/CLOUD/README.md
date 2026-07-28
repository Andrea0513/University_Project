# ☁️ Cloud Storage Management System (Gestione Storage)

Hi everyone! 👋 Welcome to my Java project called **Cloud Storage Management System**[cite: 34]. 

I created this application to simulate how a real cloud storage platform works when we upload, organize, and back up different types of files[cite: 34, 39, 40]. The whole project is built using Object-Oriented Programming (OOP) concepts like inheritance, interfaces, polymorphism, and Java Generics[cite: 37, 38, 39, 40, 41, 42, 43]. 

---

## 💡 What is this project about?

Basically, the program allows a system to store files inside a cloud space. When we upload a file to the cloud, it gets wrapped into a `CloudItem` that generates an automatic ID and keeps track of the file size[cite: 39]. 

First of all, the system divides files into two main categories:
* **Standard Files (`FileStandard`)**: These are normal files (like photos or general reports) where the storage cost depends simply on their base price per GB multiplied by the file size[cite: 34, 43].
* **Sensitive Files (`FileSensibile`)**: These are confidential files (like medical records or patents)[cite: 34]. Because they are important, they have a security level (*high*, *medium*, or *low*) and an optional encryption flag (*crittografato*)[cite: 42]. If a file is encrypted or has a high security level, the system automatically adds an extra percentage to the total storage cost[cite: 42]!

---

## 🛠️ How the Code is Structured

To make the code clean and well-organized, I separated the logic into different classes and custom interfaces[cite: 37, 38, 39, 40, 41, 42, 43]:

* **`CalcolaTot` & `Comparable<T>`**: Interfaces that define how to calculate total costs and how to compare two cloud items by their size[cite: 37, 41].
* **`Clone<T>`**: A custom interface that requires classes to implement a deep-cloning method (`clonazione`)[cite: 38].
* **`FileStandard` & `FileSensibile`**: The main domain classes representing the actual files[cite: 42, 43]. `FileSensibile` extends `FileStandard` and overrides the cost calculation to include security surcharges[cite: 42].
* **`CloudItem<T>`**: A generic wrapper class that attaches a unique ID, a size in MB/GB, and calculates the final charge by calling the wrapped file's cost method[cite: 39].
* **`CloudStorage<T>`**: The main controller class that manages a `LinkedList` of cloud items[cite: 40]. It can add new files, sort the storage from smallest to largest using a Bubble Sort algorithm, and export the data to text files[cite: 40].
* **`GestioneStorage`**: The main class with the `main` method where we test the whole system by creating files, adding them to the storage, sorting them, and generating backups[cite: 34].

---

## 🌟 Key Features

1. **Automatic Cost Calculation**: As you can see in the code, the price is dynamically calculated at runtime depending on whether the file is standard or sensitive, and whether it uses encryption[cite: 39, 42, 43].
2. **Size Sorting**: The system sorts all stored items in ascending order based on their size[cite: 40]. I used `Double.compare()` to make sure the decimal sizes are sorted with 100% precision[cite: 39]!
3. **Deep Backup Generation**: Furthermore, the project includes a `backup()` method[cite: 40]. Instead of just copying references (shallow copy), it actually creates a deep clone of every single `CloudItem` and its internal file, saving the cloned list into a separate `backup.txt` file[cite: 39, 40].
4. **File Exporting**: It can print out the full storage report directly into `.txt` files so you can check the IDs, sizes, and final costs easily[cite: 35, 36, 40].
