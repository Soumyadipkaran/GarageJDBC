package service;

import config.DbConfig;
import entity.Invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceService {

    // Add new invoice
    public void addInvoice(Invoice invoice) throws SQLException {
        Connection conn = DbConfig.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO invoice (customer_id, vehicle_id, service_id) VALUES (?, ?, ?)"
        );
        ps.setInt(1, invoice.getCustomerId());
        ps.setInt(2, invoice.getVehicleId());
        ps.setInt(3, invoice.getServiceId());


        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    // Get all invoices
    public List<Invoice> getAllInvoices() throws SQLException {
        List<Invoice> list = new ArrayList<>();
        Connection conn = DbConfig.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM invoice");

        while (rs.next()) {
            list.add(new Invoice(
                    rs.getInt("id"),
                    rs.getInt("customer_id"),
                    rs.getInt("vehicle_id"),
                    rs.getInt("service_id")
            ));
        }

        rs.close();
        st.close();
        conn.close();
        return list;
    }
}
