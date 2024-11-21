package org.example.learningoauth2;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/public")
    public String publicHello() {
        return "<h1>Hello, i'm public!</h1> <br> Thanks for visiting!";
    }

    //Esse método retorna as informações so usuário logado
    @GetMapping("/cookie")
    public String privateHello(@AuthenticationPrincipal OidcUser principal) {

        return String.format("""
                <h1>Hello, i'm private!</h1> <br> Thanks for visiting
                
                Principal: %s
                Email attribute: %s
                Authorities: %s
                JWT: %s
                """, principal, principal.getAttribute("email"), principal.getAuthorities(),
                principal.getIdToken().getTokenValue());
    }

    @GetMapping("/jwt")
    public String jwt(@AuthenticationPrincipal Jwt jwt) {
        return String.format("""
                <h1>JWT</h1>
               Principal: %s/n
                Email attribute: %s/n
                JWT: %s/n
               """, jwt.getClaims(), jwt.getClaim("email"), jwt.getTokenValue());
    }
}
