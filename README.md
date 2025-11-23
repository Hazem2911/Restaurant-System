<p align="center">
  <img src="UML.png"  width="600"/>
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

src/
├─ Main.java                       # CLI entry point, orchestrates menus, ordering, billing
├─ Menu/                           # Menu models & repository
│  ├─ IMenuItem.java               # item abstraction (id, name, price)
│  ├─ MenuItem.java                # concrete menu item model (id, name, price, category)
│  ├─ IMenu.java                   # menu abstraction (type + list of IMenuItem)
│  ├─ Menu.java                    # menu container (menuType, items)
│  ├─ MenuRepo.java                # loads/holds available menus
│  ├─ VegetarianMenu.java          # concrete vegetarian menu
│  ├─ NonVegetarianMenu.java       # concrete non-vegetarian menu
│  ├─ KidsMenu.java                # concrete kids menu
│  ├─ Pizza.java                   # Pizza variant (extends MenuItem)
│  ├─ Burger.java                  # Burger variant (extends MenuItem)
│  └─ Salad.java                   # Salad variant (extends MenuItem)
│
│  ├─ AddOnDecorator/              # Decorator for item customizations
│  │  ├─ IAddOn.java               # add-on metadata interface
│  │  ├─ AddOnDecorator.java       # abstract decorator wrapping IMenuItem
│  │  ├─ CheeseAddOn.java          # concrete add-on
│  │  └─ SauceAddOn.java           # concrete add-on
│  │
│  └─ MenuFactory/                 # Factory/Abstract Factory for menus
│     ├─ IMenuFactory.java
│     ├─ VegetirianMenuFactory.java
│     ├─ NonVegeterianMenuFactory.java
│     └─ KidsMenuFactory.java
│
├─ Ordering/                        # Order model, builder, observer, facade
│  ├─ Order.java                    # aggregate order (items, totals, applyTaxRate)
│  ├─ OrderItem.java                # line item in an order
│  │
│  ├─ Builder/                      # Builder pattern for creating orders
│  │  ├─ IOrderBuilder.java
│  │  ├─ ConcreteOrderBuilder.java
│  │  └─ OrderDirector.java
│  │
│  ├─ Observer/                     # Observer pattern for notifications
│  │  ├─ ISubject.java
│  │  ├─ IObserver.java
│  │  ├─ OrderSubject.java
│  │  ├─ WaiterDisplay.java
│  │  ├─ KitchenDisplay.java
│  │  └─ NotificationService.java
│  │
│  └─ Facade/                       # Facade to expose ordering workflow
│     ├─ IOrderingFacade.java
│     ├─ OrderingFacade.java
│     ├─ InventoryService.java
│     └─ PaymentService.java
│
├─ Payments/                        # Payment processing and billing
│  ├─ PaymentProcessor.java
│  ├─ PaymentDetails.java
│  ├─ PaymentResult.java
│  ├─ Receipt.java
│  │
│  ├─ Strategy/                     # Payment strategies (Strategy pattern)
│  │  ├─ IPaymentStrategy.java
│  │  ├─ CashPayment.java
│  │  ├─ CreditCardPayment.java
│  │  └─ MobileWalletPayment.java
│  │
│  └─ Billing/                      # Billing service, taxes, receipts
│     └─ BillingService.java
│
└─ Discounts/                       # Discount handling (Strategy pattern)
   ├─ DiscountService.java
   └─ Strategy/
      ├─ IDiscountStrategy.java
      ├─ PizzaDiscount.java
      ├─ MeatDiscount.java
      └─ ChickenDiscount.java

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
      




      
