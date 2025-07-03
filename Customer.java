public class Customer {
   /*  c_id
    name
    add
    phone
    email
    ammountpayable
    saleslimit  */

    private int C_id;
    private String name;
    private String address;
    private String phone_no;
    private String email;
    private double ammountpayable;
    private double saleslimit;

    public Customer(){
        this.C_id=0;
        this.name="xyz";
        this.address="xyz";
        this.phone_no="xyz";
        this.email="xyz";
        this.ammountpayable=0;
        this.saleslimit=0;
    }
    public Customer(int C_id,String name,String address,String phone_no,String email,double amountpayable,double saleslimit){
        this.C_id=C_id;
        this.name=name;
        this.address=address;
        this.phone_no=phone_no;
        this.email=email;
        this.ammountpayable=amountpayable;
        this.saleslimit=saleslimit;
    }
    public void setC_id(int C_id){
        this.C_id=C_id;
    }
    public void setname(String name){
        this.name=name;
    }
    public void setaddress(String address){
        this.address=address;
    }
    public void setphone_no(String phone_no){
        this.phone_no=phone_no;
    }
    public void setemail(String email){
        this.email=email;
    }
    public void setamountpayable(double ammountpayable){
        this.ammountpayable=ammountpayable;
    }
    public void setsaleslimit(double saleslimit){
        this.saleslimit=saleslimit;
    }
    public int getC_id(){
        return C_id;
    }
    public String getname(){
        return name;
    }
    public String getaddress(){
        return address;
    }
    public String getphone_no(){
        return phone_no;
    }
    public String getemail(){
        return email;
    }
    public double getammountpayable(){
        return ammountpayable;
    }
    public double getsaleslimit(){
        return saleslimit;
    }
}
