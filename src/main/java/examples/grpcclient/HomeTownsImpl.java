package examples.grpcclient;

import com.google.protobuf.Empty;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import io.grpc.stub.StreamObserver;
import service.*;
import service.HometownsGrpc.HometownsImplBase;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HomeTownsImpl extends HometownsGrpc.HometownsImplBase {
    private List<Hometown> hometownsList;
    public HomeTownsImpl() {
        this.hometownsList = new ArrayList<>();
        readDataFromFile(); // read saved data from file
    }

    @Override
    public void read(Empty request, StreamObserver<HometownsReadResponse> responseObserver) {
        HometownsReadResponse.Builder responseBuilder = HometownsReadResponse.newBuilder();
        responseBuilder.addAllHometowns(hometownsList);
        responseBuilder.setIsSuccess(true);
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void search(HometownsSearchRequest request, StreamObserver<HometownsReadResponse> responseObserver) {
        String city = request.getCity();
        List<Hometown> matchingHometowns = new ArrayList<>();
    
        for (Hometown hometown : hometownsList) {
            if (hometown.getCity().equalsIgnoreCase(city)) {
                matchingHometowns.add(hometown);
            }
        }
    
        HometownsReadResponse.Builder responseBuilder = HometownsReadResponse.newBuilder();
        responseBuilder.addAllHometowns(matchingHometowns);
        responseBuilder.setIsSuccess(true);
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void write(HometownsWriteRequest request, StreamObserver<HometownsWriteResponse> responseObserver) {
        Hometown hometown = request.getHometown();
        if(!hometownsList.contains(hometown)) {
            hometownsList.add(hometown);
        }
        writeDataToFile(); // save updated data to file
        HometownsWriteResponse.Builder responseBuilder = HometownsWriteResponse.newBuilder();
        responseBuilder.setIsSuccess(true);
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    private void readDataFromFile() {
        // Read the hometowns data from a JSON file or create a new list
        File jsonFile = new File("hometowns.json");
        if (jsonFile.exists()) {
            try (FileReader reader = new FileReader(jsonFile)) {
                JsonFormat.parser().merge(reader, HometownsReadResponse.newBuilder());
                this.hometownsList = HometownsReadResponse.newBuilder().addAllHometowns(hometownsList).build().getHometownsList();
            } catch (InvalidProtocolBufferException ex) {
                System.err.println("Error with Protocol Buffer: " + ex.getMessage());
            } catch (IOException e) {
                System.err.println("Error reading hometowns data from file: " + e.getMessage());
                this.hometownsList = new ArrayList<>();
            } 
        } else {
            this.hometownsList = new ArrayList<>();
        }
    }
    
    private void writeDataToFile() {
        // Save the updated list to a JSON file
        File jsonFile = new File("hometowns.json");
        try (FileWriter writer = new FileWriter(jsonFile)) {
            JsonFormat.printer().appendTo(HometownsReadResponse.newBuilder().addAllHometowns(hometownsList).build(), writer);
        } catch (IOException e) {
            System.err.println("Error writing hometowns data to file: " + e.getMessage());
        }
    }
}

