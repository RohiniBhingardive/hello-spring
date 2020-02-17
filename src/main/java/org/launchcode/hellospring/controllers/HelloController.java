package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
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
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language){

        if(language.equalsIgnoreCase("english"))
        {
            return "<html>" +
                    "<body>" +
                    "Hello, " +
                    "<font color='Green'>" +
                     name + "!" +
                    "</font>" +
                    "</body>" +
                    "</html>";
        }
        else if(language.equalsIgnoreCase("french"))
        {
            return "<html>" +
                    "<body>" +
                    "Bonjour, " +
                    "<font color='Green'>" +
                    name + "!" +
                    "</font>" +
                    "</body>" +
                    "</html>";
        }
        else if(language.equalsIgnoreCase("spanish"))
        {
            return "<html>" +
                    "<body>" +
                    "Hola, " +
                    "<font color='Green'>" +
                    name + "!" +
                    "</font>" +
                    "</body>" +
                    "</html>";
        }
        else if(language.equalsIgnoreCase("hindi"))
        {
            return "<html>" +
                    "<body>" +
                    "Namaste, " +
                    "<font color='Green'>" +
                    name + "!" +
                    "</font>" +
                    "</body>" +
                    "</html>";
        }
        else if(language.equalsIgnoreCase("german"))
        {
            return "<html>" +
                    "<body>" +
                    "Hallo, " +
                    "<font color='Green'>" +
                    name + "!" +
                    "</font>" +
                    "</body>" +
                    "</html>";
        }
        else
        {
            return "Hello, " + name + "!. Your language is unknown.";
        }



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
    @ResponseBody
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'get' action = '/hello'>" +
                        "<input type = 'text' name = 'name' />" +
                        "<select name='language'>" +
                        "<option value='English' selected>English</option>" +
                        "<option value='French'>French</option>" +
                        "<option value='Spanish'>Spanish</option>" +
                        "<option value='Hindi'>Hindi</option>" +
                        "<option value='German'>German</option>" +
                        "</select>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

}
