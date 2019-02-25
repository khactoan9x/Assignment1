/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.Score;
import entity.Username;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khactoan9x
 */
public class ScoreDAO extends GenericDAO<Score> {

    public ScoreDAO() {
        super(Score.class);
    }
    
    public List<Score> findAll(){
        return findResults( "Score.findAll", null);
    }
    public Score findById( int id){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return findResult( "Score.findById", map);
    }
    
    public List<Score> findByScore( int score){
        Map<String, Object> map = new HashMap<>();
        map.put("score", score);
        return findResults( "Score.findByScore", map);
    }
    public List<Score> findBySubmission (Date submission){
        Map<String, Object> map = new HashMap<>();
        map.put("submission", submission);
        return findResults( "Score.findBySubmission", map);        
    }
    
     public List<Score> findByPlayerID( int playerid){
        Map<String, Object> map = new HashMap<>();
        map.put("playerid", playerid);
        return findResults( "Score.findByPlayerID", map);
    }

}

   

