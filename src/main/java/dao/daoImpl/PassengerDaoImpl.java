package dao.daoImpl;

import dao.DaoForAll;
import model.Passenger;
import service.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

public class PassengerDaoImpl implements DaoForAll<Passenger> {
    @Override
    public Passenger findByID(int id) {
        String query = "select * from passenger where ID_psg= " + id;
        Passenger pss = null;
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                pss = (new Passenger(res.getString("name_psg"), res.getString("phone")
                        , new AddressDaoImpl().findByID(res.getInt("ID_adrs"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pss;
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
        String query = "delete from passenger where ID_psg=" + id;
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Passenger passenger) {

        AddressDaoImpl addressDao=new AddressDaoImpl();
        int adrsID=addressDao.getID(passenger.getAddress().getCountry(),passenger.getAddress().getCity());
        if(adrsID==-1){
            addressDao.create(passenger.getAddress());
            adrsID=addressDao.getID(passenger.getAddress().getCountry(),passenger.getAddress().getCity());
        }
        String query = "update passenger set name_psg='" + passenger.getName()+"', phone='"+passenger.getPhone()+"',ID_adrs="+adrsID;
        try (Statement stmt = DatabaseConnection.getDbConnection().getConnection().createStatement()) {
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Passenger> findAll() {
        return null;
    }

    @Override
    public Set<Passenger> get(int offset, int perPage, String sort) {
        return null;
    }
}
