import java.util.*;
import javax.swing.*;
public class Payment {
        private ArrayList<Customer> Cus;
        private ArrayList<Sale> S;
        private ArrayList<Receipt> R;
        private C_controller CCon;
        private S_control Scon;
        private R_control RCon;

        public Payment(){
            Cus = new ArrayList<Customer>();
            S = new ArrayList<Sale>();
            R = new ArrayList<Receipt>();
            CCon = new C_controller();
            Scon = new S_control();
            RCon = new R_control();
            this.Cus = CCon.getCustomerobj();
           this.S = Scon.getSaleobj();
          this.R = RCon.getReceiptobj();
        }
        public void addpayment(){
            String A=JOptionPane.showInputDialog(null, "enter sale ID");
            int i = Integer.parseInt(A);
            int index = Scon.Search(i);
            if(index == -1){
                JOptionPane.showMessageDialog(null, "Invalid ID");
            }
            else{
               Sale s=(Sale)S.get(index);
               i = CCon.search_customer(s.getC_id());
                Customer c =(Customer)Cus.get(i);
                i= RCon.search(s.getOrder_id());
                Receipt r =(Receipt)R.get(i);
                Double pay = r.getamount()-c.getammountpayable();
                String B= JOptionPane.showInputDialog(null,"\n Sale ID : "+s.getOrder_id()+"\n Customer Namer : "+c.getname()+"\n Total ammount = "+r.getamount()+"\n Ammount to be paid : "+c.getammountpayable()+"\n Remaining ammount = "+pay+"\n Ammount to be paid =");
            Double G = Double.parseDouble(B);
                c.setamountpayable(G+c.getammountpayable());
                CCon.setArrayCustomer(Cus);
            }

            }

        }
