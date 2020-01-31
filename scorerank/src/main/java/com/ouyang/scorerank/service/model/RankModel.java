package com.ouyang.scorerank.service.model;

import org.joda.time.DateTime;

/**
 * @ClassName RankModel
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-30 14:55
 * @Version 1.0
 **/

public class RankModel {

    private Integer id;

    private String name;

    private Integer score;

    private DateTime scoreDate;

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

    public DateTime getScoreDate() {
        return scoreDate;
    }

    public void setScoreDate(DateTime scoreDate) {
        this.scoreDate = scoreDate;
    }
}
