package com.registerLogin.FirstMicroservice.controller;

import com.registerLogin.FirstMicroservice.entity.User;
import com.registerLogin.FirstMicroservice.service.RegisterLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import jakarta.validation.Valid;

@Controller
public class RegisterLoginController {

    @Autowired
    private RegisterLoginService registerLoginService;
    @PostMapping("/register")
    private String register(@RequestBody User user)
    {
        User exsistingUser = registerLoginService.getUserByname(user.getName());
        if(exsistingUser!=null)
        {
            return "chal gya";
        }
        exsistingUser = registerLoginService.getUserByemailId(user.getEmail());
        if(exsistingUser!=null)
        {
            return "mail mil gai";
        }
        registerLoginService.register(user);
        return "Hola";
    }



    @RequestMapping("/")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login.html");
        //modelAndView.
        return modelAndView;
    }

//    @RequestMapping("/registerCustomer")
//    public String registerCustomer(Model model) {
////        User user = new User();
////        model.addAttribute("user",user);
//        return "registerCustomer";
//    }

    @RequestMapping(value="/registerCustomer",method = RequestMethod.GET)
    public String registerCustomer(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "registerCustomer";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") User user,
                               BindingResult result,
                               Model model){
        User exsistingUser = registerLoginService.getUserByname(user.getName());
        User exsistingUser2 = registerLoginService.getUserByemailId(user.getEmail());
        if (exsistingUser != null) {
            result.rejectValue("name", null, "There is already an account registered with that name");
        }
//        if (exsistingUser2 != null) {
//            result.rejectValue("email", null, "There is already an email registered with that name");
//        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "registerCustomer";
        }
        registerLoginService.register(user);
        return "redirect:/registerCustomer?success";
    }

//    @PostMapping("/loginFinal")
//    public String loginFinal(@Valid @ModelAttribute("user") User user,
//                             BindingResult result,
//                             Model model){
//        User loginUser = registerLoginService.getLogin(user);
//
//    }


    @RequestMapping(value="/loginCustomer",method = RequestMethod.GET)
    public ModelAndView loginCustomer() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginCustomer.html");
        return modelAndView;
    }
}
