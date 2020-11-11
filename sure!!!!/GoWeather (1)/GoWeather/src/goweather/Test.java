/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goweather;


public class Test
{

	public static void main(String[] args)
	{
		WeatherAPIconditions weathera = new WeatherAPIconditions("44418","<yweather:atmosphere");
                
                //System.out.println(weathera.theWeatherRSS);
               
                
                WeatherAPIconditions weather = new WeatherAPIconditions("44418","<yweather:astronomy");
                //WeatherAPIconditions weatherc = new WeatherAPIconditions("44418","<yweather:atmosphere");
               // WeatherAPIconditions weatherd = new WeatherAPIconditions("44418","<yweather:wind");
                
		//System.out.println(weather.theWeatherRSS);
            
                    
                       System.out.println(weather.weatherForecastList.get(0).setsun+" "+ weathera.weatherForecastList.get(0).humid);
                
		//for(int i = 0; i < weather.weatherForecastList.size(); i++)
		//{
			//System.out.println(weather.weatherForecastList.get(i).lowTemp + " " +
			//weather.weatherForecastList.get(i).highTemp +" "+ weather.weatherForecastList.get(i).conditionss);
                       //System.out.println(weathera.weatherForecastList.get(i).humid);
                         //System.out.println(weather.weatherForecastList.get(i).setsun);
                        //System.out.println(weatherc.weatherForecastList.get(i).visible);
                        //System.out.println(weatherd.weatherForecastList.get(i).windspeed);
                          
		//}
             
                
	
	}
}
