package service;

import dao.AddressDaoImpl;
import model.Address;

public class AddressService {
   private AddressDaoImpl addressDao=new AddressDaoImpl();
    public void create(String country,String city){
        addressDao.create(new Address(country,city));
    }
}
