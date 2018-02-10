package man.frechet.oidc.client.controller;

import lombok.extern.slf4j.Slf4j;
import man.frechet.oidc.client.model.OpenIdConnectUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
public class ClientController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        log.debug("root");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null &&
                (auth.getPrincipal() instanceof OpenIdConnectUserDetails)) {
            OpenIdConnectUserDetails userInfo = (OpenIdConnectUserDetails) auth.getPrincipal();
            return "Hello" + userInfo.toString() + ", use \'/logout\' path for logout!";
        }
        return "Hello, anonymous! Use \'/login\' path for authorization!";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.debug("hello");
        return "Hello, it is free space.";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        log.debug("login");
        return "Authorization...";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        log.debug("logout");
        return "Logout...";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {
        log.debug("user");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null &&
                (auth.getPrincipal() instanceof OpenIdConnectUserDetails)) {
            OpenIdConnectUserDetails userInfo = (OpenIdConnectUserDetails) auth.getPrincipal();
            return "Welcome, " + userInfo.toString() + ".\n" +
                    "Use \'/logout\' path for logout!";
        }
        return "You are not authorized. Use \'/login\' path for authorization!";
    }
}
