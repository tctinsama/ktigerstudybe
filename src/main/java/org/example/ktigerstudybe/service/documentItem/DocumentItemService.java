package org.example.ktigerstudybe.service.documentItem;

import org.example.ktigerstudybe.dto.req.DocumentItemRequest;
import org.example.ktigerstudybe.dto.resp.DocumentItemResponse;

import java.util.List;

public interface DocumentItemService {
    DocumentItemResponse createDocumentItem(DocumentItemRequest request);
    List<DocumentItemResponse> getAllDocumentItems();
    DocumentItemResponse getDocumentItemById(Long id);
    List<DocumentItemResponse> getDocumentItemsByListId(Long listId);
    DocumentItemResponse updateDocumentItem(Long id, DocumentItemRequest request);
    void deleteDocumentItem(Long id);
}

