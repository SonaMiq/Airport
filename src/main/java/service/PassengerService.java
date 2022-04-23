package service;

import dao.PassInTripDao;
import dao.daoImpl.PassengerDaoImpl;
import model.Address;
import model.Passenger;
import model.Trip;

public class PassengerService {
    private PassengerDaoImpl passengerDao = new PassengerDaoImpl();
    private PassInTripDao passInTripDao = new PassInTripDao();

    public void create(String name, String phone, String country, String city) {
        passengerDao.create(new Passenger(name, phone, new Address(country, city)));
    }

    public Passenger findId(int id) {
        return passengerDao.findByID(id);
    }

    public void delete(int id) {
        passengerDao.deleteById(id);
    }

    public void update(int id, String newName, String newPhone, String newCountry, String newCity) {
        passengerDao.update(id, new Passenger(newName, newPhone, new Address(newCountry, newCity)));
    }

    void registerTrip(int trip_no, int ID_psg, String place) {
        passInTripDao.create(trip_no,ID_psg,place);
    }

    void cancelTrip(int ID_psg, int trip_no){
        passInTripDao.delete(ID_psg,trip_no);
    }

}
