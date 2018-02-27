package com.yingu.project.api;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ResponseResult<T> {
    private Status status;
    private String message;
    private List<T> data = new ArrayList();

}
