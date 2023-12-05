package com.shey.cargosystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Project_Name: cargo-system
 * @Package_Name: com.shey.cargosystem.controller
 * @File: RedirectController
 * @Version: 1.0.0
 * @Author: 榭壹Shey
 * @Created: 2023-12-05 19:32
 * @Last_Modified: 2023-12-05 19:32
 * @Description: 资源访问
 */


@Controller
public class RedirectController {
    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url) {
        return url;
    }

    @GetMapping("/")
    public String main() {
        return "redirect:/index";
    }

    @GetMapping("test.png")
    @ResponseBody
    void returnNoImage() {

    }

}
