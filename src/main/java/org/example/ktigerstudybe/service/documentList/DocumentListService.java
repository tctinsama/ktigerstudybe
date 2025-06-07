package org.example.ktigerstudybe.service.documentList;

import org.example.ktigerstudybe.dto.req.DocumentListRequest;
import org.example.ktigerstudybe.dto.resp.DocumentListResponse;

import java.util.List;

public interface DocumentListService {
    DocumentListResponse createDocumentList(DocumentListRequest request);

    List<DocumentListResponse> getAllDocumentLists();

    DocumentListResponse getDocumentListById(Long listId);

    DocumentListResponse updateDocumentList(Long listId, DocumentListRequest request);

    void deleteDocumentList(Long listId);

    List<DocumentListResponse> getDocumentListsByUserId(Long userId);

    List<DocumentListResponse> getPublicDocumentLists();

    List<DocumentListResponse> searchByTitle(String keyword);
}
