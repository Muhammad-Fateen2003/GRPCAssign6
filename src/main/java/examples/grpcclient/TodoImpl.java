package examples.grpcclient;

import com.google.protobuf.Empty;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import io.grpc.stub.StreamObserver;
import service.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import io.grpc.stub.StreamObserver;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TodoImpl extends TodoGrpc.TodoImplBase {

    private final Map<Integer, Task> taskMap = new HashMap<>();
    // private final AtomicInteger taskIdGenerator = new AtomicInteger(taskMap.size() + 1);
    public TodoImpl() {
        readDataFromFile();
    }

    @Override
    public void list(Empty request, StreamObserver<TodoListResponse> responseObserver) {
        List<Task> tasks = new ArrayList<>(taskMap.values());
        TodoListResponse response;
        try {
            response = TodoListResponse.newBuilder()
                    .setIsSuccess(true)
                    .addAllTasks(tasks)
                    .build();
        } catch (Exception e) {
            response = TodoListResponse.newBuilder()
            .setIsSuccess(false)
            .setError("Error Lisiting: " + e.getMessage())
            .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void add(TodoAddRequest request, StreamObserver<TodoAddResponse> responseObserver) {
        Task task = request.getTask();
        int taskId = taskMap.size() + 1;
        task = task.toBuilder().setId(taskId).build();
        taskMap.put(taskId, task);
        TodoAddResponse response;
        try {
            writeDataToFile();
            response = TodoAddResponse.newBuilder()
                    .setIsSuccess(true)
                    .build();
        } catch(IOException e) {
            response = TodoAddResponse.newBuilder()
            .setIsSuccess(false)
            .setError("Error adding tasks to file: " + e.getMessage())
            .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void toggleComplete(TodoCompleteRequest request, StreamObserver<TodoCompleteResponse> responseObserver) {
        int taskId = request.getTaskId();
        Task task = taskMap.get(taskId);
        if (task == null) {
            TodoCompleteResponse response = TodoCompleteResponse.newBuilder()
                    .setIsSuccess(false)
                    .setError("Task not found")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        task = task.toBuilder().setIsCompleted(!task.getIsCompleted()).build();
        taskMap.put(taskId, task);
        TodoCompleteResponse response;
        try {
            writeDataToFile();
            response = TodoCompleteResponse.newBuilder()
                    .setIsSuccess(true)
                    .build();
        } catch(IOException e) {
            response = TodoCompleteResponse.newBuilder()
            .setIsSuccess(false)
            .setError("Error Toggling tasks: " + e.getMessage())
            .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void readDataFromFile() {
        // Read the hometowns data from the hometowns JSON file
        File jsonFile = new File("todolist.json");
        if (jsonFile.exists()) {        
            try (FileReader reader = new FileReader(jsonFile)) {
                JsonFormat.Parser parser = JsonFormat.parser();
                TodoListResponse.Builder todolistBuilder = TodoListResponse.newBuilder();
                parser.merge(reader, todolistBuilder);
                for (Task task : todolistBuilder.getTasksList()) {
                    taskMap.put(task.getId(), task);
                }
            } catch (InvalidProtocolBufferException ex) {
                System.err.println("Error with Protocol Buffer: " + ex.getMessage());
            } catch (IOException e) {
                System.out.println("Error reading data from file: " + e.getMessage());
            }
        }
    }   

    private void writeDataToFile() throws IOException{
        // Save the updated list to a JSON file
        File jsonFile = new File("todolist.json");
        try (FileWriter writer = new FileWriter(jsonFile)) {
            JsonFormat.printer().appendTo(TodoListResponse.newBuilder().addAllTasks(taskMap.values()).build(), writer);
        } catch (IOException e) {
            // System.err.println("Error writing hometowns data to file: " + e.getMessage());
            throw new IOException();
        }
    }
    
}

