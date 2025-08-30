# 🏦 Bank Account Management System (Java, OOP)

A simple **console-based banking system** implemented in **Java**.  
This project demonstrates core **Object-Oriented Programming (OOP)** concepts like Encapsulation, Inheritance, Method Overriding, and Constructor Overloading.

---

## 📌 Features
- ✅ Create new Bank and Savings accounts  
- ✅ Deposit and Withdraw money  
- ✅ Calculate interest (Bank: 5%, Savings: 8%)  
- ✅ Maintain transaction history for each account  
- ✅ Simple login system (basic authentication)  
- ✅ Menu-driven interface for user interaction  
- ✅ Uses **ArrayList** to store multiple accounts  

---

## 🛠️ Technologies Used
- **Java** (Core + OOP concepts)  
- **Collections Framework (ArrayList)**  
- **Multi-package structure** for clean modular design  

---

## 🧑‍💻 OOP Concepts Demonstrated
- **Encapsulation** → Private fields with getters/setters  
- **Inheritance** → SavingsAccount extends BankAccount  
- **Constructor Overloading/Chaining**  
- **Method Overriding** for interest calculation  
- **Polymorphism** when handling different account types  

---

## 🚀 Future Enhancements
- Store account details & transactions in a file or database (persistence)  
- Add more account types (Current, Loan, etc.)  
- Add Exception Handling for invalid inputs  
- Create a GUI (JavaFX / Swing) for better usability  

---

## 📂 Project Structure
BankAccountManagementSystem/   <-- main project folder
├── src/                       <-- source code folder
│   ├── bank/                  <-- package
│   │   ├── app/               <-- subpackage for application runner
│   │   │   └── Main.java      <-- entry point
│   │   └── models/            <-- subpackage for models
│   │       ├── Bankaccount.java
│   │       └── Savingsaccount.java
├── README.md                  <-- documentation file

