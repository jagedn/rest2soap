package rest2soap;

import com.dataaccess.webservicesserver.NumberConversion;
import jakarta.inject.Singleton;
import org.oorsprong.websamples.CountryInfoService;
import org.oorsprong.websamples.ListOfContinentsByName;
import org.oorsprong.websamples.TContinent;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class SoapService {

    private final NumberConversion numberConversion;
    private final CountryInfoService countryInfoService;

    public SoapService() {
        this.numberConversion = new NumberConversion();
        this.countryInfoService = new CountryInfoService();
    }

    String numberToWords(BigInteger number){
        return numberConversion.getNumberConversionSoap().numberToWords(number);
    }

    String numberToDollars(BigDecimal number){
        return numberConversion.getNumberConversionSoap().numberToDollars(number);
    }

    List<String>getContinents(){
        return countryInfoService.getCountryInfoServiceSoap()
                .listOfContinentsByName()
                .getTContinent().stream().map(TContinent::getSName).collect(Collectors.toList());
    }

}
