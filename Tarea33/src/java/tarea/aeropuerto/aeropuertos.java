/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea.aeropuerto;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 *
 * @author dfleider
 */
@WebService(serviceName = "aeropuertos")
public class aeropuertos {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "aeropuertoYciudades")
    public String[] obtenerAeropuertos(@WebParam(name = "pais") String pais) {
        Airport air = new Airport();
        AirportSoap airsoap = air.getAirportSoap();
        GlobalWeather gw = new GlobalWeather();
        GlobalWeatherSoap gwSoap = gw.getGlobalWeatherSoap();
        String airports = airsoap.getAirportInformationByCountry(pais);
        String cities = gwSoap.getCitiesByCountry(pais);
        String[] result = new String[2];
        result[0]=cities;
        result[1]=airports;
        
        return result;
    }
}
