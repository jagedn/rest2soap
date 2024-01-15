package rest2soap;

import jakarta.inject.Singleton;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.dataaccess.www.webservicesserver.*;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.NamedValue;
import org.apache.axis2.databinding.types.UnsignedLong;
import org.oorsprong.www.websamples_countryinfo.*;
import static org.apache.axis2.transport.http.HTTPConstants.HTTP_HEADERS;

@Singleton
public class SoapService {

    private final NumberConversionNumberConversionSoapStub numberConversion;
    private final CountryInfoServiceCountryInfoServiceSoap countryInfoService;

    public SoapService() throws AxisFault {
        this.numberConversion = new NumberConversionNumberConversionSoapStub();
        this.countryInfoService = new CountryInfoServiceCountryInfoServiceSoapStub();
    }

    String numberToWords(BigInteger number) throws RemoteException {

        var header = new NamedValue("X-API-TOKEN","1234");
        var list = new ArrayList<NamedValue>();
        list.add(header);

        var service = numberConversion._getServiceClient();
        var options = service.getOptions();
        options.setProperty(HTTP_HEADERS, list);

        NumberToWords ntw = new NumberToWords();
        ntw.setUbiNum(new UnsignedLong(number));
        return numberConversion.numberToWords(ntw).getNumberToWordsResult();
    }

    String numberToDollars(BigDecimal number) throws RemoteException {
        NumberToDollars ntw = new NumberToDollars();
        ntw.setDNum(number);
        return numberConversion.numberToDollars(ntw).getNumberToDollarsResult();
    }

    List<String>getContinents() throws RemoteException {
        return Arrays.stream(countryInfoService
                .listOfContinentsByName(new ListOfContinentsByName())
                .getListOfContinentsByNameResult()
                .getTContinent())
                .toList()
                .stream().map(TContinent::getSName).collect(Collectors.toList());
    }

}
