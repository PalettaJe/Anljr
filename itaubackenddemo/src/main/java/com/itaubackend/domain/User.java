package com.itaubackend.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // construtores, getters e setters

}

@RestController
class SenhaController {

    @PostMapping("/validar-senha")
    public ResponseEntity<String> validarSenha(@RequestBody User user) {
        String senha = user.getPassword();
        if (validarSenha(senha)) {
            notificarSenhaCorreta();
            return ResponseEntity.ok("Senha válida!");
        } else {
            notificarSenhaIncorreta();
            return ResponseEntity.badRequest().body("Senha inválida!");
        }
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
