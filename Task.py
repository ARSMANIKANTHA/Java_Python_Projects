print("Details of the Product: \n Product-->Cost(in $)\n Product A : $20 \n Product B : $50 \n Product C : $40")

print("Enter your quantity:")
qtyA=int(input("Enter A:"))
qtyB=int(input("Enter B:"))
qtyC=int(input("Enter C:"))
wrap=False
x= int(input("Would you like to wrap(Yes:1) or (No: 0):"))
if x==1:
    wrap=True
valA=20
valB=40
valC=50

def flat_10():
    val=qtyA*valA+qtyB*valB+qtyC*valC;
    if(isflat_10()):
        val-=val*0.1
    return val;

def isflat_10():
    if(qtyA+qtyB+qtyC>200):
        return True
    else:
        return False

def isbulk_5():
    if(qtyA>10 or qtyB>10 or qtyC>10):
        return True
    else:
        return False
        
def bulk_5():
    value=qtyA*valA+qtyB*valB+qtyC*valC;
    if(isbulk_5()):
        if(qtyA>10):
            value-=(qtyA*valA)*.05;

        if(qtyB>10):
            value-=(qtyB*valB)*.05;

        if(qtyC>10):
            value-=(qtyC*valC)*.05;
    return value

def isbulk_10():
    if(qtyA+qtyB+qtyC>20):
        return True
    else:
        return False
        
def bulk_10():
    value=qtyA*valA+qtyB*valB+qtyC*valC;
    if(isbulk_10()):
            value-=value%10
    return value
        
def istiered_50():
    if(qtyA+qtyB+qtyC>30 and (qtyA>15 or qtyB>15 or qtyC>15)):
        return True
    else:
        return False
    
def tiered_50():
    value=qtyA*valA+qtyB*valB+qtyC*valC;
    if(istiered_50()):
        if(qtyA>15):
                value-=(qtyA*valA)*0.5
        if(qtyB>15):
                value-=(qtyB*valB)*0.5
        if(qtyC>15):
                value-=(qtyC*valC)*0.5
    return value
    
def discounts_applied():
        if(not(isflat_10() or isbulk_10() or isbulk_5() or istiered_50())):
            print("Not Eligible for discounts!")
            return 0
            
        finalPrice=(qtyA*valA)+(qtyB*valB)+(qtyC*valC)
        index=0;
        # To find the maximum discount I used an array to store all values after finding discount and found minimum vale among all
        discounts=["flat_10_discount","bulk_5_discount","bulk_10_discount","tiered_50_discount"]
        finalPrices=[flat_10(),bulk_5(),bulk_5(),tiered_50()]
        for i in range(len(finalPrices)):
            if(finalPrice>finalPrices[i]):
                finalPrice=finalPrices[i]
                index=i
        print("Discount Applied :",discounts[index],"\nDiscount Amount: ",((qtyA*valA+qtyB*valB+qtyC*valC)-finalPrice))
        return (qtyA*valA+qtyB*valB+qtyC*valC)-finalPrice
        
def checkOutprice():
    totalProducts=qtyA+qtyB+qtyC
    fPrice=qtyA*valA+qtyB*valB+qtyC*valC
    Giftwrapfee=0
    Shippingcharge=0
        
    if(wrap):
        Giftwrapfee = totalProducts
    Shippingcharge=(totalProducts//10)*5
    if(totalProducts%10!=0):
        Shippingcharge+=5
    fPrice=fPrice-discounts_applied()+Giftwrapfee+Shippingcharge
    print("Gift Wrap Charge : ",Giftwrapfee,"\nShipping Charges : ",Shippingcharge)
    print("Final Price : ",fPrice)
        
def actualPrice():
        print("Product A\t",qtyA,"\t",(qtyA*valA))
        print("Product B\t",qtyB,"\t",(qtyB*valB))
        print("Product C\t",qtyC,"\t",(qtyC*valC))
        print("Subtotal :",(qtyA*valA+qtyB*valB+qtyC*valC))
        
actualPrice()
checkOutprice()
    
