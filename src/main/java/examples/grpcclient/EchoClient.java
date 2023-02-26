package examples.grpcclient;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import service.*;
import examples.TestProtobuf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.google.protobuf.Empty; // needed to use Empty

// just to show how to use the empty in the protobuf protocol
    // Empty empt = Empty.newBuilder().build();

/**
 * Client that requests `parrot` method from the `EchoServer`.
 */
public class EchoClient {
  private final EchoGrpc.EchoBlockingStub blockingStub;
  private final JokeGrpc.JokeBlockingStub blockingStub2;
  private final RegistryGrpc.RegistryBlockingStub blockingStub3;
  private final WeatherGrpc.WeatherBlockingStub blockingStub4;
  private final HometownsGrpc.HometownsBlockingStub blockingStub5;

  /** Construct client for accessing server using the existing channel. */
  public EchoClient(Channel channel, Channel regChannel) {
    // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's
    // responsibility to
    // shut it down.

    // Passing Channels to code makes code easier to test and makes it easier to
    // reuse Channels.
    blockingStub = EchoGrpc.newBlockingStub(channel);
    blockingStub2 = JokeGrpc.newBlockingStub(channel);
    blockingStub3 = RegistryGrpc.newBlockingStub(regChannel);
    blockingStub4 = WeatherGrpc.newBlockingStub(channel);
    blockingStub5 = HometownsGrpc.newBlockingStub(channel);
  }

  public void askServerToParrot(String message) {
    ClientRequest request = ClientRequest.newBuilder().setMessage(message).build();
    ServerResponse response;
    try {
      response = blockingStub.parrot(request);
    } catch (Exception e) {
      System.err.println("RPC failed: " + e.getMessage());
      return;
    }
    System.out.println("Received from server: " + response.getMessage());
  }

