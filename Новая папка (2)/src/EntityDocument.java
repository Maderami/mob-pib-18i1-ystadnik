import sun.security.krb5.internal.AuthorizationDataEntry;

import java.time.LocalDate;


public class EntityDocument {

    private int id;
    private String title;
    private String author;
    private LocalDate creationDate;
    private LocalDate registrationDate;
    private String status;

    public EntityDocument(int id, String title, String author, LocalDate creationDate, LocalDate registrationDate, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.creationDate = creationDate;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public EntityDocument(int id,String title) {

        this(id, title, null, null, null, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Documents{" +
                "Title:'" + title + '\'' +
                ", Id:" + id +
                ", Author:" + author +
                ", Datecreate:" + creationDate +
                ", Dateregistration:" + registrationDate +
                ", Status:" + status +
                '}';
    }

}
