package rest2soap;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.math.BigDecimal;
import java.math.BigInteger;

@Controller
public class RestController {

    private final SoapService soapService;

    public RestController(SoapService soapService) {
        this.soapService = soapService;
    }

    @Get("/numberToWords/{number}")
    String numberToWords(BigInteger number){
        return soapService.numberToWords(number);
    }

    @Get("/numberToDollars/{number}")
    String numberToDollars(BigDecimal number){
        return soapService.numberToDollars(number);
    }
}
