import java.util.ArrayList;
import java.io.*;
import javax.swing.*;
public class R_control {
    private ArrayList<Receipt> R;
    static private int count;
    public R_control(){
        R = new ArrayList<Receipt>();
        upload_Receipt_file();
    }
    static public int getcount(){
        return count;
    }
    public ArrayList<Receipt> getReceiptobj(){
        return R;
    }
    public void setArrayreceipt(ArrayList<Receipt>R){
        this.R=R;
    }
    public void finalizer(){
        count = count-1;
    }
    public int search(int Order_id){
        int ii = -1;
        for(int i = 0; i < R.size(); i++)
        {
            // Sale s = (Sale)S.get(i);
            if(R.get(i).getOrder_no() == Order_id)
            {
                ii = i;
                break;
                }   
                }
                // return -1;
                return ii;
    }
    //*********************************************************************************************************************************************************
    public void upload_Receipt_file(){ 
        try{
            String tokens[] = null;
            FileReader fr = new FileReader("receipt.txt");
            BufferedReader br = new BufferedReader(fr);
            String R_line = br.readLine();
            while(R_line !=  null){ 
              tokens = R_line.split(";");
              Receipt r = new Receipt(Integer.parseInt(tokens[0]),tokens [1],Integer.parseInt(tokens [2]),Double.parseDouble(tokens [3]));
              R.add(r);
              R_line = br.readLine();
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
    public void save_reciptfile(){
        try{
            FileWriter fw = new FileWriter("Receipt.txt");
            // BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(fw);
            for(int i=0;i<R.size();i++){

                Receipt  rr= (Receipt)R.get(i);
                pw.println(rr.getreceipt_no()+";"+rr.getreceipt_date()+";"+rr.getOrder_no()+";"+rr.getamount());
    }
    pw.flush();
    pw.close();
    fw.close();
}
catch(IOException i){
    JOptionPane.showMessageDialog(null, i);
    }
}
    // private int receipt_no;
    // private String receipt_date;
    // private int Order_no;
    // private double amount;
}
