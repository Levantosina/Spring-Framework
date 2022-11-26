package ru.levkin.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
   // public String helloPage(HttpServletRequest request) {
     public String helloPage(@RequestParam(value = "name",required=false)String name,
                             @RequestParam(value = "surname",required=false)String surname,
                             Model model)
    {
        //String name=request.getParameter("name");
      //  String surname=request.getParameter("surname");

      //  System.out.println("Hell0, "+name+" "+surname);
model.addAttribute("message","Hell0, "+name+" "+surname);
        return "first/hello";
    }


    @GetMapping("/calculator")
    public String calculator(@RequestParam(value="int1")int int1,
                             @RequestParam(value = "int2")int int2,
                             @RequestParam (value = "action")String action,
                             Model model){
        double result;
        switch (action){
            case "multiplication":
                result=int1*int2;
                break;
            case "division":
                result=int1/(double)int2;
                break;
            case "addition":
                result=int1+int2;
                break;
            case "subtraction":
                result=int1-int2;
                break;
            default:
                result=0;
                break;
        }
        model.addAttribute("result",result);

        return "first/calculator";
    }


    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}

