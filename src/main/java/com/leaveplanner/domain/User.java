public class User {

    private final Long id;
    private final String name;
    private final String email;

    private final LocalDate enlistmentDate;
    private final LocalDate createdAt;

    public User(
        Long id,
        String name,
        String email,
        LocalDate enlistmentDate,
        LocalDate createdAt
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.enlistmentDate = enlistmentDate;
        this.createdAt = createdAt;
    }

    public LocalDate getEnlistmentDate() {
        return enlistmentDate;
    }
}