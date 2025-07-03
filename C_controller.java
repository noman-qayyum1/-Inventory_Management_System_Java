import java.util.ArrayList;
import java.io.*;
import javax.swing.*;
public class C_controller {
    private ArrayList<Customer> Cus;
    static private int count;
   
    public C_controller() {
        Cus = new ArrayList<Customer>();
        upload_Customerfile();
        count = 0;
    }
    public ArrayList<Customer> getCustomerobj(){
        return Cus;
    }
    public void setArrayCustomer(ArrayList<Customer>Cus){
        this.Cus=Cus;
    }
    public void finalizer(){
        count = count-1;
    }
//*********************************************************************************************************************************************************
    public void add_Customer(){
        /*private int C_id;
        private String name;
        private String address;
        private String phone_no;
        private String email;
        private double ammountpayable;
        private double saleslimit;

        */

        int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Customer ID : "));
        String name = JOptionPane.showInputDialog(null,"Enter Customer Name : ");
        String address = JOptionPane.showInputDialog(null,"Enter Customer Address : ");
        String phone_no = JOptionPane.showInputDialog(null,"Enter Customer Phone No : ");
        String email = JOptionPane.showInputDialog(null,"Enter Customer Email : ");
        double ammountpayable = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Customer Ammount Payable : "));
        double saleslimit = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Customer Sales Limit : "));

        Customer c = new Customer(id,name,address,phone_no,email,ammountpayable,saleslimit);
        Cus.add(c);
        count=count+1;
        JOptionPane.showMessageDialog(null,"Customer Added Successfully");
        }
//*********************************************************************************************************************************************************

    public void remove_Customer(){
        int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Customer ID : "));
        int i = search_customer(id);
        if(i == 1){
            JOptionPane.showMessageDialog(null,"Customer Not Found");
            }
            else{
               Cus.remove(i);
               count=count-1;
               JOptionPane.showMessageDialog(null,"Customer Removed Successfully");

    }
}
//*********************************************************************************************************************************************************
public int search_customer(int C_id){
    int i = 0;
    for( i=0;i<Cus.size();i++)
    {
        if(Cus.get(i).getC_id() == C_id){
            return i;
            }
            }
            return -1;
            }
//*********************************************************************************************************************************************************
            public void Update_customer(){
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Customer ID : "));
                    int i = search_customer(id);
                    if(i == 1){
                        JOptionPane.showMessageDialog(null,"Customer Not Found");
                        }
                        else{
                            Customer C = (Customer)Cus.get(i);
                            String A = "Customer details \n ";
                            A=A + "Customer ID = "+C.getC_id()+"\n";
                            A=A+"Customer Name = "+C.getname()+"\n";
                            A=A+"Customer address = "+C.getaddress()+"\n";
                            A=A+"Customer phone number = "+C.getphone_no()+"\n";
                            A=A+"Customer email = "+C.getemail()+"\n";
                            A=A+"Ammount payabale = "+C.getammountpayable()+"\n";
                            A=A+"Sales limit +"+C.getsaleslimit()+"\n";
                            C.setC_id(Integer.parseInt(JOptionPane.showInputDialog(null,A+"PLease enter new ID : ")));
                            C.setname(JOptionPane.showInputDialog(null,A+"Enter new name : "));
                            
                            C.setaddress(JOptionPane.showInputDialog(null,A+"Enter new Customer address : "));
                            C.setphone_no(JOptionPane.showInputDialog(null,A+"Enter new Phone number : "));
                            C.setamountpayable(Double.parseDouble(JOptionPane.showInputDialog(null,A+"enter new payable ammount : ")));
                            C.setsaleslimit(Double.parseDouble(JOptionPane.showInputDialog(null, A+"enter new sale limit ")));
                            JOptionPane.showMessageDialog(null,"Customer DATA uploaded successfully hurray !!!!");

                        }

}
//*********************************************************************************************************************************************************
    public static int getCount() {
    return count;
        }
//*********************************************************************************************************************************************************
public void upload_Customerfile(){ 
    try{
        String tokens[] = null;
        FileReader fr = new FileReader("Customer.txt");
        BufferedReader br = new BufferedReader(fr);
        String C_line = br.readLine();
        while(C_line !=  null){ 
          tokens = C_line.split(";");
          Customer cs = new Customer(Integer.parseInt(tokens[0]),tokens[1],tokens [2],tokens[3],tokens [4],Double.parseDouble(tokens [5]),Double.parseDouble(tokens[6]));
          Cus.add(cs);
          C_line = br.readLine();
          count = count+1;
          
        }
        br.close();
        fr.close();
       }
       catch(IOException i){
        JOptionPane.showMessageDialog(null, i);
      }   
}
//*********************************************************************************************************************************************************

