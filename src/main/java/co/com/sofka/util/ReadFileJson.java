package co.com.sofka.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import static co.com.sofka.util.LoginKey.*;


public class ReadFileJson {
    private static String Entrada;
    private static String Entrada2;
    private static String FullJson;
    private static Object JsonObjc;
    private static JSONObject JsonObjc2;
    private static String SaveEmail;
    private static String SavePassword;

    //Contructor
    public ReadFileJson(String Entrada, String Entrada2) {
        this.Entrada = Entrada;
        this.Entrada2 = Entrada2;
    }

    public ReadFileJson(String Entrada) {
        this.Entrada = Entrada;
    }


    public static String Convert() throws IOException, ParseException {
        JsonObjc = new JSONParser().parse(new FileReader("src/test/resources/files/login2.json"));
        JsonObjc2 = (JSONObject) JsonObjc;
        FullJson = JSONObject.toJSONString(JsonObjc2);
        SaveEmail = FullJson.replace(EMAIL.getValue(), Entrada);
        SavePassword = SaveEmail.replace(PASSWORD.getValue(), "");
        return SavePassword;
    }
    public static String Convert2() throws IOException, ParseException {
        JsonObjc = new JSONParser().parse(new FileReader("src/test/resources/files/login.json"));
        JsonObjc2 = (JSONObject) JsonObjc;
        FullJson = JSONObject.toJSONString(JsonObjc2);
        SaveEmail = FullJson.replace(NAME.getValue(), Entrada);
        SavePassword = SaveEmail.replace(JOB.getValue(), Entrada2);
        return SavePassword;
    }

}
