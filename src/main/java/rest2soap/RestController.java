package rest2soap;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.List;

@Controller
public class RestController {

    private final SoapService soapService;

    public RestController(SoapService soapService) {
        this.soapService = soapService;
    }

    @Get("/numberToWords/{number}")
    String numberToWords(BigInteger number) throws RemoteException {
        return soapService.numberToWords(number);
    }

    @Get("/numberToDollars/{number}")
    String numberToDollars(BigDecimal number) throws RemoteException {
        return soapService.numberToDollars(number);
    }

    @Get("/continents")
    List<String>getContinents() throws RemoteException {
        return soapService.getContinents();
    }
}
