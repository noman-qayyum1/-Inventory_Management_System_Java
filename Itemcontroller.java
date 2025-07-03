import java.util.ArrayList;
// import java.util.List; 
import java.io.*;
import javax.swing.*;

public class Itemcontroller {
    private ArrayList<item> it;
    static private int count;

    public Itemcontroller(){
        it = new ArrayList<item>();
        upload_itemfile();
    }
    public ArrayList<item> getitemobj(){
        return it;
    }
    public void setArrayitem(ArrayList<item>it){
        this.it=it;
    }
    public void finalizer(){
        count = count-1;
    }
//*********************************************************************************************************************************************************
    public void add_item(){
        /*item id
description
price
quantity
creation date*/
// JOptionPane.showInputDialog(null, "Enter item ID :  ");
int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter item ID :  "));
String desc = JOptionPane.showInputDialog(null, "Enter item description :  ");
double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter item price :  "));
int q = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter item quantity :  "));
String date = JOptionPane.showInputDialog(null, "Enter item creation date : dd/mm/yyyy ");
item i = new item(id, desc, price, q, date);
it.add(i);
    count= count+1;
        JOptionPane.showMessageDialog(null, "Item Added successfully Hurray!!!");
        }
//*********************************************************************************************************************************************************
    public void remove_item(){
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter item ID :  "));
        int i = search_item(id);
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Item not found");
        }
        else{
            item I = (item)it.get(i);
            String DATA = "item details \n";
            DATA = DATA + "item_Id = "+ I.getitemId()+"\n";
            DATA = DATA + "item_description = "+ I.getdescription()+"\n";
            DATA = DATA + "item_Price = "+ I.getprice()+"\n";
            DATA = DATA + "item_Quantity = "+ I.getquantity()+"\n";
            DATA = DATA + "item Creation date  = "+ I.getcreation_date()+"\n";
            String AK = JOptionPane.showInputDialog(null, DATA+"Do you want to Delete  Item \n Press y for YES or N for NO [y/n]  ");
            char b = AK.charAt(0);
            switch(b){
                case 'y':
                it.remove(i);
                JOptionPane.showMessageDialog(null, "**********Item DELETED**********");
                break;
                case 'n':
                JOptionPane.showMessageDialog(null,"**********item cannot deleted********");
                break;

            }
        }
    }
//*********************************************************************************************************************************************************
    public void update_item(){
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter item ID :  "));
        int i = search_item(id);
        if(i == -1){
            JOptionPane.showMessageDialog(null, "Item not found");
        }
        else{
            item I = (item)it.get(i);
            String DATA = "item details \n";
            DATA = DATA + "item_Id = "+ I.getitemId()+"\n";
            DATA = DATA + "item_description = "+ I.getdescription()+"\n";
            DATA = DATA + "item_Price = "+ I.getprice()+"\n";
            DATA = DATA + "item_Quantity = "+ I.getquantity()+"\n";
            DATA = DATA + "item Creation date  = "+ I.getcreation_date()+"\n";
        I.setitemId(Integer.parseInt(JOptionPane.showInputDialog(null,DATA+"\n please enter new Item ID ")));
        I.setdescription(JOptionPane.showInputDialog(null,DATA+"\n please enter new Item Description "));
        I.setprice(Double.parseDouble(JOptionPane.showInputDialog(null,DATA+"\n please enter new Item Price ")));
        I.setquantity(Integer.parseInt(JOptionPane.showInputDialog(null,DATA+"\n please enter new Item Quantity ")));
        I.setcreation_date((JOptionPane.showInputDialog(null,DATA+"\n please enter new Item creation date ")));
            JOptionPane.showMessageDialog(null, "Item Updated Successfully hurray !!!!!!");
        }      
    }
//*********************************************************************************************************************************************************
    public int search_item(int itemId){
        int i = 0;
        for(i = 0; i < it.size(); i++)
        {
            if(it.get(i).getitemId() == itemId){
                return i;
                }   
                }
                return -1;
    }
//*********************************************************************************************************************************************************
    public static int getCount() {
        return count;
    }
//*********************************************************************************************************************************************************
    void upload_itemfile(){ 
        try{
            String tokens[] = null;
            FileReader fr = new FileReader("Item.txt");
            BufferedReader br = new BufferedReader(fr);
            String I_line = br.readLine();
            while(I_line !=  null){ 
              tokens = I_line.split(";");
              item I = new item(Integer.parseInt(tokens[0]),tokens[1],Double.parseDouble(tokens[2]),Integer.parseInt(tokens[3]),tokens[4]);
              it.add(I);
              I_line = br.readLine();
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
    void save_itemfile(){
        try{ FileWriter fw = new FileWriter("Item.txt");
    PrintWriter pw = new PrintWriter(fw);
    for (int i=0;i<it.size();i++){
      item  I = (item)it.get(i);
      pw.println(I.getitemId()+";"+I.getdescription()+";"+I.getprice()+";"+I.getquantity()+";"+I.getcreation_date());

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
    void displayitem_menu(){
        int choice = 0;
        String display="***********ITEMS MENU************\n";
        display = display+"1. Add Item\n";
        display = display+"2. Delete Item\n";
        display = display+"3. Update Item\n";
        // display = display+"4. View Item\n";
        display = display+"4. View Item History\n";
        display = display+"5. Exit\n";
        display = display+"*******************************\n";
        do
        {
            String S =JOptionPane.showInputDialog(null, display);
            choice = Integer.parseInt(S);
            switch(choice){
                case 1:
                add_item();
                break;
                case 2:
                remove_item();
                break;
                case 3:
                update_item();
                break;
                case 4:
                int ik=Integer.parseInt(JOptionPane.showInputDialog(null, "enter Item ID")); 

                int a = search_item(ik);
                if(a==-1){
                    JOptionPane.showMessageDialog(null, "please Enter Valid ID");
                }
                    else{
                        item I= (item)it.get(a);
                        JOptionPane.showMessageDialog(null, "Item ID: "+I.getitemId()+"\nDescription: "+I.getdescription()+"\nPrice: "+I.getprice()+"\nQuantity: "+I.getquantity()+"\nCreation Date: "+I.getcreation_date());

                    }
                break;
                case 5:
                save_itemfile();
                break;
                
            }
      

        }while(choice != 5);
       
    }
//*********************************************************************************************************************************************************
}
        
