package com.negoreserva.common.feature.core.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> implements Serializable {
    private List<T> content;
    private boolean empty = false;
    private boolean first = false;
    private boolean last = false;
    private int number = 0;
    private int numberOfElements = 0;
    private int size = 0;
    private long totalElements = 0;
    private int totalPages = 0;
}
