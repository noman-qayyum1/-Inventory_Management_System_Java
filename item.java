public class item {
/*item id
description
price
quantity
creation date
    */
    private int itemId;
    private String description;
    private double price;
    private int quantity;
    private String creation_date;
    
    public item(){
        this.itemId=0;
        this.description="xyz";
        this.price=0;
        this.quantity=0;
        this.creation_date="xyz";
    }
    public item(int itemId,String description,double price,int quantity,String creation_date){
        this.itemId=itemId;
        this.description=description;
        this.price=price;
        this.quantity=quantity;
        this.creation_date=creation_date;
    }
    public void setitemId(int itemId){
        this.itemId=itemId;
    }
    public void setdescription(String description){
        this.description=description;
    }
    public void setprice(double price){
        this.price=price;
    }
    public void setquantity(int quantity){
        this.quantity=quantity;
    }
    public void setcreation_date(String creation_date){
        this.creation_date=creation_date;
    }
    public int getitemId(){
        return itemId;
    }
    public String getdescription(){
        return description;
    }
    public double getprice(){
        return price;
    }
    public int getquantity(){
        return quantity;
    }
    public String getcreation_date(){
        return creation_date;
    }

}
