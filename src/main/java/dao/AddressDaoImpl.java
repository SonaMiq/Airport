package dao;

import model.Address;
import service.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class AddressDaoImpl implements DaoForAll<Address>{
    @Override
    public Address findByID(int id) {
        return null;
    }

    @Override
    public void create(Address address) {
        String query = "Insert into address(country,city) values('"+address.getCountry()+"','"+address.getCity()+"');";
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            stmt.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getID(String country,String city){
        int id=-1;
        String query = "Select ID_adrs from address where country='"+country+"'and city='"+city+"'";
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            ResultSet res=stmt.executeQuery(query);
            if(res.next()) {
                id = res.getInt("ID_adrs");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(int id, Address address) {

    }

    @Override
    public Set<Address> findAll() {
        return null;
    }
}
