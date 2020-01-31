package com.ouyang.scorerank.controller.viewobject;

/**
 * @ClassName RankVO
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-30 15:41
 * @Version 1.0
 **/

/**
 * View object for frontend
 * */

public class RankVO {

    private Integer id;

    private String name;

    private Integer score;

    private String scoreDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getScoreDate() {
        return scoreDate;
    }

    public void setScoreDate(String scoreDate) {
        this.scoreDate = scoreDate;
    }
}
