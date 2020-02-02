package com.ouyang.scorerank.service.model;

import org.joda.time.DateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName RankModel
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-30 14:55
 * @Version 1.0
 **/

public class RankModel {

    private Integer id;

    @NotBlank(message = "Player name can't be null")
    private String name;

    @NotBlank(message = "Player score can't be null")
    @Min(value = 0, message = "Score can't be less than 0")
    private Integer score;

    @NotNull(message = "The date can't be null")
    private Date scoreDate;

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

    public Date getScoreDate() {
        return scoreDate;
    }

    public void setScoreDate(Date scoreDate) {
        this.scoreDate = scoreDate;
    }
}
