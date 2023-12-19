package br.com.afroglow.backendAfroGlow.Infra.Security;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private static final String SECRET_KEY = "vitoriadeusa";

    public String gerarToken(String email) {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 30); // Adicionando 30 dias à data atual

        Date expirationDate = cal.getTime();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedExpirationDate = dateFormat.format(expirationDate);

            String token = Jwts.builder()
                    .setSubject(email)
                    .setIssuer("AfroGlow")
                    .setExpiration(expirationDate)
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();

            System.out.println("Token gerado com sucesso: " + token);
            System.out.println("Data de expiração: " + formattedExpirationDate);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Falha ao gerar token: " + e.getMessage());
            return null;
        }
    }
}
