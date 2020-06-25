package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.fixture.InitDataFixture;
import pl.coderslab.charity.service.RoleService;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

public class UserController {
    private UserService userService;
    private InitDataFixture initDataFixture;
    private RoleService roleService;

    public UserController(UserService userService, InitDataFixture initDataFixture, RoleService roleService) {
        this.userService = userService;
        this.initDataFixture = initDataFixture;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(
            @AuthenticationPrincipal UserDetails customUser
    ) {
        return "You are logged as " + customUser;
    }
    // inicjalizacja roli.
    @GetMapping("/initData")
    @ResponseBody
    public String createUser() {

        this.initDataFixture.initRoles();
        this.initDataFixture.initUsers();
        return "initialized";
    }

    //Odsyłanie do formularza rejestracji
    @GetMapping("register")
    public String registerUser(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    // powrót z formularza i zapis do bazy danych

    @PostMapping("/register")
    public String postUser(@Valid @ModelAttribute User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "register";
        }
        try {
            this.userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/login";
    }
}