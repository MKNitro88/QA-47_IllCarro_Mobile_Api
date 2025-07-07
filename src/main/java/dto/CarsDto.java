package dto;

import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarsDto {
    private ArrayList<CarDto> cars;
}
