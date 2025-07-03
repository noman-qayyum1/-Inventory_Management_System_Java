import javax.swing.JOptionPane;

public class MAINcontroller {
    public static void main(String[] args) {
         Itemcontroller itemC = new Itemcontroller();
        C_controller customC = new C_controller();
         Payment pay = new Payment();
        MakeNewSalee mns = new MakeNewSalee();
        Showreport sr = new Showreport();
        String h = "Main Menu\n\n\n\n\n 1-	Manage Items  \n 2-	Manage Customers \n 3-	Make New Sale \n 4-	Make Payment \n 5-	Print Reports \n 6-	Exit \n\n Press 1 to 5 to select an option:";
        int option = 0;
        do{
            option = Integer.parseInt(JOptionPane.showInputDialog(null, h));
            switch(option){
                case 1:
                itemC.displayitem_menu();
                break;
                case 2:
                customC.displayCustomer_menu();
                break;
                case 3:
                mns.makesale();
                break;
                case 4:
                pay.addpayment();
                break;
                case 5:
                sr.showreportmenu();
                break;
                case 6:
                System.exit(0);
                break;
            }
        }while(option != 6);

    }
    
}
