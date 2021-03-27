package fftl.SpringbootCRUD2.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDto {
    private String data;
    private String content;
}
