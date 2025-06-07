package org.example.ktigerstudybe.service.documentItem;

import org.example.ktigerstudybe.dto.req.DocumentItemRequest;
import org.example.ktigerstudybe.dto.resp.DocumentItemResponse;
import org.example.ktigerstudybe.model.DocumentItem;
import org.example.ktigerstudybe.model.DocumentList;
import org.example.ktigerstudybe.repository.DocumentItemRepository;
import org.example.ktigerstudybe.repository.DocumentListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentItemServiceImpl implements DocumentItemService {

    @Autowired
    private DocumentItemRepository documentItemRepository;

    @Autowired
    private DocumentListRepository documentListRepository;

    private DocumentItemResponse toResponse(DocumentItem item) {
        DocumentItemResponse resp = new DocumentItemResponse();
        resp.setWordId(item.getWordId());
        resp.setListId(item.getDocumentList().getListId());
        resp.setWord(item.getWord());
        resp.setMeaning(item.getMeaning());
        resp.setExample(item.getExample());
        resp.setVocabImage(item.getVocabImage());
        return resp;
    }

    private DocumentItem toEntity(DocumentItemRequest req) {
        DocumentItem item = new DocumentItem();
        DocumentList list = documentListRepository.findById(req.getListId())
                .orElseThrow(() -> new IllegalArgumentException("DocumentList not found with id: " + req.getListId()));
        item.setDocumentList(list);
        item.setWord(req.getWord());
        item.setMeaning(req.getMeaning());
        item.setExample(req.getExample());
        item.setVocabImage(req.getVocabImage());
        return item;
    }

    @Override
    public DocumentItemResponse createDocumentItem(DocumentItemRequest request) {
        DocumentItem item = toEntity(request);
        item = documentItemRepository.save(item);
        return toResponse(item);
    }

    @Override
    public List<DocumentItemResponse> getAllDocumentItems() {
        return documentItemRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentItemResponse getDocumentItemById(Long id) {
        DocumentItem item = documentItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("DocumentItem not found with id: " + id));
        return toResponse(item);
    }

    @Override
    public List<DocumentItemResponse> getDocumentItemsByListId(Long listId) {
        return documentItemRepository.findByDocumentList_ListId(listId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentItemResponse updateDocumentItem(Long id, DocumentItemRequest request) {
        DocumentItem item = documentItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("DocumentItem not found with id: " + id));
        DocumentList list = documentListRepository.findById(request.getListId())
                .orElseThrow(() -> new IllegalArgumentException("DocumentList not found with id: " + request.getListId()));
        item.setDocumentList(list);
        item.setWord(request.getWord());
        item.setMeaning(request.getMeaning());
        item.setExample(request.getExample());
        item.setVocabImage(request.getVocabImage());
        item = documentItemRepository.save(item);
        return toResponse(item);
    }

    @Override
    public void deleteDocumentItem(Long id) {
        documentItemRepository.deleteById(id);
    }
}

