import java.util.ArrayList;
import java.io.*;
import javax.swing.*;
public class S_control {
    private ArrayList<Sale> S;
    static private int count;
    public S_control()
    {
        S =  new ArrayList<Sale>();
        upload_salefile();
    }
    static public int getcount(){
        return count;
    }
    public ArrayList<Sale> getSaleobj(){
        return S;
    }
    public void setArraysale(ArrayList<Sale> S){
        this.S = S;
    }
    public void finalizer(){
        count = count-1;
    }
    public int Search(int Order_id){
        int ii = -1;
        JOptionPane.showMessageDialog(null,  "ok");
        for(int i = 0; i <= S.size(); i++)
        {
            JOptionPane.showMessageDialog(null,  i);
             Sale s = (Sale)S.get(i);
             int id =s.getOrder_id();
            if(id == Order_id)
            {JOptionPane.showMessageDialog(null,  "ok");
                ii = i;
                break;
                }   
                }
                // return -1;
                return ii;
    }

    //*********************************************************************************************************************************************************
    void upload_salefile(){ 
        try{
            String tokens[] = null;
            FileReader fr = new FileReader("Sales.txt");
            BufferedReader br = new BufferedReader(fr);
            String S_line = br.readLine();
            while(S_line !=  null){ 
              tokens = S_line.split(";");
              Sale sitem = new Sale(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),tokens [2],tokens[3]);
              S.add(sitem);
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
    public void save_salefile(){
        try{
            FileWriter fw = new FileWriter("Sales.txt");
            // BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(fw);
            for(int i=0;i<S.size();i++){

                Sale  SL= (Sale)S.get(i);
                pw.println(SL.getOrder_id()+";"+SL.getC_id()+";"+SL.getdate()+";"+SL.getstatus());
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
// private int Order_id;
// private int C_id;
// private String date;
// private String status;