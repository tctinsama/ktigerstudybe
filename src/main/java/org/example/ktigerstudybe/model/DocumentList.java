package org.example.ktigerstudybe.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "document_list")
public class DocumentList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ListID")
    private Long listId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "Type")
    private String type;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "IsPublic")
    private int isPublic;

    // Constructors

    public DocumentList() {
    }

    public DocumentList(User user, String title, String description, String type,
                        LocalDateTime createdAt, int isPublic) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.type = type;
        this.createdAt = createdAt;
        this.isPublic = isPublic;
    }

    // Getters & Setters

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }
}
