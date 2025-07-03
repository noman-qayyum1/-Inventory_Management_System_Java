public class Sale {
    private int Order_id;
    private int C_id;
    private String date;
    private String status;


    public Sale(){
        this.Order_id=0;
        this.C_id=0;
        this.date="xyz";
        this.status="xyz";
    }
    public Sale(int Order_id,int C_id,String date,String status){
        this.Order_id=Order_id;
        this.C_id=C_id;
        this.date=date;
        this.status=status;
    }
    public void setOrder_id(int Order_id){
        this.Order_id=Order_id;
    }
    public void setCustomer_id(int C_id){
        this.C_id=C_id;
    }
    public void setdate(String date){
        this.date=date;
    }
    public void setstatus(String status){
        this.status=status;
    }
    public int getOrder_id(){
        return Order_id;
    }
    public int getC_id(){
        return C_id;
    }
    public String getdate(){
        return date;
    }
    public String getstatus(){
        return status;
    }
}
