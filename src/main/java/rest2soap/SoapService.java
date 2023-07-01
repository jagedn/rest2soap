package rest2soap;

import com.dataaccess.webservicesserver.NumberConversion;
import jakarta.inject.Singleton;

import java.math.BigDecimal;
import java.math.BigInteger;

@Singleton
public class SoapService {

    private final NumberConversion numberConversion;

    public SoapService() {
        this.numberConversion = new NumberConversion();
    }

    String numberToWords(BigInteger number){
        return numberConversion.getNumberConversionSoap().numberToWords(number);
    }

    String numberToDollars(BigDecimal number){
        return numberConversion.getNumberConversionSoap().numberToDollars(number);
    }

}
