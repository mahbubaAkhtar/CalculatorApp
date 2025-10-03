# Calculator App (Android)

This project is a **simple & user-friendly Calculator App** built using **Java** in **Android Studio**.  
It performs basic arithmetic operations like addition, subtraction, multiplication, and division, with support for **integer and decimal calculations**.  
The app features a modern **Material Design** UI for a smooth user experience.

---

## 🚀 Project Overview

The goal of this project:

- Build a functional Android calculator using **Java**  
- Handle both **integers and decimal numbers** correctly  
- Provide **error handling** for invalid operations (e.g., division by zero)  
- Design a **clean and responsive UI** using **Material Buttons and TextViews**  
- Ensure **user-friendly experience**: input clears on result display  

> By the end, the app demonstrates a fully functional Android calculator suitable for beginners and advanced users alike.

---

## 📱 Features

- Basic arithmetic operations: `+`, `-`, `*`, `/`  
- Support for **integer and decimal calculations**  
- `C` button: deletes last character  
- `AC` button: clears all input and resets the result  
- `=` button: calculates the result and **clears input**  
- Modern **Material Design buttons** with rounded corners  
- **Error handling** for invalid operations  

---

## 📁 Files in Repository

### 📁 CalculatorApp

- `MainActivity.java` → Core Java logic for calculator operations  
- `activity_main.xml` → UI layout with **Material Buttons** and **TextViews**  
- `colors.xml` → Custom colors for buttons and text  
- `styles.xml` → Theme and style definitions  
- `AndroidManifest.xml` → App configuration  

---

## 📝 Methodology

### 1️⃣ UI Design 🎨

- Used **MaterialButton** for all calculator buttons  
- Two **TextViews**:  
  - `solutionTextView` → shows user input  
  - `resultTextView` → shows calculation result  
- Buttons arranged in **LinearLayouts** for rows  
- Rounded corner design for modern UI  

---

### 2️⃣ Calculator Logic 🔢

- **OnClickListener** implemented for all buttons  
- Arithmetic expression evaluated using **stack-based approach**  
- Operator precedence handled (`*` & `/` > `+` & `-`)  
- Decimal & integer distinction maintained using `DecimalFormat`  

---

### 3️⃣ Special Functionalities

- **AC button**: Clears input & result  
- **C button**: Deletes last input character  
- **= button**: Evaluates expression, shows result, clears input  
- Error handling: division by zero → displays `0` or `Error`  

---

## 📊 Screenshots

✔ **Main Calculator Screen**  
 ![photo](https://github.com/mahbubaAkhtar/CalculatorApp/blob/a308a27f3f4ea4a2544a9a991bdfdb4852c4ba9e/Main%20Calculetor.jpeg)
---

## 📈 Project Outcomes

- **Functional Calculator**: Supports all basic arithmetic operations  
- **Clean UI & UX**: Material Design, responsive buttons, and user-friendly interface  
- **Integer & Decimal Support**: Proper distinction between integers and decimals  
- **Error Handling**: Prevents crashes on invalid operations  
- **Beginner-Friendly Android Project**: Demonstrates core Java and Android concepts  

---

## 🛠️ Tech Stack

- **Language**: Java  
- **IDE**: Android Studio  
- **UI Design**: XML + Material Components  
- **Version Control**: GitHub  

---

## ✍ Author

**Mahbuba Akhtar Jidni**  
Android Developer | [GitHub](https://github.com/mahbubaAkhtar)  

---

⭐️ If you like this project, give it a star!
