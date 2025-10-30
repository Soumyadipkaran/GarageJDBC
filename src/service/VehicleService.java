package service;

import config.DbConfig;
import entity.Customer;
import entity.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {
    public void addVehicle(Vehicle vehicle) throws SQLException {
        Connection conn = DbConfig.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO vehicles(customer_id,number_plate,model) VALUE (?,?,?)");
        ps.setInt(1,vehicle.getCustomerId());
        ps.setString(2,vehicle.getNumberPlate());
        ps.setString(3,vehicle.getModel());

        ps.executeUpdate();
        ps.close();
        conn.close();
    }
    public List<Vehicle> getAllVehicles() throws  SQLException{
        List<Vehicle> list = new ArrayList<>();
        Connection conn = DbConfig.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from vehicles");

        while(rs.next()){
            list.add(new Vehicle
                    (rs.getInt("id"), rs.getInt("customer_id"),rs.getString("number_plate"),rs.getString("model")));
        }
        return list;
    }

}
