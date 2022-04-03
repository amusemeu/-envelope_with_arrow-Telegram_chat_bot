
package amusemeu.tgbot.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;


    public String getBotUsername() {
        return username;
    }
    public String getBotToken() {
        return token;
    }

}

