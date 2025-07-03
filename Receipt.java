public class Receipt {
    private int receipt_no;
    private String receipt_date;
    private int Order_no;
    private double amount;

    public Receipt(){
        this.receipt_no=0;
        this.receipt_date="xyz";
        this.Order_no=0;
        this.amount=0.0;
    }
    public Receipt(int receipt_no,String receipt_date,int Order_no,double amount)
    {   
        this.receipt_no=receipt_no;
        this.receipt_date=receipt_date;
        this.Order_no=Order_no;
        this.amount=amount;

    }
    public int getreceipt_no() {
        return receipt_no;
}
public void setreceipt_no(int receipt_no)
 {
    this.receipt_no = receipt_no;
}
    public String getreceipt_date() {
        return receipt_date;
    }
    public void setreceipt_date(String receipt_date){
        this.receipt_date=receipt_date;
    }

    public int getOrder_no() 
    {
        return Order_no;
}
public void setOrder_no(int Order_no) 
{
    this.Order_no=Order_no;
}
    public double getamount()
    {
        return amount;
    }
    public void setamount(double amount)
    {
        this.amount=amount;
    }

}