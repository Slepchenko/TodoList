package ru.trainee.slepchenko.todo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.trainee.slepchenko.todo.filter.AddUserModel;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
public class IndexController {

    @GetMapping("/index")
    public String getIndex(Model model, HttpSession session) {
        AddUserModel.checkInMenu(model, session);
        return "index";
    }

}
