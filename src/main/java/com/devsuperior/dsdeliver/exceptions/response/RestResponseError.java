package com.devsuperior.dsdeliver.exceptions.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestResponseError {

    private String error;

    public static RestResponseError userNotFoundException(String message) {
        RestResponseError resp = new RestResponseError();
        resp.error = message;
        return resp;
    }
}
