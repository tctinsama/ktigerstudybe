package org.example.ktigerstudybe.service.documentList;

import org.example.ktigerstudybe.model.DocumentList;

import java.util.List;
import java.util.Optional;

public interface DocumentListService {

    // Tạo mới một danh sách tài liệu
    DocumentList createDocumentList(DocumentList documentList);

    // Lấy danh sách tất cả các DocumentList
    List<DocumentList> getAllDocumentLists();

    // Lấy DocumentList theo ID
    Optional<DocumentList> getDocumentListById(Long listId);

    // Cập nhật thông tin một DocumentList
    DocumentList updateDocumentList(Long listId, DocumentList updatedDocumentList);

    // Xóa một DocumentList theo ID
    void deleteDocumentList(Long listId);

    // Lấy tất cả DocumentList của một User cụ thể
    List<DocumentList> getDocumentListsByUserId(Long userId);

    // Lấy tất cả DocumentList công khai
    List<DocumentList> getPublicDocumentLists();

    // Tìm kiếm theo tiêu đề chứa từ khóa
    List<DocumentList> searchByTitle(String keyword);
}
