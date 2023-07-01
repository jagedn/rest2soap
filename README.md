## Micronaut Soap2Rest

a Micronaut template to proxy Soap calls as Rest

## build

`./gradlew build`

## run

`-/gradlew run`

## test

`localhost:8080/numberToDollars/12312.12`

## Customize

Use your own WSDL 


```.build.gradle
...
(line 57) def WSDL_URL = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso?WSDL"

```