package br.com.fiap.apicarsale.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public Token create(String username, String id, String role){
        var expires = LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.ofHours(-3));
        var algorithm = Algorithm.HMAC256("assinatura");

        var token = JWT.create()
                .withSubject(username)
                .withExpiresAt(expires)
                .sign(algorithm);

        return new Token(token, username, id, role);
    }

}
