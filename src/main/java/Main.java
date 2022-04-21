import model.Company;
import service.AddInformation;
import service.AddressService;
import service.CompanyService;
import service.PassengerService;


public class Main {
    public static void main(String[] args) {
        new PassengerService().create("Sona Mikayelyan", "374-91106344", "Armenia", "Metsavan");
    }
}
