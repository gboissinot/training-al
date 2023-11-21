package fr.gboissinot.al.tps.oop.tp6;

// Brings all application use cases
final class UserService {

    //Use of DIP pattern
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get(User user) {
        return userRepository.getById(user.getId());
    }

    //Registration Use case
    public void register(User user) {
        userRepository.save(user);
    }
}
