package com.example.ProductServiceAug24.controllers;

import com.example.ProductServiceAug24.Exceptions.ProductNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String helloworld(){
        return "Hello World";
    }

    //Endpoint name
    @GetMapping("/hello/{name}")
    public String helloWithName(@PathVariable("name") String name ) throws ProductNotFoundException {
        if(name.equals("Ajay")){
            throw new ProductNotFoundException("Ajay is not a product");
        }
        return "Hello " + name;
    }
    @GetMapping("/show/{showId}/seat/{seatId}")
    public String bmsExample(@PathVariable("showId") String showId,@PathVariable("seatId") int seatId ){
        return "Hello "+ showId+" "+seatId;
    }
}
