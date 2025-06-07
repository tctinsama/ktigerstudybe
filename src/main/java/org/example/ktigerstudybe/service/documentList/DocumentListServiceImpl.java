package org.example.ktigerstudybe.service.documentList;

import org.example.ktigerstudybe.dto.req.DocumentListRequest;
import org.example.ktigerstudybe.dto.resp.DocumentListResponse;
import org.example.ktigerstudybe.model.DocumentList;
import org.example.ktigerstudybe.model.User;
import org.example.ktigerstudybe.repository.DocumentListRepository;
import org.example.ktigerstudybe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentListServiceImpl implements DocumentListService {

    private final DocumentListRepository documentListRepository;
    private final UserRepository userRepository;

    @Autowired
    public DocumentListServiceImpl(DocumentListRepository documentListRepository, UserRepository userRepository) {
        this.documentListRepository = documentListRepository;
        this.userRepository = userRepository;
    }

    private DocumentListResponse toResponse(DocumentList doc) {
        DocumentListResponse resp = new DocumentListResponse();
        resp.setListId(doc.getListId());
        resp.setUserId(doc.getUser().getUserId());
        resp.setTitle(doc.getTitle());
        resp.setDescription(doc.getDescription());
        resp.setType(doc.getType());
        resp.setCreatedAt(doc.getCreatedAt());
        resp.setIsPublic(doc.getIsPublic());
        return resp;
    }

    private DocumentList toEntity(DocumentListRequest req) {
        DocumentList doc = new DocumentList();
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + req.getUserId()));
        doc.setUser(user);
        doc.setTitle(req.getTitle());
        doc.setDescription(req.getDescription());
        doc.setType(req.getType());
        doc.setCreatedAt(req.getCreatedAt());
        doc.setIsPublic(req.getIsPublic());
        return doc;
    }

    @Override
    public DocumentListResponse createDocumentList(DocumentListRequest request) {
        DocumentList doc = toEntity(request);
        doc = documentListRepository.save(doc);
        return toResponse(doc);
    }

    @Override
    public List<DocumentListResponse> getAllDocumentLists() {
        return documentListRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public DocumentListResponse getDocumentListById(Long listId) {
        DocumentList doc = documentListRepository.findById(listId)
                .orElseThrow(() -> new RuntimeException("DocumentList not found with ID: " + listId));
        return toResponse(doc);
    }

    @Override
    public DocumentListResponse updateDocumentList(Long listId, DocumentListRequest request) {
        DocumentList doc = documentListRepository.findById(listId)
                .orElseThrow(() -> new RuntimeException("DocumentList not found with ID: " + listId));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + request.getUserId()));
        doc.setUser(user);
        doc.setTitle(request.getTitle());
        doc.setDescription(request.getDescription());
        doc.setType(request.getType());
        doc.setCreatedAt(request.getCreatedAt());
        doc.setIsPublic(request.getIsPublic());
        doc = documentListRepository.save(doc);
        return toResponse(doc);
    }

    @Override
    public void deleteDocumentList(Long listId) {
        documentListRepository.deleteById(listId);
    }

    @Override
    public List<DocumentListResponse> getDocumentListsByUserId(Long userId) {
        return documentListRepository.findByUser_UserId(userId).stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public List<DocumentListResponse> getPublicDocumentLists() {
        return documentListRepository.findByIsPublic(1).stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public List<DocumentListResponse> searchByTitle(String keyword) {
        return documentListRepository.findByTitleContainingIgnoreCase(keyword).stream()
                .map(this::toResponse)
                .toList();
    }
}
