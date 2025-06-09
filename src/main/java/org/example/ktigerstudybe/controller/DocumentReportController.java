package org.example.ktigerstudybe.controller;

import org.example.ktigerstudybe.dto.req.DocumentReportRequest;
import org.example.ktigerstudybe.dto.resp.DocumentReportResponse;
import org.example.ktigerstudybe.service.documentReport.DocumentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document-reports")
public class DocumentReportController {

    @Autowired
    private DocumentReportService documentReportService;

    @PostMapping
    public DocumentReportResponse create(@RequestBody DocumentReportRequest request) {
        return documentReportService.createDocumentReport(request);
    }

    @GetMapping
    public List<DocumentReportResponse> getAll() {
        return documentReportService.getAllReports();
    }
}
