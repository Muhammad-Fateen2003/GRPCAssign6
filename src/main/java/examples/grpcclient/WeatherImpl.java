package examples.grpcclient;

import org.json.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import service.*;

public class WeatherImpl extends WeatherGrpc.WeatherImplBase{
  private String apiKey = "8247f8f2fe7ad8a3650cc448abc01666";  
  
  private void getWeatherAtCooridates(double lat, double lon, StreamObserver<WeatherResponse> responseObserver) {
      WeatherResponse.Builder responseBuilder = WeatherResponse.newBuilder();
      
      try {
          // Make API call to get weather data
          String apiUrl = "https://api.openweathermap.org/data/2.5/onecall?lat=" + lat + "&lon=" + lon + "&exclude=minutely,hourly,alerts&units=imperial&appid=" + apiKey;
          
          URL url = new URL(apiUrl);
          HttpURLConnection conn = (HttpURLConnection) url.openConnection();
          conn.setRequestMethod("GET");
          conn.setConnectTimeout(5000);
          conn.setReadTimeout(5000);
          
          int status = conn.getResponseCode();
          if (status == 200) {
              BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
              String inputLine;
              StringBuilder content = new StringBuilder();
              while ((inputLine = in.readLine()) != null) {
                  content.append(inputLine);
              }
              in.close();
              
              // Parse JSON data and set response fields
              JSONObject json = new JSONObject(content.toString());
              double currentTemp = json.getJSONObject("current").getDouble("temp");
              String currentConditions = json.getJSONObject("current").getJSONArray("weather").getJSONObject(0).getString("description");
              JSONArray dailyTemps = json.getJSONArray("daily");
              List<Double> dailyHighs = new ArrayList<Double>();
              for (int i = 0; i < dailyTemps.length(); i++) {
                  double dailyHigh = dailyTemps.getJSONObject(i).getJSONObject("temp").getDouble("max");
                  dailyHighs.add(dailyHigh);
              }
              
              responseBuilder.setIsSuccess(true);
              responseBuilder.setCurrentTemp(currentTemp);
              responseBuilder.setCurrentConditions(currentConditions);
              responseBuilder.addAllDailyHighs(dailyHighs);
              
          } else {
              responseBuilder.setIsSuccess(false);
              responseBuilder.setError("Failed to retrieve weather data: " + status);
          }
          
      } catch (Exception e) {
          responseBuilder.setIsSuccess(false);
          responseBuilder.setError("Failed to retrieve weather data: " + e.getMessage());
      }
      
      // Send response back to client
      responseObserver.onNext(responseBuilder.build());
      responseObserver.onCompleted();
  }

  //implement the services from weather.proto
  @Override
  public void atCoordinates(WeatherCoordinateRequest request, StreamObserver<WeatherResponse> responseObserver) {
    getWeatherAtCooridates (request.getLatitude(), request.getLongitude(), responseObserver);
  }  
 
  @Override
  public void inCity(WeatherCityRequest request, StreamObserver<WeatherResponse> responseObserver) {
      // Translate city name to coordinates
      Map<String, double[]> cityCoordinates = new HashMap<String, double[]>();
      cityCoordinates.put("San Francisco", new double[] {37.7749, -122.4194});
      cityCoordinates.put("New York", new double[] {40.7128, -74.0060});
      cityCoordinates.put("London", new double[] {51.5074, -0.1278});
      cityCoordinates.put("Paris", new double[] {48.8566, 2.3522});
      cityCoordinates.put("Tokyo", new double[] {35.6895, 139.6917});
      cityCoordinates.put("Hong Kong", new double[] {22.3964, 114.1095});
      cityCoordinates.put("Sydney", new double[] {-33.8688, 151.2093});
      cityCoordinates.put("Melbourne", new double[] {-37.8136, 144.9631});
      cityCoordinates.put("Vancouver", new double[] {49.2827, -123.1207});
      cityCoordinates.put("Houston", new double[] {29.7604, -95.3698});
      cityCoordinates.put("Chicago", new double[] {41.8781, -87.6298});
      cityCoordinates.put("Phoenix", new double[] {33.4484, -112.0740});
      cityCoordinates.put("Mecca", new double[] {21.3891, 39.8579});
      cityCoordinates.put("Madinah", new double[] {24.5247, 39.5692});

      if (!cityCoordinates.containsKey(request.getCityName())) {
        WeatherResponse.Builder responseBuilder = WeatherResponse.newBuilder();
        responseBuilder.setIsSuccess(false);
        responseBuilder.setError("Error: City Unavailable");
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
      } else {

        double[] coordinates = cityCoordinates.get(request.getCityName());
        if (coordinates == null) {
            throw new IllegalArgumentException("Invalid city name: " + request.getCityName());
        }

        getWeatherAtCooridates(coordinates[0], coordinates[1], responseObserver);
    }      
  }
  
  @Override
  public void listCities(Empty request, StreamObserver<CitiesResponse> responseObserver) {
      // Cities: San Francisco, New York, London, Paris, Tokyo, Hong Kong, Sydney, Melbourne, Vancouver, Houston, Chicago, Phoenix, Mecca, Madinah
      List<String> cities = new ArrayList<>();
      cities.add("San Francisco");
      cities.add("New York");
      cities.add("London");
      cities.add("Paris");
      cities.add("Tokyo");
      cities.add("Hong Kong");
      cities.add("Sydney");
      cities.add("Melbourne");
      cities.add("Vancouver");
      cities.add("Houston");
      cities.add("Chicago");
      cities.add("Phoenix");
      cities.add("Mecca");
      cities.add("Madinah");

      CitiesResponse.Builder responseBuilder = CitiesResponse.newBuilder();
      try {
          responseBuilder.setIsSuccess(true);
          responseBuilder.addAllCityName(cities);

      } catch (Exception e) {
          responseBuilder.setIsSuccess(false);
          responseBuilder.setError("Failed to retrieve City List: " + e.getMessage());
      }

      responseObserver.onNext(responseBuilder.build());
      responseObserver.onCompleted();      
  }

/*
  public static void main(String[] args) throws Exception {
    WeatherImpl weatherImpl = new WeatherImpl();
    WeatherResponse response = weatherImpl.atCoordinates(WeatherCoordinateRequest.newBuilder().setLatitude(37.7749).setLongitude(-122.4194).build());
    System.out.println(response);
  }
*/
}
