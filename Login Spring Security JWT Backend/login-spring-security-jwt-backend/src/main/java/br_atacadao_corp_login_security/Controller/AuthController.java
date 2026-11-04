package br_atacadao_corp_login_security.Controller;

import br_atacadao_corp_login_security.dto.LoginRequestDto;
import br_atacadao_corp_login_security.dto.RegisterRequestDto;
import br_atacadao_corp_login_security.dto.ResponseDto;
import br_atacadao_corp_login_security.entity.TbUser;
import br_atacadao_corp_login_security.infra.security.TokenService;
import br_atacadao_corp_login_security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDto body){
        TbUser tbUser = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), tbUser.getPassword())) {
            String token = this.tokenService.generateToken(tbUser);
            return ResponseEntity.ok(new ResponseDto(tbUser.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDto body){
        Optional<TbUser> tbUser = this.repository.findByEmail(body.email());

        if(tbUser.isEmpty()) {
            TbUser tbUser1 = new TbUser();
            tbUser1.setPassword(passwordEncoder.encode(body.password()));
            tbUser1.setEmail(body.email());
            tbUser1.setName(body.name());
            this.repository.save(tbUser1);

            String token = this.tokenService.generateToken(tbUser1);
            return ResponseEntity.ok(new ResponseDto(tbUser1.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
