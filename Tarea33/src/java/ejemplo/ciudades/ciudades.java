/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.ciudades;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 *
 * @author dfleider
 */
@WebService(serviceName = "ciudades")
public class ciudades {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "obtenerCiudades")
    public String ciudad(@WebParam(name = "pais") String pais) {
        GlobalWeather gw = new GlobalWeather();
        
        GlobalWeatherSoap gwSoap = gw.getGlobalWeatherSoap();
        
        String cities = gwSoap.getCitiesByCountry(pais);
        
        return cities;
    }
}
