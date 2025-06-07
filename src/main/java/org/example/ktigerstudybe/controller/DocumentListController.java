package org.example.ktigerstudybe.controller;

import org.example.ktigerstudybe.dto.req.DocumentListRequest;
import org.example.ktigerstudybe.dto.resp.DocumentListResponse;
import org.example.ktigerstudybe.service.documentList.DocumentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document-lists")
public class DocumentListController {

    @Autowired
    private DocumentListService documentListService;

    @PostMapping
    public DocumentListResponse create(@RequestBody DocumentListRequest request) {
        return documentListService.createDocumentList(request);
    }

    @GetMapping
    public List<DocumentListResponse> getAll() {
        return documentListService.getAllDocumentLists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentListResponse> getById(@PathVariable Long id) {
        try {
            DocumentListResponse resp = documentListService.getDocumentListById(id);
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}")
    public List<DocumentListResponse> getByUser(@PathVariable Long userId) {
        return documentListService.getDocumentListsByUserId(userId);
    }

    @GetMapping("/public")
    public List<DocumentListResponse> getPublic() {
        return documentListService.getPublicDocumentLists();
    }

    @GetMapping("/search")
    public List<DocumentListResponse> search(@RequestParam String keyword) {
        return documentListService.searchByTitle(keyword);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentListResponse> update(@PathVariable Long id, @RequestBody DocumentListRequest request) {
        try {
            DocumentListResponse resp = documentListService.updateDocumentList(id, request);
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        documentListService.deleteDocumentList(id);
        return ResponseEntity.noContent().build();
    }
}
