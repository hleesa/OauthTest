package com.test.OauthTest.web;

import com.test.OauthTest.config.auth.LoginUser;
import com.test.OauthTest.config.auth.dto.SessionUser;
import com.test.OauthTest.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("post", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
}
