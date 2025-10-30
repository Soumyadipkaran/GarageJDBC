import entity.Customer;
import entity.Vehicle;
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
            System.out.println("1. Add Customer \n2. Add Vehicles \n3. Generate Invoice \n4. Show Invoice \n5. EXIT");
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
                    System.out.println("<---Adding Vehicles--->");
                    System.out.println("Customer_id: ");
                    String cs = sc.next();
                    int csid = Integer.parseInt(cs);
                    System.out.println("Number_Plate: ");
                    String np = sc.next();
                    System.out.println("Model: ");
                    String md = sc.next();
                    service.vehicleService.addVehicle(new Vehicle(0,csid,np, md));
                    break;
                case 3:
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
                case 4:
                    service.showAllInvoices();
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Not Valid");
            }

        }
    }
}