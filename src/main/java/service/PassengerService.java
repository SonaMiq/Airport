package service;

import dao.PassengerDaoImpl;
import model.Address;
import model.Passenger;

public class PassengerService {
  private   PassengerDaoImpl passengerDao=new PassengerDaoImpl();
    public void create(String name, String phone, String country,String city){
         passengerDao.create(new Passenger(name,phone,new Address(country,city)));
    }
}
