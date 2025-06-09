package org.example.ktigerstudybe.service.documentReport;

import org.example.ktigerstudybe.dto.req.DocumentReportRequest;
import org.example.ktigerstudybe.dto.resp.DocumentReportResponse;

import java.util.List;

public interface DocumentReportService {
    DocumentReportResponse createDocumentReport(DocumentReportRequest request);
    List<DocumentReportResponse> getAllReports();
}
