package com.eazybites.jobportal.auth;

import com.eazybites.jobportal.dto.LoginRequestDto;
import com.eazybites.jobportal.dto.LoginResponseDto;
import com.eazybites.jobportal.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/login/public")
    public ResponseEntity<LoginResponseDto> apiLogin(@RequestBody LoginRequestDto loginRequestDto) {

        var userDto = new UserDto();
        return ResponseEntity.status(HttpStatus.OK)
                .body(new LoginResponseDto(HttpStatus.OK.getReasonPhrase(), userDto, null));
    }
}
