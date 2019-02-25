/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.PlayerDAO;
import entity.Player;
import entity.Username;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khactoan9x
 */
public class PlayerLogic extends GenericLogic<Player, PlayerDAO> {

    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String JOINED = "joined";
    public static final String EMAIL = "email";
    public static final String ID = "id";

    public PlayerLogic() {
        super(new PlayerDAO());

    }

    public List<Player> getAll() {

        return get(() -> dao().findAll());
    }

    public Player getByID(int id) {
        return get(() -> dao().findById(id));
    }

    public Player getPlayerWithId(int id) {
        return get(() -> dao().findById(id));
    }

    public List<Player> getPlayersWithFirstName(String firstName) {
        return get(() -> dao().findByFirstName(firstName));
    }

    public List<Player> getPlayersWIthLastName(String lastName) {
        return get(() -> dao().findByLastName(lastName));
    }

    public List<Player> getPlayersJoinedOn(Date date) {
        return get(() -> dao().findByJoined(date));
    }

    public Player getPlayersByEmail(String email) {
        return get(() -> dao().findByEmail(email));
    }

    @Override
    public Player createEntity(Map<String, String[]> parameterMap) {
        Player player = new Player();
        Date date = java.util.Calendar.getInstance().getTime();
        player.setId(Integer.valueOf(parameterMap.get(ID)[0]));
        player.setFirstName(parameterMap.get(FIRST_NAME)[0]);
        player.setLastName(parameterMap.get(LAST_NAME)[0]);
        player.setJoined(date);
        player.setEmail(parameterMap.get(EMAIL)[0]);
//        if ((getPlayerWithId(Integer.valueOf(parameterMap.get(ID)[0])) == null)
//                && (getPlayersByEmail(parameterMap.get(EMAIL)[0]) == null)
//                && (getPlayersByEmail(parameterMap.get(EMAIL)[0]).length() < 50)) {
        if ((parameterMap.get(ID)[0] != null) && (parameterMap.get(EMAIL)[0] != null) && (parameterMap.get(EMAIL)[0].length() < 50)) {
            add(player);
//            UsernameLogic userlogic = new UsernameLogic();
//            Username username = userlogic.createEntity(parameterMap);
//            userlogic.add(username);
        }

        return player;
    }

}
