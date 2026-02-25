package com.bibek.RestAPIDemo1.controllers;


import org.springframework.web.bind.annotation.*;

//@RestController
//public class MyController {
//
//
//    @GetMapping("/")
//    public String printHello(){
//        return "Hello Bibek";
//    }
//
//    @PostMapping("/")
//    public String printHi(){
//        return "Hi Deepak";
//    }
//}

@RestController
public class MyController {
    @PostMapping("/")
    public String printHello(@RequestParam("name1") String name){
        return "Hello"+name;
    }

    @GetMapping("/hi")
    public String printHi(@RequestParam("name1") String name, @RequestParam("rollno") String roll){
        return "hi"+name+" "+roll;
    }

    @GetMapping("hello/{name}/{roll}")
    public String PrintName(@PathVariable("name") String name, @PathVariable("roll") String roll){
        return "Hello: "+name + " Roll No: "+roll
                ;
    }

}