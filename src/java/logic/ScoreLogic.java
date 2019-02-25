/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.ScoreDAO;
import entity.Player;
import entity.Score;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khactoan9x
 */
public class ScoreLogic extends GenericLogic<Score, ScoreDAO> {

    public static final String ID = "scoreid";
    public static final String SCORE = "score";
    public static final String PLAYER_ID = "id";
    public static final String SUBMISSION = "submisstion";

    public ScoreLogic() {
        super(new ScoreDAO());

    }

    public List<Score> getAll() {

        return get(() -> dao().findAll());
    }

    public Score getByID(int id) {
        return get(() -> dao().findById(id));
    }

    public List<Score> getScoresWithId(int score) {
        return get(() -> dao().findByScore(score));
    }

    public List<Score> getScoreOnDate(Date submission) {
        return get(() -> dao().findBySubmission(submission));
    }

    public List<Score> getScoresForPlayerID(int playerid) {
        return get(() -> dao().findByPlayerID(playerid));
    }

    @Override
    public Score createEntity(Map<String, String[]> parameterMap) {
        Score score = new Score();
        Date date = java.util.Calendar.getInstance().getTime();
        PlayerLogic player = new PlayerLogic();
        Player play = new Player();
        play =  player.getPlayerWithId(Integer.valueOf(parameterMap.get(PLAYER_ID)[0]));
        if (play != null) {


            score.setPlayerid(play);
            score.setScore(Integer.valueOf(parameterMap.get(SCORE)[0]));
            score.setSubmission(date);
            add(score);
        }
        return score;
    }

}
