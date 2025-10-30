import entity.Customer;
import service.BillingService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        BillingService service = new BillingService();
        while(true){
            System.out.println("1. Add Customer \n2. Generate Invoice \n3. Show Invoice \nEXIT");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Customer name: ");
                    String name = sc.next();
                    System.out.println("phone : ");
                    String phone = sc.next();
                    service.customerService.addCustomer(new Customer(0,name,phone));
                    break;
                case 2:
                    System.out.println("Enter customer ID: ");
                    int cid = sc.nextInt();
                    System.out.println("Enter vehicle ID: ");
                    int vid = sc.nextInt();
                    System.out.println("Enter number of services: ");
                    int n = sc.nextInt();
                    List<Integer> list = new ArrayList<>();
                    for(int i=0;i<n;i++){
                        System.out.println("Enter the service ID: ");
                        list.add(sc.nextInt());
                    }
                    service.createInvoice(cid,vid,list);
                    break;
                case 3:
                    service.showAllInvoices();
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Not Valid");
            }

        }
    }
}