<p align="center">
  <img src="UML.png" />
</p>

# ┏━ Restaurant Ordering & Billing System ━━━━━━━━━━━━━━

A **modular, extensible CLI-based Restaurant Ordering & Billing System** implemented in **Java**.  
Demonstrates **SOLID principles** and common **OO design patterns** (Factory, Builder, Decorator, Strategy, Observer, Facade) with a working **ordering → payment → billing workflow**.

---

## ┏━ Features ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

- Multiple menu families: Vegetarian, Non‑Vegetarian, Kids *(Abstract Factory)*  
- Menu items with variants: Pizza, Burger, Salad  
- Customizable add-ons using Decorator (cheese, sauces)  
- Order creation using Builder pattern  
- Order notifications to kitchen/waiter via Observer  
- Payment processing with Strategy pattern (Cash, Credit Card, Mobile Wallet)  
- Automatic discount strategies applied  
- Billing service calculates taxes, applies discounts, and generates receipts  
- Facade pattern provides a unified ordering workflow  

---

## ┏━ Project Structure ━━━━━━━━━━━━━━━━━━━━━

<p align="center">
  <img src="./UMLstructure.png" />
</p>

## ┏━ Design Patterns ━━━━━━━━━━━━━━━━━━━━━

| Pattern | Purpose |
|---------|---------|
| Abstract Factory / Factory | Menu family creation |
| Builder | Constructing Order objects |
| Decorator | Adding menu item add-ons |
| Strategy | Payment & discount algorithms |
| Observer | Order notifications (Kitchen / Waiter) |
| Facade | Simplified ordering API |

## ┏━ Build & Run ━━━━━━━━━━━━━━━━━━━━━━━

```powershell
# Create bin directory
mkdir -Force bin

# Compile all .java files
& javac -d bin @(Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })

# Run the application
& java -cp bin Main

# ┏━ CLI Flow (What You Will See) ━━━━━━━━━━━━━━━━━━━━━━━

1. Choose menu type:
   - **Vegetarian**
   - **Non-Vegetarian**
   - **Kids Menu**
2. Select items and specify quantities  
3. Add optional add-ons (cheese, sauces, toppings, etc.)  
4. System builds your order using **Builder + Decorator**  
5. All applicable **discount strategies** are automatically applied  
6. Choose payment method:
   - Cash  
   - Credit Card  
   - Mobile Wallet  
7. Receipt is generated showing:
   - **Subtotal**  
   - **Discounts applied**  
   - **Tax**  
   - **Final Total**  

---

# ┏━ Example Test Cases ━━━━━━━━━━━━━━━━━━━━━━━

## **Test Case A — Chicken Discount Scenario**
1. Start the program  
2. Select **Non-Vegetarian Menu**  
3. Choose any **chicken-based item**  
4. Enter quantity: `2`  
5. Add-on: **Extra Cheese**  
6. Proceed to checkout  

### **Calculation Example** *(if ChickenDiscount = 15%)*  
- Item price: **7.50**  
- Cheese add-on: **0.50**  
- Quantity: **2**  

**Subtotal:**  (7.50 + 0.50) × 2 = 16.00
 **Discount**  16.00 × 0.15 = 2.40
 **Tax (10%)** 3.60 × 0.10 = 1.36
 **Final Total** 13.60 + 1.36 = 14.96

 
---

## **Test Case B — Vegetarian Pizza Discount**
1. Select **Vegetarian Menu**  
2. Pick any Pizza item  
3. System applies the active Pizza discount strategy from:  Discounts/Strategy/PizzaDiscount.java
4. Confirm the receipt discount matches the expected percentage defined in the strategy class.

---

## **Test Case C — Multiple Items + Mixed Discounts**
1. Add a combination of:
- **Pizza**
- **Chicken item**
- **Beef item**
2. System evaluates each item independently under all discount rules  
3. Total discount = **sum of all individual item discounts**

Useful for verifying:
- Strategy pattern behavior  
- Multiple discount rules firing at once  
- Combined order totals and calculations  

---

      




      
