package org.example.ktigerstudybe.dto.req;

import lombok.Data;
import java.time.LocalDate;

@Data
public class DocumentReportRequest {
    private Long userId;
    private Long listId;
    private String reason;
    private LocalDate reportDate;
}
