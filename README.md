#Restaurant Ordering & Billing System
<img src="UML.png"/>
A modular, extensible CLI-based Restaurant Ordering & Billing System implemented in Java.

Purpose: demonstrate SOLID principles and common OO design patterns (Factory, Builder, Decorator, Strategy, Observer, Facade) while providing a working ordering → payment → billing workflow.

🌟 Features

Multiple menu families: Vegetarian, Non‑Vegetarian, Kids (Abstract Factory)

Menu items with variants: Pizza, Burger, Salad

Customizable add-ons using Decorator (extra cheese, sauces)

Order creation via Builder pattern (stepwise construction)

Order notifications to kitchen/waiter using Observer

Payment processing with Strategy pattern (Cash, Credit Card, Mobile Wallet)

Automatic discount strategies (Pizza, Meat, Chicken)

Billing service calculates taxes, applies discounts, and generates receipts

Facade provides a unified ordering workflow

🏗️ Project Structure (High Level)
src/
├─ Main.java                   # CLI entry point
├─ Menu/                       # Menu models & repository
│  ├─ IMenuItem, MenuItem
│  ├─ IMenu, Menu, MenuRepo
│  ├─ VegetarianMenu, NonVegetarianMenu, KidsMenu
│  ├─ AddOnDecorator/          # IAddOn, AddOnDecorator, CheeseAddOn, SauceAddOn
│  └─ MenuFactory/             # Menu factory interfaces & implementations
├─ Ordering/
│  ├─ Order, OrderItem
│  ├─ Builder/                 # IOrderBuilder, ConcreteOrderBuilder, OrderDirector
│  └─ Observer/                # ISubject, IObserver, OrderSubject, KitchenDisplay, WaiterDisplay
│  └─ Facade/                  # IOrderingFacade, OrderingFacade, Inventory/Payment services
├─ Payments/
│  ├─ PaymentProcessor, PaymentDetails, PaymentResult, Receipt
│  ├─ Strategy/                # Payment strategies
│  └─ Billing/                 # BillingService
└─ Discounts/                  # DiscountService & strategies

🧩 Design Patterns Used
Pattern	Purpose
Abstract Factory / Factory	Menu family creation
Builder	Constructing Order objects
Decorator	Adding customizable menu item add-ons
Strategy	Payment & discount algorithms
Observer	Order notifications (Kitchen / Waiter)
Facade	Simplified ordering API
🖥️ Build & Run (Windows PowerShell)
# Create bin directory
mkdir -Force bin

# Compile all .java files
& javac -d bin @(Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })

# Run the application
& java -cp bin Main
