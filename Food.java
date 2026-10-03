import java.util.ArrayList;
import java.util.Scanner;
class Customer{
    String name;
    Address address;
    Customer(String name,Address address){
        this.name=name;
        this.address=address;
    }
}
class Address{
    String city;
    Address(String city){
        this.city=city;
    }
}
class Restaurant{
    String name;
    Restaurant(String name){
        this.name=name;
    }
}
class FoodItem {
    String name;
    double price;
    int quantity;
    FoodItem(String name,double price,int quantity) {
        this.name= name;
        this.price=price;
        this.quantity=quantity;
    }
    double getTotal(){
        return price*quantity;
    }
}

class Order{
    Customer customer;
    Restaurant restaurant;
    ArrayList<FoodItem> items;

    Order(Customer customer, Restaurant restaurant){
        this.customer=customer;
        this.restaurant=restaurant;
        items=new ArrayList<>();
    }

    void addFoodItem(FoodItem item){
        items.add(item);
    }

    double calculateSubtotal(){
        double subtotal=0;
        for (FoodItem item : items){
            subtotal = subtotal + item.getTotal();
        }
        return subtotal;
    }
    double calculateDiscount(){
        double subtotal = calculateSubtotal();
        if (subtotal >= 1000) {
            return subtotal * 10 / 100;
        }
        return 0;
    }
    double calculateTax(){
        double subtotal = calculateSubtotal();
        double discount = calculateDiscount();

        return (subtotal - discount) * 5 / 100;
    }
    double calculateFinalBill() {
        double subtotal = calculateSubtotal();
        double discount = calculateDiscount();
        double tax = calculateTax();

        return subtotal - discount + tax + 50;
    }
    void displayOrder() {
        System.out.println("Customer: " + customer.name);
        System.out.println("Restaurant: " + restaurant.name);
        System.out.println("Subtotal: " + calculateSubtotal());
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Tax: " + calculateTax());
        System.out.println("Delivery Charge: 50.0");
        System.out.println("Final Bill: " + calculateFinalBill());
    }
}
public class Food{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String customerName = sc.nextLine();
        String addressName = sc.nextLine();
        String restaurantName = sc.nextLine();
        Address address = new Address(addressName);
        Customer customer = new Customer(customerName, address);
        Restaurant restaurant = new Restaurant(restaurantName);
        int n = sc.nextInt();
        Order order = new Order(customer, restaurant);
        for (int i = 0; i < n; i++) {
            String foodName = sc.next();
            double price = sc.nextDouble();
            int quantity = sc.nextInt();
            FoodItem item = new FoodItem(foodName, price, quantity);
            order.addFoodItem(item);
        }
        order.displayOrder();
        sc.close();
    }
}
