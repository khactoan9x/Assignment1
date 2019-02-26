package logic;

import dao.UsernameDAO;
import entity.Player;
import entity.Username;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Shariar
 */
public class UsernameLogic extends GenericLogic<Username, UsernameDAO> {

    public static final String PLAYER_ID = "id";
    public static final String USERNAME = "username";

    public UsernameLogic() {
        super(new UsernameDAO());

    }

    public List<Username> getAll() {

        return get(() -> dao().findAll());
    }

    public Username getByID(int playerID) {
        return get(() -> dao().findByPlayerID(playerID));
    }

    public List<Username> getByUserName(String username) {
        return get(() -> dao().findByUsername(username));
    }

    public Username createEntity(Map<String, String[]> parameterMap) {
        Username user = new Username();
        PlayerLogic playerLogic = new PlayerLogic();
        System.out.println(parameterMap.get(PLAYER_ID)[0]);
        System.out.println(parameterMap.get(USERNAME)[0]);
        Player player = playerLogic.getPlayerWithId(Integer.valueOf(parameterMap.get(PLAYER_ID)[0]));
        user.setPlayer(player);
        user.setPlayerid(Integer.valueOf(parameterMap.get(PLAYER_ID)[0]));
        user.setUsername(parameterMap.get(USERNAME)[0]);
        System.out.println("created");
        return user;
    }
}
