package service;

import model.Address;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;


public class AddInformation {


    public static void addCompaniesInfo() {
        String file = "src/main/resources/companies.txt";
        CompanyService companyService = new CompanyService();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String s = bufferedReader.readLine();
            String[] rslt = new String[2];
            String[] dt = new String[3];

            while (true) {
                s = bufferedReader.readLine();
                if (s == null)
                    break;
                rslt = s.split(",");
                dt = rslt[1].split("/");
                companyService.create(rslt[0], dt[2] + "-" + dt[0] + "-" + dt[1]);

            }

        } catch (IOException e) {
            System.out.println("companies.txt file for read is not found");
        }

    }

    public static void addAddressInfo() {
        AddressService addressService=new AddressService();
        String file = "src/main/resources/passengers.txt";
        Set<Address> countryCity = new HashSet<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String[] rslt = new String[4];
            String s = bufferedReader.readLine();
            while (true) {
                s = bufferedReader.readLine();
                if (s == null)
                    break;
                rslt = s.split(",");
                countryCity.add(new Address(rslt[2],rslt[3]));
            }
            for (Address address:countryCity) {
                 addressService.create(address.getCountry(),address.getCity());
            }
        } catch (IOException e) {
            System.out.println("passengers.txt file for read is not found");
        }
    }
    public static void addPassengersInfo() {
        PassengerService passengerService=new PassengerService();
        String file = "src/main/resources/passengers.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String[] rslt = new String[4];
            String s = bufferedReader.readLine();
            while (true) {
                s = bufferedReader.readLine();

                if (s == null)
                    break;
                if(s.contains("'")){
                    s=s.replace("'","՛");
                }
                rslt = s.split(",");
                passengerService.create(rslt[0],rslt[1],rslt[2],rslt[3]);
            }
        } catch (IOException e) {
            System.out.println("passengers.txt file for read is not found");
        }
    }
}
