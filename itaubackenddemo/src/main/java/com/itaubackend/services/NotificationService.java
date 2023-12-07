package com.itaubackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;


@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;


    public class SenhaController {@PostMapping("/validar-senha")
        public boolean validarSenha(@RequestBody SenhaController senhaRequest) {
        assert senhaRequest.getSenha() != null;
        if (validarSenha(senhaRequest.getSenha())) {
                notificarSenhaCorreta();
                return ResponseEntity.ok("Senha válida!").hasBody();
            } else {
                notificarSenhaIncorreta();
                return ResponseEntity.badRequest().body("Senha inválida!").hasBody();
            }
        }

        private SenhaController getSenha() {
            return null;
        }

        private boolean validarSenha(String senha) {
            // Implementar lógica de validação da senha
            String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()-+]).{9,}$";
            return senha.matches(regex) && !temRepeticao(senha);
        }

        private boolean temRepeticao(String senha) {
            // Implementar lógica para verificar se há caracteres repetidos
            return senha.matches(".*(.)\\1.*");
        }

        private void notificarSenhaCorreta() {
            System.out.println("Senha correta! Notificação enviada.");
            // Adicione lógica de notificação real aqui (por exemplo, envio de e-mail, push notification, etc.)
        }

        private void notificarSenhaIncorreta() {
            System.out.println("Senha incorreta! Notificação enviada.");
            // Adicione lógica de notificação real aqui (por exemplo, envio de e-mail, push notification, etc.)
        }
    }
}
