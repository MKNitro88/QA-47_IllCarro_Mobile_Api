package dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SearchDto {
    private String city;
    private String startDate;
    private String endDate;

}
