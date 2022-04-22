package service;

import dao.daoImpl.PassengerDaoImpl;
import model.Address;
import model.Passenger;

public class PassengerService {
  private   PassengerDaoImpl passengerDao=new PassengerDaoImpl();
    public void create(String name, String phone, String country,String city){
         passengerDao.create(new Passenger(name,phone,new Address(country,city)));
    }
    public Passenger findId(int id) {
        return passengerDao.findByID(id);
    }
    public void delete(int id){
        passengerDao.deleteById(id);
    }

    public void update(int id,String newName,String newPhone,String newCountry,String newCity){
        passengerDao.update(id,new Passenger(newName,newPhone,new Address(newCountry,newCity)));
    }
}
