import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.util.*; 
import javax.swing.JOptionPane;
public class MakeNewSalee{
    private ArrayList<item> ITE;
    private ArrayList<Customer> Cust;
    private ArrayList<Sale> Salee;
    private ArrayList<SaleLineItem> SLI;
    private ArrayList<Receipt> recep;
    private Itemcontroller itC;
    private C_controller custC;
    private S_control saleC;
    private SL_control SLIc;
    private R_control recpC;
    private ArrayList<item> I;
    public static int count;
    
    public MakeNewSalee(){
        ITE = new ArrayList<item>();
        Cust = new ArrayList<Customer>();
        Salee = new ArrayList<Sale>();
        SLI = new ArrayList<SaleLineItem>();
        recep = new ArrayList<Receipt>();
        itC = new Itemcontroller();
        custC = new C_controller();
        saleC = new S_control();
        SLIc = new SL_control();
        recpC = new R_control();
        setArraylist();
        I =  new ArrayList<item>();

    }
    public void setArraylist(){
        this.ITE=itC.getitemobj();
        this.Cust=custC.getCustomerobj();
        this.Salee=saleC.getSaleobj();
        this.SLI=SLIc.getSalelineobj();
        this.recep=recpC.getReceiptobj();
    }

    public void makesale(){
        ArrayList<item>Ai = new ArrayList<item>();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
   LocalDateTime now = LocalDateTime.now(); 
   String dd =  dtf.format(now);
   String Cid = JOptionPane.showInputDialog(null, "Date"+dd+"\n Enter customer ID : ");
    int A = Integer.parseInt(Cid);
    A = custC.search_customer(A);
    if(A == -1){
        JOptionPane.showMessageDialog(null, "Customer ID not found");
    }
    else{
        int option =0;
        do{
            option = Integer.parseInt(JOptionPane.showInputDialog(null,"Press 1 to Enter New Item \nPress 2 to End Sale\n Press 3 to Remove an existing Item from the current sale\nPress 4 to Cancel Sale\n\n\nChoose from option 1 - 4" ));
           switch(option){
            case 1:
            int it_id = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Item ID"));
             it_id = itC.search_item(it_id);
             if(it_id == -1){
                JOptionPane.showMessageDialog(null, "Item ID not found");
             }
             else{
                item i =(item)ITE.get(it_id);
                String k = JOptionPane.showInputDialog(null,"\n item id : "+i.getitemId()+"\n Description : "+i.getdescription()+"\n item Quantity : ");
                int q = Integer.parseInt(k);
                Double price = q*i.getprice();
            item item_ai = new item(i.getitemId(),i.getdescription(),price,q,i.getcreation_date());
            Ai.add(item_ai);
            JOptionPane.showMessageDialog(null,"\n date "+dd+"\n Customer ID : "+Cid+"\n ITEM ID : " +i.getitemId()+"\n Description : "+i.getdescription()+"\n Price "+i.getprice()+"\n Quantity "+q+"\n Sub Total "+ price);

             }
            break;
            case 2:{
            count= count+1;
            Double Total = 0.0;
            int sid;
            if(Salee.isEmpty()== true){
                sid=1;
            }
            else{
                Sale ss = (Sale)Salee.get(Salee.size()-1);
                sid = ss.getOrder_id()-1;
                
            }
            int b = Integer.parseInt(Cid);
            b= custC.search_customer(b);
           
                    Customer c =(Customer)Cust.get(b);
                   int  f = 1;
                   DateTimeFormatter dtfs = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
                 LocalDateTime nows = LocalDateTime.now(); 
                String dds =  dtfs.format(nows);
                for (int i = 0; i<Ai.size();i++){
                    item ix=(item)Ai.get(i);
                    SaleLineItem sli = new SaleLineItem(f,sid,ix.getitemId(),ix.getquantity(),ix.getprice());
                    
                    int ind = itC.search_item(ix.getitemId());
                    item ix2 = (item)ITE.get(ind);
                    ix2.setquantity(ix2.getquantity()-ix.getquantity());
                    Total =Total+ix.getprice();
                    SLI.add(sli);
                    f++;
                }
                Sale s = new Sale(sid,c.getC_id(),dds,null);
                Receipt r = new Receipt(sid,dd,sid,Total);
                Salee.add(s);
                recep.add(r);
           }
            break;
            case 3:
            I.clear();
            break;
            case 4:
           itC.setArrayitem(ITE);
           custC.setArrayCustomer(Cust);
           saleC.setArraysale(Salee);
           SLIc.setArraysaleline(SLI);
           recpC.setArrayreceipt(recep);
           itC.save_itemfile();;
           custC.save_customerfile();
           saleC.save_salefile();
           SLIc.save_SeleLinefile();
           recpC.save_reciptfile();

            break;
           }
           
        }while(option != 4);
    }
    
    }


}