  public void askForJokes(int num) {
    JokeReq request = JokeReq.newBuilder().setNumber(num).build();
    JokeRes response;


    try {
      response = blockingStub2.getJoke(request);
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
    System.out.println("Your jokes: ");
    for (String joke : response.getJokeList()) {
      System.out.println("--- " + joke);
    }
  }

  public void setJoke(String joke) {
    JokeSetReq request = JokeSetReq.newBuilder().setJoke(joke).build();
    JokeSetRes response;

    try {
      response = blockingStub2.setJoke(request);
      System.out.println(response.getOk());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public void getWeatherAtCooridates(double lat, double lon) {
    WeatherCoordinateRequest request = WeatherCoordinateRequest.newBuilder()
    .setLatitude(lat)
    .setLongitude(lon)
    .build();
    WeatherResponse response;

    try {
      response = blockingStub4.atCoordinates(request);
      System.out.println(response.getCurrentTemp());
      System.out.println(response.getCurrentConditions());
      for (double dailyHigh : response.getDailyHighsList()) {
        System.out.println(dailyHigh);
      }
    } catch (Exception e) {
      // TODO: handle exception
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public void getWeatherInCity(String city) {
    WeatherCityRequest request = WeatherCityRequest.newBuilder()
    .setCityName(city)
    .build();
    WeatherResponse response;
    try {
      response = blockingStub4.inCity(request);
      System.out.println(response.getCurrentTemp());
      System.out.println(response.getCurrentConditions());
      for (double dailyHigh : response.getDailyHighsList()) {
        System.out.println(dailyHigh);
      }
    } catch (Exception e) {
      // TODO: handle exception
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public void getCityList() {
    Empty empty = Empty.newBuilder().build();
    CitiesResponse response;
    try {
      response = blockingStub4.listCities(empty);
      System.out.println("Available Cities: ");
      for (String city : response.getCityNameList()) {
        System.out.println(city);        
      }
    } catch (Exception e) {
      // TODO: handle exception
      System.err.println("RPC failed: " + e);
      return;
    }

  }

  public void readHomeTowns() {
    Empty empty = Empty.newBuilder().build();
    HometownsReadResponse response;
    try {
      response = blockingStub5.read(empty);
      System.out.println("Name\t City\t Region\t");
      for (Hometown hometown : response.getHometownsList()) {
        System.out.println(hometown.getName() + "\t " + hometown.getCity() + "\t " + hometown.getRegion());
      }
    } catch (Exception e) {
      // TODO: handle exception
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public void writeHomeTowns(String name, String city, String region) {
    HometownsWriteRequest request = HometownsWriteRequest.newBuilder().setHometown(Hometown
    .newBuilder().setName(name)
    .setCity(city).setRegion(region)
    .build()).build();
    HometownsWriteResponse response;
    try {
      response = blockingStub5.write(request);
      if (response.getIsSuccess()) {
        System.out.println("Success!");
      } else {
        System.out.println("Error!");
      }
    } catch (Exception e) {
      // TODO: handle exception
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public void searchHomeTowns(String city) {
    HometownsSearchRequest request = HometownsSearchRequest.newBuilder()
    .setCity(city).build();
    HometownsReadResponse response;
    try {
      response = blockingStub5.search(request);
      for (Hometown hometown : response.getHometownsList()) {
        System.out.println(hometown.getName() + "\t " + hometown.getCity() + "\t " + hometown.getRegion());
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  public void getServices() {
    GetServicesReq request = GetServicesReq.newBuilder().build();
    ServicesListRes response;
    try {
      response = blockingStub3.getServices(request);
      System.out.println(response.toString());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public void findServer(String name) {
    FindServerReq request = FindServerReq.newBuilder().setServiceName(name).build();
    SingleServerRes response;
    try {
      response = blockingStub3.findServer(request);
      System.out.println(response.toString());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public void findServers(String name) {
    FindServersReq request = FindServersReq.newBuilder().setServiceName(name).build();
    ServerListRes response;
    try {
      response = blockingStub3.findServers(request);
      System.out.println(response.toString());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public static void printMenu() {
    System.out.println("Choose Which Service you want to run:");
    System.out.println("1. Weather/listCities");
    System.out.println("2. Weather/inCity");
    System.out.println("3. Weather/atCoordinates");
    System.out.println("4. Hometowns/search");
    System.out.println("5. Hometowns/read");
    System.out.println("6. Hometowns/write");
    System.out.println("0. Exit");
  }



  public static void main(String[] args) throws Exception {
    if (args.length != 6) {
      System.out
          .println("Expected arguments: <host(String)> <port(int)> <regHost(string)> <regPort(int)> <message(String)> <regOn(bool)>");
      System.exit(1);
    }
    int port = 9099;
    int regPort = 9003;
    String host = args[0];
    String regHost = args[2];
    String message = args[4];
    try {
      port = Integer.parseInt(args[1]);
      regPort = Integer.parseInt(args[3]);
    } catch (NumberFormatException nfe) {
      System.out.println("[Port] must be an integer");
      System.exit(2);
    }

    // Create a communication channel to the server, known as a Channel. Channels
    // are thread-safe
    // and reusable. It is common to create channels at the beginning of your
    // application and reuse
    // them until the application shuts down.
    String target = host + ":" + port;
    ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS
        // to avoid
        // needing certificates.
        .usePlaintext().build();

    String regTarget = regHost + ":" + regPort;
    ManagedChannel regChannel = ManagedChannelBuilder.forTarget(regTarget).usePlaintext().build();
    try {

      // ##############################################################################
      // ## Assume we know the port here from the service node it is basically set through Gradle
      // here.
      // In your version you should first contact the registry to check which services
      // are available and what the port
      // etc is.

      /**
       * Your client should start off with 
       * 1. contacting the Registry to check for the available services
       * 2. List the services in the terminal and the client can
       *    choose one (preferably through numbering) 
       * 3. Based on what the client chooses
       *    the terminal should ask for input, eg. a new sentence, a sorting array or
       *    whatever the request needs 
       * 4. The request should be sent to one of the
       *    available services (client should call the registry again and ask for a
       *    Server providing the chosen service) should send the request to this service and
       *    return the response in a good way to the client
       * 
       * You should make sure your client does not crash in case the service node
       * crashes or went offline.
       */

      // Just doing some hard coded calls to the service node without using the
      // registry
      // create client
      EchoClient client = new EchoClient(channel, regChannel);

      // call the parrot service on the server
      client.askServerToParrot(message);
      boolean quit = false;
      while(!quit){
        printMenu();
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int key = scanner.nextInt();
        switch (key) {
          case 1:
            client.getCityList();
            break;
          case 2:
            System.out.println("Enter City Name: ");
            String city = scanner.next();
            client.getWeatherInCity(city);
            break;
          case 3:
            System.out.println("Enter Latitude: ");
            double lat = scanner.nextDouble();
            System.out.println("Enter Longitude: ");
            double lon = scanner.nextDouble();
            client.getWeatherAtCooridates(lat, lon);          
            break;
          case 4:
            System.out.println("Enter your name: ");
            String name = scanner.next();
            System.out.println("Enter the name of your city: ");
            String cityName = scanner.next();
            System.out.println("Enter the name of your region: ");
            String region = scanner.next();
            client.writeHomeTowns(name, cityName, region);
            break;
          case 5:
            client.readHomeTowns();
            break;
          case 6:
            System.out.println("Enter the name of a city: ");
            String cityString = scanner.next();
            client.searchHomeTowns(cityString);
            break;
          case 0:
            quit = true;
            break;
          default:
            break;
        }
    }



      // client.getWeatherAtCooridates(33.4484, -112.0740);

      // client.getWeatherInCity("Mecca");

      // client.writeHomeTowns("Muhammad", "TX", "SOUTH");
      // client.writeHomeTowns("Zaynab", "NY", "NORTH");
      // client.readHomeTowns();
      // client.searchHomeTowns("NY");

      // ask the user for input how many jokes the user wants
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

      // Reading data using readLine
      System.out.println("How many jokes would you like?"); // NO ERROR handling of wrong input here.
      String num = reader.readLine();

      // calling the joked service from the server with num from user input
      client.askForJokes(Integer.valueOf(num));

      // adding a joke to the server
      client.setJoke("I made a pencil with two erasers. It was pointless.");

      // showing 6 joked
      client.askForJokes(Integer.valueOf(6));

      // ############### Contacting the registry just so you see how it can be done

      if (args[5].equals("true")) { 
        // Comment these last Service calls while in Activity 1 Task 1, they are not needed and wil throw issues without the Registry running
        // get thread's services
        client.getServices(); // get all registered services 

        // get parrot
        client.findServer("services.Echo/parrot"); // get ONE server that provides the parrot service
        
        // get all setJoke
        client.findServers("services.Joke/setJoke"); // get ALL servers that provide the setJoke service

        // get getJoke
        client.findServer("services.Joke/getJoke"); // get ALL servers that provide the getJoke service

        // does not exist
        client.findServer("random"); // shows the output if the server does not find a given service
      }

    } finally {
      // ManagedChannels use resources like threads and TCP connections. To prevent
      // leaking these
      // resources the channel should be shut down when it will no longer be used. If
      // it may be used
      // again leave it running.
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
      regChannel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }
}
