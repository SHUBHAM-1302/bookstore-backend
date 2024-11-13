package com.kb.merco.journal.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Home redirection to swagger api documentation
 */
@Controller
public class SwaggerController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index()
    {
        return "redirect:swagger-ui.html";
    }

    @RequestMapping(value = "/docs", method = RequestMethod.GET)
    public String docs()
    {
        return "redirect:swagger-ui.html";
    }
}
