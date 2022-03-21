package co.com.sofka.model;
import com.github.javafaker.Faker;

public class DatosModel {

    //Datos Random
    Faker DatosRandom = new Faker();
    String FirstName = DatosRandom.name().firstName();
    String LastName = DatosRandom.name().lastName();
    String FullName = FirstName +" "+ LastName;
    String employ = DatosRandom.job().field();
    String Email =  FirstName +"."+ employ + "@outlook.com";

    private String USERNAME;
    private String EMPLOY;

    private String EMAIL;
    private String PASSWORD;

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL( ) {
        this.EMAIL =  Email;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME() {
        this.USERNAME = FullName;
    }

    public String getEMPLOY() {
        return EMPLOY;
    }

    public void setEMPLOY() {
        this.EMPLOY = employ;
    }


}
