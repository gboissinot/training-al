package fr.gboissinot.al.tps.oop.tp23;

final class User {

    private final UserId id;
    private final String name;
    private String hashedPassword;

    public User(UserId id, String name, String hashedPassword) {
        this.id = id;
        this.name = name;
        this.hashedPassword = hashedPassword;
    }

    public UserId getId() {
        return id;
    }

    public void changePassword(String newHashedPassword) {
        this.hashedPassword = newHashedPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                '}';
    }
}
