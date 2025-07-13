package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@RestController
public class MyController {

    @PostMapping("/hello")
    public String hello(@RequestBody UserRequest userRequest){
        String logMessage = String.format("Recieved hello request at %s from username: %s, email: %s, password: %s",
                LocalDateTime.now(),
                userRequest.getUsername(),
                userRequest.getEmail(),
                userRequest.getPassword()
        );
        writeToFile(logMessage);
        return "hello";
    }

    private void writeToFile(String message){
        String filepath = "/Users/lahin.saleem/Desktop/logfile";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true))){
            writer.newLine();
            writer.write(message);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
