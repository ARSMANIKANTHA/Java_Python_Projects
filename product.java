
public class product {
    //(Quantity variables)Three Products A,B,C 
    int productA;
    int productB;
    int productC;
    boolean wrap;//Wrap or Not Wrap

    int valA=20,valB=40,valC=50;//Intailizing value variables with the each product price
    //constructor to assaign values to Quantity variables read from the user
    product(int A,int B,int C,boolean d){
        this.productA=A;
        this.productB=B;
        this.productC=C;
        this.wrap=d;
    }

    //Function to find actual price and Subtotal
    public void actualPrice(){
        System.out.println("Product A\t"+productA+"\t"+(productA*valA));
        System.out.println("Product B\t"+productB+"\t"+(productB*valB));
        System.out.println("Product C\t"+productC+"\t"+(productC*valC));
        System.out.println("Subtotal :"+(productA*valA+productB*valB+productC*valC));
    }

    //Check Out price used to find Gift charges ,final price 
    public void checkOutprice(){
        int totalProducts=productA+productB+productC;
        long fPrice=productA*valA+productB*valB+productC*valC;
        int Giftwrapfee=0;
        int Shippingcharge=0;
        if(wrap){
            Giftwrapfee = totalProducts;
        }
        Shippingcharge=(totalProducts/10)*5;
            if(totalProducts%10!=0){
                Shippingcharge+=5;
            }
        fPrice=fPrice-discounts_applied()+Giftwrapfee+Shippingcharge;
        System.out.println("Gift Wrap Charge : "+Giftwrapfee+"\nShipping Charges : "+Shippingcharge);
        System.out.println("Final Price : "+fPrice);
    }

    //Function to find discounts on each products
    public long discounts_applied(){
        if(!(isflat_10() || isbulk_10() || isbulk_5() || istiered_50())){
            System.out.println("Not Eligible for discounts!");
            return 0;
        }
        long finalPrice=(productA*valA)+(productB*valB)+(productC*valC);
        int index=0;
        //To find the maximum discount I used an array to store all values after finding discount and found minimum vale among all
        String [] discounts= new String[]{"flat_10_discount","bulk_5_discount","bulk_10_discount","tiered_50_discount"};
        long [] finalPrices=new long[]{flat_10(),bulk_5(),bulk_5(),tiered_50()};
        for(int i=0;i<finalPrices.length;i++){
            if(finalPrice>finalPrices[i]){
                finalPrice=finalPrices[i];
                index=i;
            }
        }
        System.out.println("Discount Applied :"+discounts[index]+"\nDiscount Amount: "+((productA*valA+productB*valB+productC*valC)-finalPrice));
        System.out.println("Array of discounts");
        for(Long i:finalPrices){
            System.out.println(i);
        }
        return (productA*valA+productB*valB+productC*valC)-finalPrice;
    }



    //Functions to find Discount if Eligible (Function name is its discount)

    private long flat_10(){
        long value=productA*valA+productB*valB+productC*valC;
        if(isflat_10()){
            value-=value*0.1;   
        }
        return value;
    }

    private long bulk_5(){
        long value=productA*valA+productB*valB+productC*valC;
        if(isbulk_5()){
            if(productA>10){
                value-=(productA*valA)*.05;
            }

            if(productB>10){
                value-=(productB*valB)*.05;
            }

            if(productC>10){
                value-=(productC*valC)*.05;
            }
        }
        return value;
    }

    public long bulk_10(){
        long value=productA*valA+productB*valB+productC*valC;
        if(isbulk_10()){
            value-=value%10;
        }
        return value;
    }

    private long tiered_50(){
        long value=productA*valA+productB*valB+productC*valC;
        if(istiered_50()){
            if(productA>15){
                value-=(productA*valA)*0.5;
            }
            if(productB>15){
                value-=(productB*valB)*0.5;
            }
            if(productC>15){
                value-=(productC*valC)*0.5;
            }
        }
        return value;
    }

    
    //Function to check Eligibility of Discounts

    public boolean isflat_10(){
        if((this.productA*valA+this.productB*valB+this.productC*valC)>200){
            return true;
        }else{
            return false;
        }
    }

    public boolean isbulk_5(){
        if(productA>10 || productB>10 ||productC>10){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isbulk_10(){
        if(productA+productB+productC>20){
            return true;
        }else{
            return false;
        }
    }

    public boolean istiered_50(){
        if(productA+productB+productC>30 && (productA>15 || productB>15 ||productC>15)){
            return true;
        }else{
            return false;
        }
    }  
}
