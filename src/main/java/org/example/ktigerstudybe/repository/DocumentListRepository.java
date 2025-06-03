package org.example.ktigerstudybe.repository;

import org.example.ktigerstudybe.model.DocumentList;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DocumentListRepository extends CrudRepository<DocumentList, Long>{

    List<DocumentList> findByUser_UserId(Long userId);

    List<DocumentList> findByIsPublic(int isPublic);

    List<DocumentList> findByTitleContainingIgnoreCase(String keyword);
}
