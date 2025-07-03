import javax.security.auth.callback.ChoiceCallback;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.text.SimpleDateFormat;   
import java.util.Date; 
import java.util.*;

public class Showreport {
    private ArrayList<item> it;
    private Itemcontroller ir;
    private ArrayList<Customer> Cus;
    private C_controller cr;
    private ArrayList<Sale> s;
    private S_control sr;
    private ArrayList<SaleLineItem> SI; 
    private SL_control slr;
    private ArrayList<Receipt> r;
    private R_control rc;


    public Showreport(){
        it = new ArrayList<item>();
        ir = new Itemcontroller();
        it = ir.getitemobj();
        Cus = new ArrayList<Customer>();
        cr = new C_controller();
        Cus = cr.getCustomerobj();
        s = new ArrayList<Sale>();
        sr = new S_control();
        s=sr.getSaleobj();
        SI= new ArrayList<SaleLineItem>();
        slr= new SL_control();
        SI=slr.getSalelineobj();
        r = new ArrayList<Receipt>();
        rc= new R_control();
        r = rc.getReceiptobj();
    }


    public void stockhand(){

        String OutPut = "Stock in Hand \n";
        OutPut = OutPut +"Item ID      Discription          price   Quantity     Creation Date \n";
        OutPut=OutPut+"*******************************************\n";
        for(int i = 0; i<it.size();i++){
            item I =(item)it.get(i);
            OutPut=OutPut+I.getitemId()+"       "+I.getdescription()+"          "+I.getprice()+"        "+I.getquantity()+"        "+I.getcreation_date()+"\n";
        }
        OutPut=OutPut+"********************************************\n";
        JOptionPane.showMessageDialog(null,OutPut);
        }
        //***************************************************************** */
        public void salereport(){
            // ArrayList<item> itm = new ArrayList<item>();
   String  date1=JOptionPane.showInputDialog(null,"please enter initial  date  : ");
   String date2 = JOptionPane.showInputDialog(null, "enter final  date :  ");
    String Output = "sale report \n initial date : "+ date1+"       finale date"+date2+"\n";



    Double total_ammount = 0.0;
            Output = Output+"******************************\n";
        Output=Output+"item id       description       Quantity        Ammount \n ";
        Output = Output +"***********************************\n";     
    
            for(int i=0; i<s.size();i++){
                Sale S = (Sale)s.get(i);
                String date = S.getdate();
                Boolean checkdate = Dateok(date1, date2, date);
                if(checkdate == true ){
                    for(int k=0 ; k < SI.size();k++){
                        SaleLineItem si = (SaleLineItem)SI.get(k);


                      
                        if(S.getOrder_id()== si.getOrder_id()){
                            
                            int in=  ir.search_item(si.getitemId());                    
                        item ite = (item)it.get(in);
                    total_ammount = total_ammount + si.getamount();
                        Output = Output + ite.getitemId()+"             "+ite.getdescription()+"              "+si.getquantity()+"              "+si.getamount()+"\n";
                        }
                    }
                
                } 
            }
             Output = Output+ "******************************\n";
             Output = Output+"          total sale  = Rs "+ total_ammount+"\n";
             Output = Output+"*****************************\n";
             JOptionPane.showMessageDialog(null, Output);











        }



        //********************************************************** */
        public Boolean Dateok( String date1, String date2,  String date)
{
    Boolean check = false;
  try{ 
     
  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  Date Date1 = dateFormat.parse(date1);
  Date Date2 = dateFormat.parse(date2);
  Date Date = dateFormat.parse(date);
  if (Date2.after(Date)&&Date1.before(Date))   
  {   
    check = true;  
  }  
  else if(Date1.equals(Date)||Date2.equals(Date)){
    check = true;
  }
  
  }
  catch(Exception io){
    JOptionPane.showMessageDialog(null, io);
  }
  return check;
  }



    public void showreportmenu(){
        int choice = 0;
        String show="********Reports Menu*********\n";
        show=show+"1. Stock in hand \n";
        show=show+"2. Outstanding Orders \n";
        show=show+"3. Customer Balance \n";
        show=show+"4. Sale receipt \n";
        show=show+"5. Back to main menu  \n";
        show=show+"Press 1 to 5 to select any option ";
        show=show+"**********************************";
        
        do{
            String S = JOptionPane.showInputDialog(null,show);
            choice = Integer.parseInt(S);
            switch(choice){
                case 1:
                stockhand();
                break;
                case 2:
               salereport();

                break;
                case 3:
                String W = JOptionPane.showInputDialog(null,"please enter customer Id :");

               int g = Integer.parseInt(W);
               int ik = cr.search_customer(g);
               Customer C = (Customer)Cus.get(ik);
               double Balance = C.getsaleslimit()-C.getammountpayable();
               JOptionPane.showMessageDialog(null,cr.getcustomerdata(g)+"\n balance = "+Balance);
                break;
                case 4:
                salereport();
                break;

            }
        }while(choice != 5);
    
        
    }
    
}
