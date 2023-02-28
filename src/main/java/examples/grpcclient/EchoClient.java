package examples.grpcclient;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import service.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;

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
  private final TodoGrpc.TodoBlockingStub blockingStub6;

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
    blockingStub6 = TodoGrpc.newBlockingStub(channel);
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
      if (response.getIsSuccess()){
        System.out.println("Current temperature: " + response.getCurrentTemp());
        System.out.println("Current conditions: " + response.getCurrentConditions());
        
        // Print daily high temperatures
        System.out.println("Daily high temperatures:");
        for (double dailyHigh : response.getDailyHighsList()) {
          System.out.println("- " + dailyHigh);
        }
      } else {
        System.err.println(response.getError());
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
      if (response.getIsSuccess()) {
        System.out.println("Current temperature: " + response.getCurrentTemp());
        System.out.println("Current conditions: " + response.getCurrentConditions());
        
        // Print daily high temperatures
        System.out.println("Daily high temperatures:");
        for (double dailyHigh : response.getDailyHighsList()) {
          System.out.println("- " + dailyHigh);
        }
      } else {
        System.err.println(response.getError());
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
      if (response.getIsSuccess()) {
        System.out.println("Available Cities: ");
        for (String city : response.getCityNameList()) {
          System.out.println(city);        
        }
      } else {
        System.err.println(response.getError());
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
      if (response.getIsSuccess()) {
        System.out.printf("%-20s %-20s %-20s\n", "Name", "City", "Region");
        for (Hometown hometown : response.getHometownsList()) {
          System.out.printf("%-20s %-20s %-20s\n", hometown.getName(), hometown.getCity(), hometown.getRegion());
        }        
      } else {
        System.err.println(response.getError());
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
        System.err.println(response.getError());
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
      if (response.getIsSuccess()) {
        System.out.printf("%-20s %-20s %-20s\n", "Name", "City", "Region");
        for (Hometown hometown : response.getHometownsList()) {
          System.out.printf("%-20s %-20s %-20s\n", hometown.getName(), hometown.getCity(), hometown.getRegion());
        }        
      } else {
        System.err.println(response.getError());
      }
    } catch (Exception e) {
      // TODO: handle exception
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  // Todo/Tasklist Service

  public void getTodoList() {
    Empty empty = Empty.newBuilder().build();
    TodoListResponse response;
    try {
      response = blockingStub6.list(empty);
      if (response.getIsSuccess()) {
        for (Task task : response.getTasksList()) {
          LocalDate dueDate = LocalDate.now().plusDays(task.getDaysLeft());
          System.out.println((task.getIsCompleted() ? "[X] " : "[ ] ") + task.getId() + "- " + task.getTask() + " | Due on: " + dueDate);
        }
      } else {
        System.err.println(response.getError()); 
      }
    } catch (Exception e) {
      // TODO: handle exception
      System.err.println("RPC failed: " + e);
      return;
    }

  }

  public void addTask(String descr, int daysLeft) {
    Task task = Task.newBuilder().setIsCompleted(false).setTask(descr).setDaysLeft(daysLeft).build();
    TodoAddRequest request = TodoAddRequest.newBuilder().setTask(task).build();
    TodoAddResponse response;
    try {
      response = blockingStub6.add(request);
      if (response.getIsSuccess()) {
        System.out.println("Success!");
      } else {
        System.err.println(response.getError());
      }
    } catch (Exception e) {
      // TODO: handle exception
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public void toggleTaskCompletion(int taskid) {
    TodoCompleteRequest request = TodoCompleteRequest.newBuilder().setTaskId(taskid).build();
    TodoCompleteResponse response;
    try {
      response = blockingStub6.toggleComplete(request);
      if (response.getIsSuccess()) {
        System.out.println("Success!");
      } else {
        System.err.println(response.getError());
      }
    } catch (Exception e) {
      // TODO: handle exception
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  // Registry Service

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
    System.out.println();
    System.out.println("Choose Which Service you want to run:");
    System.out.println("1. Weather/listCities");
    System.out.println("2. Weather/inCity");
    System.out.println("3. Weather/atCoordinates");
    System.out.println("4. Hometowns/write");
    System.out.println("5. Hometowns/read");
    System.out.println("6. Hometowns/search");
    System.out.println("7. Todo/add");
    System.out.println("8. Todo/list");
    System.out.println("9. Todo/toggleComplete");
    System.out.println("10. Joke/setJoke");
    System.out.println("11. Joke/getJoke");
    System.out.println("11. Echo/parrot");
    System.out.println("0. Exit");
  }

  public static String generateRandomLetterString() {
    Random random = new Random();
    int randomInt = random.nextInt(26) + 65; // generate a random ASCII value between 65 and 90
    return Character.toString((char)randomInt); // convert the ASCII value to a String
}



  public static void main(String[] args) throws Exception {
    if (args.length != 7) {
      System.out
          .println("Expected arguments: <host(String)> <port(int)> <regHost(string)> <regPort(int)> <message(String)> <regOn(bool)> <auto(int)>");
      System.exit(1);
    }
    int port = 9099;
    int regPort = 9003;
    int auto = 0;
    String host = args[0];
    String regHost = args[2];
    String message = args[4];
    try {
      port = Integer.parseInt(args[1]);
      regPort = Integer.parseInt(args[3]);
      auto = Integer.parseInt(args[6]);
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
      
      Map<String, String> citiesToRegions = new HashMap<>();
      citiesToRegions.put("New York", "NY");
      citiesToRegions.put("Los Angeles", "CA");
      citiesToRegions.put("Chicago", "IL");
      citiesToRegions.put("Houston", "TX");
      citiesToRegions.put("Phoenix", "AZ");
      citiesToRegions.put("Philadelphia", "PA");

      String[] names = {"John Doe", "Jane Smith", "Michael Johnson", "Sarah Lee", "David Brown", "Emily Davis"};
      String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia"};

      Random random = new Random();

      if (auto != 0) {
        switch (auto) {
          case 1:
            client.getCityList();
            break;
          case 2:
            String city = "London";
            client.getWeatherInCity(city);
            break;
          case 3:
            double lat = 51.5074;
            double lon = -0.1278;
            client.getWeatherAtCooridates(lat, lon);
            break;
          case 4:
            String name = names[random.nextInt(names.length)];
            String cityName = cities[random.nextInt(cities.length)];
            String region = citiesToRegions.get(cityName);
            client.writeHomeTowns(name, cityName, region);
            break;
          case 5:
            client.readHomeTowns();
            break;
          case 6:
            String cityString = "Houston";
            client.searchHomeTowns(cityString);
            break;
          case 7:
            String descr = "Perform Task " + generateRandomLetterString();
            int daysLeft = 7;
            client.addTask(descr, daysLeft);
            break;
          case 8:
            client.getTodoList();
            break;
          case 9:
            int taskID = 1;
            client.toggleTaskCompletion(taskID);
            break;
          case 10:
            client.setJoke("I made a pencil with two erasers. It was pointless.");
            break;
          case 11:
            client.askForJokes(6);
            break;
          case 12:
            // call the parrot service on the server
            client.askServerToParrot(message);
          break;
          default:
              System.out.println("Invalid input. Please enter a number between 1-11.");
              break;
        }
      } else {
        boolean quit = false;
        while(!quit){
          printMenu();
          Scanner scanner = new Scanner(new InputStreamReader(System.in));
          int key = 0;
          try {
            key = scanner.nextInt();
          } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter a number.");
            scanner.nextLine(); // consume the invalid input
            continue;
          }
          switch (key) {
            case 1:
              client.getCityList();
              break;
            case 2:
              System.out.println("Enter City Name: ");
              scanner.nextLine();
              String city = scanner.nextLine();
              client.getWeatherInCity(city);
              break;
            case 3:
              System.out.println("Enter Latitude: ");
              double lat = 0.0;
              try {
                lat = scanner.nextDouble();
              } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine(); // consume the invalid input
                continue;
              }
              System.out.println("Enter Longitude: ");
              double lon = 0.0;
              try {
                lon = scanner.nextDouble();
              } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine(); // consume the invalid input
                continue;
              }
              client.getWeatherAtCooridates(lat, lon);          
              break;
            case 4:
              System.out.println("Enter your name: ");
              scanner.nextLine();
              String name = scanner.nextLine();
              System.out.println("Enter the name of your city: ");
              String cityName = scanner.nextLine();
              System.out.println("Enter the name of your region: ");
              String region = scanner.nextLine();
              client.writeHomeTowns(name, cityName, region);
              break;
            case 5:
              client.readHomeTowns();
              break;
            case 6:
              System.out.println("Enter the name of a city: ");
              scanner.nextLine();
              String cityString = scanner.nextLine();
              client.searchHomeTowns(cityString);
              break;
            case 7:
              System.out.println("Enter your task description: ");
              scanner.nextLine();
              String descr = scanner.nextLine();
              int daysLeft = 0;
              try {
                System.out.println("Enter how many days you have to complete your task: ");
                daysLeft = scanner.nextInt();
              } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine(); // consume the invalid input
                continue;
              }
              client.addTask(descr, daysLeft);
              break;
            case 8:
              client.getTodoList();
              break;
            case 9:
              int taskID = 0;
              try {
                System.out.println("Enter the id of the task you want to complete: ");
                taskID = scanner.nextInt();
              } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine(); // consume the invalid input
                continue;
              }
              client.toggleTaskCompletion(taskID);
              break;
            case 10:
              System.out.println("Enter a joke: ");
              scanner.nextLine();
              String joke = scanner.nextLine();
              client.setJoke(joke);
              break;
            case 11:
              int num = 0;
              try {
                System.out.println("Enter the amount of jokes you want to get: ");
                num = scanner.nextInt();
              } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine(); // consume the invalid input
                continue;
              }
              client.askForJokes(num);
              break;
            case 12:
              System.out.println("Enter a phrase you want the server to parrot: ");
              String parrot = scanner.nextLine();
              client.askServerToParrot(parrot);
              break;
            case 0:
              quit = true;
              break;
            default:
              System.out.println("Invalid input. Please enter a number between 0-11.");
              break;
          }
        }
      }
      

      // client.getWeatherAtCooridates(33.4484, -112.0740);

      // client.getWeatherInCity("Mecca");

      // client.writeHomeTowns("Muhammad", "TX", "SOUTH");
      // client.writeHomeTowns("Zaynab", "NY", "NORTH");
      // client.readHomeTowns();
      // client.searchHomeTowns("NY");


      // ############### Contacting the registry just so you see how it can be done

      // if (args[5].equals("true")) { 
      //   // Comment these last Service calls while in Activity 1 Task 1, they are not needed and wil throw issues without the Registry running
      //   // get thread's services
      //   client.getServices(); // get all registered services 

      //   // get parrot
      //   client.findServer("services.Echo/parrot"); // get ONE server that provides the parrot service
        
      //   // get all setJoke
      //   client.findServers("services.Joke/setJoke"); // get ALL servers that provide the setJoke service

      //   // get getJoke
      //   client.findServer("services.Joke/getJoke"); // get ALL servers that provide the getJoke service

      //   // does not exist
      //   client.findServer("random"); // shows the output if the server does not find a given service
      // }

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
