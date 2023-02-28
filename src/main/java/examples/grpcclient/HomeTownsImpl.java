package examples.grpcclient;

import com.google.protobuf.Empty;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import io.grpc.protobuf.StatusProto;
import com.google.rpc.Status;
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
        try{
            responseBuilder.addAllHometowns(hometownsList);
            responseBuilder.setIsSuccess(true);
        } catch (Exception e) {
            responseBuilder.setIsSuccess(false);
            responseBuilder.setError("Error Reading: " + e.getMessage());
        }
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
        try{
            responseBuilder.addAllHometowns(matchingHometowns);
            responseBuilder.setIsSuccess(true);
        } catch (Exception e) {
            responseBuilder.setIsSuccess(false);
            responseBuilder.setError("Error Reading File: " + e.getMessage());
        }
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void write(HometownsWriteRequest request, StreamObserver<HometownsWriteResponse> responseObserver) {
        Hometown hometown = request.getHometown();
        if(!hometownsList.contains(hometown)) {
            hometownsList.add(hometown);
        }
        HometownsWriteResponse.Builder responseBuilder;
        try{
            writeDataToFile(); // save updated data to file
            responseBuilder = HometownsWriteResponse.newBuilder();
            responseBuilder.setIsSuccess(true);
        } catch(IOException e1) {
            responseBuilder = HometownsWriteResponse.newBuilder();
            responseBuilder.setIsSuccess(false);
            responseBuilder.setError("Error writing hometowns data to file: " + e1.getMessage());
        }
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

// To delete after test
    // private void readDataFromFile2() {
    //     // Read the hometowns data from a JSON file or create a new list
    //     File jsonFile = new File("hometowns.json");
    //     if (jsonFile.exists()) {
    //         try (FileReader reader = new FileReader(jsonFile)) {
    //             HometownsReadResponse.Builder hometownsBuilder = HometownsReadResponse.newBuilder();
    //             JsonFormat.parser().merge(reader, hometownsBuilder);
    //             this.hometownsList = hometownsBuilder.getHometownsList();
    //         } catch (InvalidProtocolBufferException ex) {
    //             System.err.println("Error with Protocol Buffer: " + ex.getMessage());
    //         } catch (IOException e) {
    //             System.err.println("Error reading data from file: " + e.getMessage());
    //         } 
    //     }
    // }

    private void readDataFromFile() {
        // Read the hometowns data from the hometowns JSON file
        File jsonFile = new File("hometowns.json");
        if (jsonFile.exists()) {        
            try (FileReader reader = new FileReader(jsonFile)) {
                JsonFormat.Parser parser = JsonFormat.parser();
                HometownsReadResponse.Builder hometownsBuilder = HometownsReadResponse.newBuilder();
                parser.merge(reader, hometownsBuilder);
                hometownsList.addAll(hometownsBuilder.getHometownsList());
            } catch (InvalidProtocolBufferException ex) {
                System.err.println("Error with Protocol Buffer: " + ex.getMessage());
            } catch (IOException e) {
                System.out.println("Error reading data from file: " + e.getMessage());
            }
        }
    }

    
    
    private void writeDataToFile() throws IOException{
        // Save the updated list to a JSON file
        File jsonFile = new File("hometowns.json");
        try (FileWriter writer = new FileWriter(jsonFile)) {
            JsonFormat.printer().appendTo(HometownsReadResponse.newBuilder().addAllHometowns(hometownsList).build(), writer);
        } catch (IOException e) {
            //System.err.println("Error writing hometowns data to file: " + e.getMessage());
            throw new IOException();
        }
    }
}

