package dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookingPeriodDto {
    private String startDate;
    private String endDate;
}
