package dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationBodyDto {
    private String username;
    private String password;
}