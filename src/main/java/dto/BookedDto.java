package dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookedDto {
    private String email;
    private String startDate;
    private String endDate;
}
