package com.tranhuudat.htttquanli.controller;

import com.tranhuudat.htttquanli.security.AccountDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
    public static AccountDetails getAuthentication() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            AccountDetails accountDetails = (AccountDetails) authentication.getPrincipal();
            if (accountDetails != null) {
                return accountDetails;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }

    @GetMapping()
    public String getHome(Model model) {
        if (getAuthentication() != null) {
            StringBuilder role= new StringBuilder();
            getAuthentication().getAuthorities().stream().forEach(grantedAuthority -> {
                role.append(grantedAuthority.getAuthority());
            });
            System.out.println(role.toString());
            model.addAttribute("account", getAuthentication().getUsername());
            model.addAttribute("role", role.toString());
            return "admin/home";
        }
        return "login";
    }

}
