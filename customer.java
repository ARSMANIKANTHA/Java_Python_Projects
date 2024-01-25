import java.util.Scanner;
public class customer{
    public static void main(String[] args) {
        int Aqty=0,Bqty=0,Cqty=0;
        Scanner scan = new Scanner(System.in);
        //Asking user for Input
        System.out.println("Here are the deatils of Products:\n(Product->Cost)\nProduct A:$20\nProduct B:$40\nProduct C:$50");
        System.out.println("Enter Product A quantity:");
        Aqty=scan.nextInt();
        if(Aqty<0)Aqty=0;
        System.out.println("Enter Product B quantity:");
        Bqty=scan.nextInt();
        if(Bqty<0)Bqty=0;
        System.out.println("Enter Product C quantity:");
        Cqty=scan.nextInt();
        if(Cqty<0)Cqty=0;
        scan.nextLine();

        //Asking user for wrapping or not
        System.out.println("Would you like the product to be wrapped?\nYes(Press 1) or No(Press 0) : ");
        boolean wrapping=false;
        if(scan.nextInt()!=0){
            wrapping=true;;
        }
        scan.close();

        //Calling Product Constructor
        product product1 = new product(Aqty, Bqty, Cqty,wrapping);
        //Displaying details
        System.out.println("ProductName<-->Quantity<-->Total Amount");

        //Actual Price function Displays price of each product and SubTotal
        product1.actualPrice();
        //Checkout Price fucntion Displays  Discount Amount ,Gift wrap charge(If applicable),Shipping Charges and Final Price 
        product1.checkOutprice();


    }
}