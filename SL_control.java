import java.util.ArrayList; 
import java.io.*;
import javax.swing.*;
public class SL_control {
    private ArrayList<SaleLineItem> SL;
    static private int count;
    public SL_control(){
        SL = new ArrayList<SaleLineItem>();
        upload_saleline_file();
    }
    static public int getcount(){
        return count;
    }
    public ArrayList<SaleLineItem> getSalelineobj(){
        return SL;
    
}
public void setArraysaleline(ArrayList<SaleLineItem> SL){
    this.SL = SL;
}
public void finalizer(){
    count = count-1;
}
public int search(int Order_id){
    int ii = -1;
    for(int i = 0; i < SL.size(); i++)
    {
        // Sale s = (Sale)S.get(i);
        if(SL.get(i).getOrder_id() == Order_id)
        {
            ii = i;
            break;
            }   
            }
            // return -1;
            return ii;
}
//*********************************************************************************************************************************************************
public void upload_saleline_file(){ 
    try{
        String tokens[] = null;
        FileReader fr = new FileReader("Saleline.txt");
        BufferedReader br = new BufferedReader(fr);
        String S_line = br.readLine();
        while(S_line !=  null){ 
          tokens = S_line.split(";");
          SaleLineItem sitem = new SaleLineItem(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),Double.parseDouble(tokens[4]));
          SL.add(sitem);
          S_line = br.readLine();
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
public void save_SeleLinefile(){
    try{
        FileWriter fw = new FileWriter("Salesline.txt");
        // BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(fw);
        for(int i=0;i<SL.size();i++){

            SaleLineItem  s= (SaleLineItem)SL.get(i);
            pw.println(s.getline_no()+";"+s.getOrder_id()+";"+s.getitemId()+";"+s.getquantity()+";"+s.getamount());
}
pw.flush();
pw.close();
fw.close();
}
catch(IOException i){
JOptionPane.showMessageDialog(null, i);
}
}
}
// private int line_no;
// private int Order_id;
// private int item_id;
// private int quantity;
// private double amount;