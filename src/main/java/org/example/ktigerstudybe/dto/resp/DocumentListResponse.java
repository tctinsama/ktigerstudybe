package org.example.ktigerstudybe.dto.resp;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DocumentListResponse {
    private Long listId;
    private Long userId;
    private String title;
    private String description;
    private String type;
    private LocalDateTime createdAt;
    private int isPublic;
}
