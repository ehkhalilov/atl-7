package az.example.atl7.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class ExceptionDto {
    private final Integer code;
    private final String message;
}