    public void save_customerfile(){
        try{
            FileWriter fw = new FileWriter("Customer.txt");
            // BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(fw);
            for(int i=0;i<Cus.size();i++){

                Customer  C = (Customer)Cus.get(i);
                pw.println(C.getC_id()+";"+C.getname()+";"+C.getaddress()+";"+C.getphone_no()+";"+C.getemail()+";"+C.getammountpayable()+";"+C.getsaleslimit());
    }
    pw.flush();
    pw.close();
    fw.close();
}
catch(IOException i){
    JOptionPane.showMessageDialog(null, i);
    }
}
//*********************************************************************************************************************************************************
    public String getcustomerdata(int C_id){
        String b = "not found ";
        int ii=search_customer(C_id);
       if(ii == -1){
        JOptionPane.showMessageDialog(null,"******Customer not found *****");
       }
       else{
        Customer C = (Customer)Cus.get(ii);
        b = "Customer details \n ";
        b=b+"Enter customer Id ; "+C.getC_id()+"\n";
        b=b+"Enter customer name ; "+C.getname()+"\n";
        b=b+"Enter customer address ; "+C.getaddress()+"\n";
        b=b+"Enter customer phone No ; "+C.getphone_no()+"\n";
        b=b+"Enter customer email ; "+C.getemail()+"\n";
        b=b+"Enter customer Ammount payable  ; "+C.getammountpayable()+"\n";
        b=b+"Enter customer Sales limit ; "+C.getsaleslimit()+"\n";
        
       }
       return b;
    }
    //******************************************************************************************************************
            public void displayCustomer_menu(){
                int option = 0;
                String display="***********Customer MENU************\n";
                display = display+"1. Add Customer\n";
                display = display+"2. Delete Customer\n";
                display = display+"3. Update Customer\n";
                // display = display+"4. View Item\n";
                display = display+"4. View Item History\n";
                display = display+"5. Exit\n";
                display = display+"*******************************\n";
                do
                {
                    String S =JOptionPane.showInputDialog(null, display);
            option = Integer.parseInt(S);
            switch(option){
                case 1:
                add_Customer();
                break;
                case 2:
                remove_Customer();
                break;
                case 3:
                Update_customer();
                break;
                case 4:
                int ik=Integer.parseInt(JOptionPane.showInputDialog(null, "enter Customer ID")); 
                int a = search_customer(ik);
                if(a==-1){
                    JOptionPane.showMessageDialog(null,"Please enter valid ID :) ");
                
                }
                else{
                    Customer C = (Customer)Cus.get(a);
                    JOptionPane.showMessageDialog(null,"Customer ID : "+C.getC_id()+"\n Name : "+C.getname()+"\n address "+C.getaddress()+"\n Phone no : "+C.getphone_no()+"\n Email :  "+C.getemail()+"\n Ammount payable :"+C.getammountpayable()+"\n sales limit "+C.getsaleslimit());
                }
                break;
                case 5:
                save_customerfile();
                break;
                }
            }
            while(option != 5);
          
}
//*********************************************************************************************************************************************************

}

