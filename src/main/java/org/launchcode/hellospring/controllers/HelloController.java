package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
public class HelloController {

    //Handles request at path /hello
    /*@GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }*/

    // lives at /hello/goodbye


   //@GetMapping("goodbye")
   //@ResponseBody
   // public String goodbye(){
     //   return "Goodbye, Spring!";
   // }


    // lives at /hello/hello
    // Handles request of the form /hello? name= LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})

    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language, Model model){

        String msg = "";
        if(language.equalsIgnoreCase("english"))
        {
            msg = "Hello " + name + "!";
        }
        else if(language.equalsIgnoreCase("french"))
        {
            msg = "Bonjour " + name + "!";
        }
        else if(language.equalsIgnoreCase("spanish"))
        {
            msg = "Hola " + name + "!";
        }
        else if(language.equalsIgnoreCase("hindi"))
        {
            msg = "Namaste " + name + "!";
        }
        else if(language.equalsIgnoreCase("german"))
        {
            msg = "Hallo " + name + "!";
        }
        else
        {
            msg =  "Hello, " + name + "! Your language is unknown.";
        }

        model.addAttribute("greetingmessage", msg);
        return "hello";

        //return "Hello, " + name + "!. Your language is " + language;
    }


//Handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


// lives at /hello/form
    @RequestMapping(value = "form", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloForm() {
        return "form";
    }

}
