package org.example.ktigerstudybe.dto.req;

import lombok.Data;

@Data
public class DocumentItemRequest {
    private Long listId;
    private String word;
    private String meaning;
    private String example;
    private String vocabImage;
}
