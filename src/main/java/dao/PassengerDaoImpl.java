package dao;

import model.Passenger;
import service.DatabaseConnection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class PassengerDaoImpl implements DaoForAll<Passenger> {
    @Override
    public Passenger findByID(int id) {
        return null;
    }

    @Override
    public void create(Passenger passenger) {
        AddressDaoImpl addressDao=new AddressDaoImpl();
      int adrsID=addressDao.getID(passenger.getAddress().getCountry(),passenger.getAddress().getCity());
      if(adrsID==-1){
          addressDao.create(passenger.getAddress());
          adrsID=addressDao.getID(passenger.getAddress().getCountry(),passenger.getAddress().getCity());
      }

        String query = "Insert into passenger(name_psg,phone,ID_adrs) values('"+passenger.getName()+"','"+passenger.getPhone()+"','"+adrsID+"');";
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            stmt.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(int id, Passenger passenger) {

    }

    @Override
    public Set<Passenger> findAll() {
        return null;
    }
}
