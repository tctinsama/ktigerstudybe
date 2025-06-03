package org.example.ktigerstudybe.service.impl;

import org.example.ktigerstudybe.model.DocumentList;
import org.example.ktigerstudybe.repository.DocumentListRepository;
import org.example.ktigerstudybe.service.DocumentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentListServiceImpl implements DocumentListService {

    private final DocumentListRepository documentListRepository;

    @Autowired
    public DocumentListServiceImpl(DocumentListRepository documentListRepository) {
        this.documentListRepository = documentListRepository;
    }

    @Override
    public DocumentList createDocumentList(DocumentList documentList) {
        return documentListRepository.save(documentList);
    }

    @Override
    public List<DocumentList> getAllDocumentLists() {
        return (List<DocumentList>) documentListRepository.findAll();
    }

    @Override
    public Optional<DocumentList> getDocumentListById(Long listId) {
        return documentListRepository.findById(listId);
    }

    @Override
    public DocumentList updateDocumentList(Long listId, DocumentList updatedDocumentList) {
        return documentListRepository.findById(listId)
            .map(existing -> {
                existing.setTitle(updatedDocumentList.getTitle());
                existing.setDescription(updatedDocumentList.getDescription());
                existing.setType(updatedDocumentList.getType());
                existing.setCreatedAt(updatedDocumentList.getCreatedAt());
                existing.setIsPublic(updatedDocumentList.getIsPublic());
                existing.setUser(updatedDocumentList.getUser());
                return documentListRepository.save(existing);
            })
            .orElseThrow(() -> new RuntimeException("DocumentList not found with ID: " + listId));
    }

    @Override
    public void deleteDocumentList(Long listId) {
        documentListRepository.deleteById(listId);
    }

    @Override
    public List<DocumentList> getDocumentListsByUserId(Long userId) {
        return documentListRepository.findByUser_UserId(userId);
    }

    @Override
    public List<DocumentList> getPublicDocumentLists() {
        return documentListRepository.findByIsPublic(1); // 1 nghĩa là public
    }

    @Override
    public List<DocumentList> searchByTitle(String keyword) {
        return documentListRepository.findByTitleContainingIgnoreCase(keyword);
    }
}
