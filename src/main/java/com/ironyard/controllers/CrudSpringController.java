package com.ironyard.controllers;

import com.ironyard.entities.Sneaker;
import com.ironyard.services.SneakerRepository;
import com.ironyard.utilities.PasswordStorage;
import com.ironyard.entities.User;
import com.ironyard.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by illladell on 6/23/16.
 */
@Controller
public class CrudSpringController {

    @Autowired
    UserRepository users;

    @Autowired
    SneakerRepository sneakers;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");

        if (username == null) {
            return "home";
        }
        else {
            model.addAttribute("username", username);
            model.addAttribute("sneaker", sneakers.findAll());
            return "sneaker";
        }
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username, String password) throws Exception {

        User user = users.findByName(username);
        if (user == null) {
            user = new User(username, PasswordStorage.createHash(password));
            users.save(user);
        }
        else if (PasswordStorage.verifyPassword(password, user.getPassword())) {
            throw new Exception("Wrong password!");
        }

        session.setAttribute("username", username);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/create-sneaker", method = RequestMethod.POST)
    public String createSneaker(HttpSession session, String brand, String name, int year, float price, int size) {
        String username = (String) session.getAttribute("username");
        User user = users.findByName(username);
        Sneaker sneaker = new Sneaker(brand, name, year, price, size, user);
        sneakers.save(sneaker);
        return "redirect:/";
    }

    @RequestMapping(path = "delete-sneaker", method = RequestMethod.POST)
    public String deleteSneaker(HttpSession session, int id) {
        String username = (String) session.getAttribute("username");
        if (!users.findByName()username.equals(username))
        sneakers.delete(id);
        return "redirect:/";
    }


}
