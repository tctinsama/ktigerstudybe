package org.example.ktigerstudybe.dto.resp;

import lombok.Data;

@Data
public class DocumentItemResponse {
    private Long wordId;
    private Long listId;
    private String word;
    private String meaning;
    private String example;
    private String vocabImage;
}
