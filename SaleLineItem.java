public class SaleLineItem {
    private int line_no;
    private int Order_id;
    private int item_id;
    private int quantity;
    private double amount;

    public SaleLineItem(){
        this.line_no=0;
        this.Order_id=0;
        this.item_id=0;
        this.quantity=0;
        this.amount=0;
    }
    public SaleLineItem(int line_no,int Order_id,int item_id,int quantity,double amount){
    
        this.line_no=line_no;
        this.Order_id=Order_id;
        this.item_id=item_id;
        this.quantity=quantity;
        this.amount=amount;
    }
    
    public void setline_no(int line_no){
        this.line_no=line_no;
    }
    public void setOrder_id(int Order_id){
        this.Order_id=Order_id;
    }
    public void setitem_id(int item_id){
        this.item_id=item_id;
    }
    public void setquantity(int quantity){
        this.quantity=quantity;
    }
    public void setamount(double amount){
        this.amount=amount;
    }
    public int getline_no(){
        return line_no;
    }
    public int getOrder_id(){
        return Order_id;
    }
    public int getitemId(){
        return item_id;
    }
    public int getquantity(){
        return quantity;
    }
    public double getamount(){
        return amount;
    }
}
