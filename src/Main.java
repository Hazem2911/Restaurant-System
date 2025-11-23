import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Payments.Billing.BillingService;
import Payments.Receipt;
import Discounts.DiscountService;
import Ordering.Order;
import Ordering.OrderItem;
import Ordering.Observer.OrderSubject;
import Ordering.Observer.WaiterDisplay;
import Ordering.Observer.KitchenDisplay;
import Ordering.Observer.NotificationService;
import Menu.IMenuItem;
import Menu.Menu;
import Menu.MenuRepo;
import Menu.Pizza;
import Menu.Salad;
import Menu.Burger;
import Menu.AddOnDecorator.CheeseAddOn;
import Menu.AddOnDecorator.SauceAddOn;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        MenuRepo repo = buildMenus();
        System.out.println("Welcome to CLI Restaurant");

        List<OrderItem> items = selectItems(in, repo);

        if (items.isEmpty()) {
            System.out.println("No items selected. Exiting.");
            return;
        }

        String orderType = getOrderType(in);
        Integer table = getTableNumber(in, orderType);

        Order order = createOrderWithObservers(items, orderType, table);

        applyDiscountsAndTax(order);

        printOrderSummary(order);

        BillingService billing = new BillingService();
        System.out.println("\n--- RECEIPT (PRE-PLACE) ---");
        System.out.println(billing.generateReceipt(order, LocalDate.now().toString()));

        System.out.print("\nPlace order now? (y/n): ");
        if (readYesNo(in)) {
            order.place();
            System.out.println("Order placed. Final receipt:");
            System.out.println(billing.generateReceipt(order, LocalDate.now().toString()));
        } else {
            System.out.println("Order cancelled.");
        }
    }

    // -------------------------------------------------------------------------
    // MENU CREATION
    // -------------------------------------------------------------------------

    private static MenuRepo buildMenus() {
        MenuRepo repo = new MenuRepo();

        repo.addMenu(new Menu("Vegetarian", List.of(
                new Pizza("V-01", "Margherita", 8.50f, "Medium", true),
                new Salad("V-02", "Garden Salad", 5.00f, "Olive", true),
                new Burger("V-03", "Veg Burger", 6.50f, "Sesame", false)
        )));

        repo.addMenu(new Menu("NonVegetarian", List.of(
                new Pizza("N-01", "Pepperoni", 9.50f, "Large", false),
                new Salad("N-02", "Chicken Caesar", 6.50f, "Caesar", false),
                new Burger("N-03", "Chicken Burger", 7.00f, "Brioche", true)
        )));

        repo.addMenu(new Menu("Kids", List.of(
                new Pizza("K-01", "Kids Pizza", 5.50f, "Small", true)
        )));

        return repo;
    }

    // -------------------------------------------------------------------------
    // ITEM SELECTION
    // -------------------------------------------------------------------------

    private static List<OrderItem> selectItems(Scanner in, MenuRepo repo) {
        List<OrderItem> selected = new ArrayList<>();

        boolean adding = true;
        while (adding) {
            Menu chosenMenu = chooseMenu(in, repo);
            if (chosenMenu == null) break;

            IMenuItem item = chooseMenuItem(in, chosenMenu);
            if (item == null) continue;

            item = applyAddOns(in, item);

            int qty = askQuantity(in);

            selected.add(new OrderItem(
                    item.getId(),
                    item.getName(),
                    qty,
                    item.getPrice()
            ));

            System.out.print("Add more items? (y/n): ");
            adding = readYesNo(in);
        }
        return selected;
    }

    private static Menu chooseMenu(Scanner in, MenuRepo repo) {
        System.out.println("\nAvailable menus:");
        for (int i = 0; i < repo.getMenus().size(); i++) {
            System.out.println((i + 1) + ") " + repo.getMenus().get(i).getMenuType());
        }

        System.out.print("Choose menu number (0 to stop): ");
        int choice = readInt(in);
        if (choice <= 0) return null;

        if (choice > repo.getMenus().size()) {
            System.out.println("Invalid choice.");
            return null;
        }
        return repo.getMenus().get(choice - 1);
    }

    private static IMenuItem chooseMenuItem(Scanner in, Menu menu) {
        System.out.println("Items in " + menu.getMenuType() + ":");

        List<IMenuItem> items = menu.getItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("  %d) %s - %.2f%n",
                    (i + 1),
                    items.get(i).getName(),
                    items.get(i).getPrice());
        }

        System.out.print("Select item number (0 to cancel): ");
        int choice = readInt(in);
        if (choice <= 0) return null;

        if (choice > items.size()) {
            System.out.println("Invalid item.");
            return null;
        }

        return items.get(choice - 1);
    }

    private static IMenuItem applyAddOns(Scanner in, IMenuItem item) {
        System.out.print("Add extra cheese? (y/n): ");
        if (readYesNo(in)) item = new CheeseAddOn(item);

        System.out.print("Add extra sauce? (y/n): ");
        if (readYesNo(in)) item = new SauceAddOn(item);

        return item;
    }

    private static int askQuantity(Scanner in) {
        System.out.print("Quantity: ");
        return Math.max(1, readInt(in));
    }

    // -------------------------------------------------------------------------
    // ORDER DETAILS
    // -------------------------------------------------------------------------

    private static String getOrderType(Scanner in) {
        System.out.println("\nChoose order type: 1) DINE_IN  2) DELIVERY  3) TAKEAWAY");
        return switch (readInt(in)) {
            case 1 -> "DINE_IN";
            case 2 -> "DELIVERY";
            default -> "TAKEAWAY";
        };
    }

    private static Integer getTableNumber(Scanner in, String orderType) {
        if (!orderType.equals("DINE_IN")) return null;

        System.out.print("Table number (0 to skip): ");
        int t = readInt(in);
        return (t > 0) ? t : null;
    }

    // -------------------------------------------------------------------------
    // ORDER CREATION & OBSERVERS
    // -------------------------------------------------------------------------

    private static Order createOrderWithObservers(List<OrderItem> items, String type, Integer table) {
        OrderSubject subject = new OrderSubject();
        new WaiterDisplay(subject);
        new KitchenDisplay(subject);
        new NotificationService(subject);

        Order order = new Order("ORD-" + System.currentTimeMillis(), subject);
        items.forEach(order::addItem);

        String req = "OrderType=" + type + (table != null ? ";Table=" + table : "");
        order.setSpecialRequests(req);

        return order;
    }

    // -------------------------------------------------------------------------
    // DISCOUNT & TAX
    // -------------------------------------------------------------------------

    private static void applyDiscountsAndTax(Order order) {
        order.calculateTotals();

        DiscountService disc = new DiscountService();
        float discountTotal = 0f;

        for (OrderItem it : order.getItems()) {
            float before = it.getLinePrice();
            float after = before;

            String name = it.getName().toLowerCase();

            if (name.contains("pizza")) after = disc.applyDiscount("pizza", before);
            else if (name.contains("chicken") || name.contains("meat")) after = disc.applyDiscount("meat", before);

            discountTotal += before - after;
        }

        order.setDiscount(discountTotal);

        BillingService billing = new BillingService();
        billing.applyTax(order);
    }

    // -------------------------------------------------------------------------
    // SUMMARY
    // -------------------------------------------------------------------------

    private static void printOrderSummary(Order order) {
        System.out.println("\n--- ORDER SUMMARY ---");
        for (OrderItem it : order.getItems()) {
            System.out.printf("%s x%d -> %.2f%n", it.getName(), it.getQuantity(), it.getLinePrice());
        }
        System.out.printf("Subtotal: %.2f%n", order.getSubtotal());
        System.out.printf("Discount: %.2f%n", order.getDiscount());
        System.out.printf("Tax: %.2f%n", order.getTax());
        System.out.printf("Total: %.2f%n", order.getTotal());
    }

    // -------------------------------------------------------------------------
    // INPUT HELPERS
    // -------------------------------------------------------------------------

    private static int readInt(Scanner in) {
        while (!in.hasNextInt()) {
            in.next();
            System.out.print("Enter a number: ");
        }
        return in.nextInt();
    }

    private static boolean readYesNo(Scanner in) {
        String t = in.next();
        return t.equalsIgnoreCase("y") || t.equalsIgnoreCase("yes");
    }
}
