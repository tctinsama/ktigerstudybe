package org.example.ktigerstudybe.controller;

import org.example.ktigerstudybe.dto.req.DocumentItemRequest;
import org.example.ktigerstudybe.dto.resp.DocumentItemResponse;
import org.example.ktigerstudybe.service.documentItem.DocumentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document-items")
public class DocumentItemController {

    @Autowired
    private DocumentItemService documentItemService;

    @PostMapping
    public DocumentItemResponse create(@RequestBody DocumentItemRequest request) {
        return documentItemService.createDocumentItem(request);
    }

    @GetMapping
    public List<DocumentItemResponse> getAll() {
        return documentItemService.getAllDocumentItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentItemResponse> getById(@PathVariable Long id) {
        try {
            DocumentItemResponse resp = documentItemService.getDocumentItemById(id);
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list/{listId}")
    public List<DocumentItemResponse> getByList(@PathVariable Long listId) {
        return documentItemService.getDocumentItemsByListId(listId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentItemResponse> update(@PathVariable Long id, @RequestBody DocumentItemRequest request) {
        try {
            DocumentItemResponse resp = documentItemService.updateDocumentItem(id, request);
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        documentItemService.deleteDocumentItem(id);
        return ResponseEntity.noContent().build();
    }
}

