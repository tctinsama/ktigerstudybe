package org.example.ktigerstudybe.service.documentReport;

import org.example.ktigerstudybe.dto.req.DocumentReportRequest;
import org.example.ktigerstudybe.dto.resp.DocumentReportResponse;
import org.example.ktigerstudybe.model.DocumentList;
import org.example.ktigerstudybe.model.DocumentReport;
import org.example.ktigerstudybe.model.User;
import org.example.ktigerstudybe.repository.DocumentListRepository;
import org.example.ktigerstudybe.repository.DocumentReportRepository;
import org.example.ktigerstudybe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentReportServiceImpl implements DocumentReportService {

    @Autowired
    private DocumentReportRepository documentReportRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DocumentListRepository documentListRepository;

    private DocumentReportResponse toResponse(DocumentReport report) {
        DocumentReportResponse resp = new DocumentReportResponse();
        resp.setReportId(report.getReportId());
        resp.setUserId(report.getUser().getUserId());
        resp.setListId(report.getDocumentList().getListId());
        resp.setReason(report.getReason());
        resp.setReportDate(report.getReportDate());
        return resp;
    }

    private DocumentReport toEntity(DocumentReportRequest req) {
        DocumentReport report = new DocumentReport();
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + req.getUserId()));
        DocumentList list = documentListRepository.findById(req.getListId())
                .orElseThrow(() -> new IllegalArgumentException("DocumentList not found with id: " + req.getListId()));
        report.setUser(user);
        report.setDocumentList(list);
        report.setReason(req.getReason());
        report.setReportDate(req.getReportDate());
        return report;
    }

    @Override
    public DocumentReportResponse createDocumentReport(DocumentReportRequest request) {
        DocumentReport report = toEntity(request);
        report = documentReportRepository.save(report);
        return toResponse(report);
    }

    @Override
    public List<DocumentReportResponse> getAllReports() {
        return documentReportRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
