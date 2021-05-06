package com.tranhuudat.htttquanli.controller;

import com.tranhuudat.htttquanli.model.Item;
import com.tranhuudat.htttquanli.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/")
public class AdminController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping(value = "image/{id}")
    public void getImage(@PathVariable("id") long id, HttpServletResponse response, HttpServletRequest request)
            throws IOException, ServletException {
        Item item = itemRepository.findById(id).get();
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(item.getPicture());
        response.getOutputStream().close();
    }

    @GetMapping("login")
    private String loginView(HttpServletRequest request) {
        String referrer = request.getHeader("Referer");
        request.getSession().setAttribute("url_prior", referrer);
        return "login";
    }

}
