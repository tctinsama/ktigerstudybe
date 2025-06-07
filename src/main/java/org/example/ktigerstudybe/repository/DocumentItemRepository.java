package org.example.ktigerstudybe.repository;

import org.example.ktigerstudybe.model.DocumentItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentItemRepository extends JpaRepository<DocumentItem, Long> {
    List<DocumentItem> findByDocumentList_ListId(Long listId);
}
