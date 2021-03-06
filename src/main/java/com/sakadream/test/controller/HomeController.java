package com.sakadream.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sakadream.test.bean.Employee;
import com.sakadream.test.model.Functions;;

@Controller
public class HomeController {
    Functions fn = new Functions();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "indexshop";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
            HttpSession session, ModelMap model) throws Exception {
        if (fn.checkLogin(username, password, session)) {
            return "indexshop";
        } else {
            model.addAttribute("error", 1);
            return "index";
        }
    }
    
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String product(@RequestParam("categoryId") String categoryId, HttpSession session, ModelMap model) throws Exception {     
        model.addAttribute("categoryId", categoryId);
        return "indexshop";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(HttpSession session, ModelMap model) throws Exception {
        if (fn.checkSession(session)) {
            model.addAttribute("list", fn.showAllEmployees());
            fn.cleanConnection();
            return "employees";
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(HttpSession session) {
        if (fn.checkSession(session)) {
            return "add";
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/add-post", method = RequestMethod.POST)
    public String addPost(@RequestParam("fullname") String fullName, @RequestParam("address") String address,
            @RequestParam("email") String email, @RequestParam("phone") String phone,
            @RequestParam("salary") String salary, HttpSession session, ModelMap model) throws Exception {
        if (fn.checkSession(session)) {
            fn.add(new Employee(fullName, address, email, phone, Integer.valueOf(salary)));
            model.addAttribute("list", fn.showAllEmployees());
            return "employees";
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") String id, HttpSession session, ModelMap model) throws Exception {
        if (fn.checkSession(session)) {
            try {
                model.addAttribute("e", fn.getEmployee1(Integer.valueOf(id)));
                return "edit";
            } catch (Exception e) {
                model.addAttribute("list", fn.showAllEmployees());
                return "employees";
            }
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/edit-post", method = RequestMethod.POST)
    public String editPost(@RequestParam("fullname") String fullName, @RequestParam("address") String address,
            @RequestParam("email") String email, @RequestParam("phone") String phone,
            @RequestParam("salary") String salary, @RequestParam("id") String id, HttpSession session, ModelMap model)
            throws Exception {
        if (fn.checkSession(session)) {
            fn.edit(Integer.valueOf(id), new Employee(fullName, address, email, phone, Integer.valueOf(salary)));
            model.addAttribute("list", fn.showAllEmployees());
            return "employees";
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") String id, HttpSession session, ModelMap model) throws Exception {
        if (fn.checkSession(session)) {
            fn.delete(Integer.valueOf(id));
            model.addAttribute("list", fn.showAllEmployees());
            return "employees";
        } else {
            return "index";
        }
    }
}