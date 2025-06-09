package org.example.ktigerstudybe.dto.resp;

import lombok.Data;
import java.time.LocalDate;

@Data
public class DocumentReportResponse {
    private Long reportId;
    private Long userId;
    private Long listId;
    private String reason;
    private LocalDate reportDate;
}
