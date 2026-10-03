import java.util.Scanner;
class ProductDetails{
    int productId;
    String name;
    double price;
    ProductDetails(int productId,String name,double price){
        this.productId=productId;
        this.name=name;
        this.price=price;
    }
    double calculateFinalPrice(){
        return price;
    }
}
class Electronics extends ProductDetails{
    Electronics(int id,String name,double price){
        super(id,name,price);
    }
    @Override
    double calculateFinalPrice(){
        return price+(price*18/100)+1000;
    }
}
class Clothing extends ProductDetails{
    Clothing(int id,String name,double price){
        super(id,name,price);
    }
    @Override
    double calculateFinalPrice(){
        double discount=price*10/100;
        double newPrice=price-discount;
        return newPrice+(newPrice*5/100);
    }
}
class Book extends ProductDetails{
    Book(int id,String name,double price){
        super(id,name,price);
    }
    @Override
    double calculateFinalPrice(){
        return price+(price*5/100);
    }
}
public class Product{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ProductDetails[] products=new ProductDetails[n];
        for(int i=0;i<n;i++){
            String type=sc.next();
            int id=sc.nextInt();
            String name=sc.next();
            double price=sc.nextDouble();
            if(type.equals("ELECTRONICS")){
                products[i]=new Electronics(id,name,price);
            }
            else if(type.equals("CLOTHING")){
                products[i]=new Clothing(id,name,price);
            }
            else{
                products[i]=new Book(id,name,price);
            }
        }
        for(int i = 0; i < n; i++){
            System.out.println(products[i].name + ": "+ products[i].calculateFinalPrice());
        }
        sc.close();
    }
}
