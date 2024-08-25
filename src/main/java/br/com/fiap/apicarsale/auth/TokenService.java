package br.com.fiap.apicarsale.auth;

import br.com.fiap.apicarsale.domain.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public Token create(User user){
        var expires = LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.ofHours(-3));
        var algorithm = Algorithm.HMAC256("assinatura");

        var token = JWT.create()
                .withSubject(user.getId().toString())
                .withClaim("username", user.getUsername())
                .withClaim("role", user.getRole())
                .withExpiresAt(expires)
                .sign(algorithm);

        return new Token(token, user.getName(), user.getId().toString(), user.getRole());
    }

}
