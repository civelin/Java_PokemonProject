package attacks;

import users.User;

public interface IAttack {
    int attack(User user, User enemyUser);
}
