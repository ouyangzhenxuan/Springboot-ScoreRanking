package com.ouyang.scorerank.service;

import com.ouyang.scorerank.error.BusinessException;
import com.ouyang.scorerank.service.model.RankModel;

import java.text.ParseException;
import java.util.List;

public interface RankService {
    List<RankModel> listScore();

    List<RankModel> listLocalScore();

    RankModel createScore(String name, Integer score) throws BusinessException, ParseException;
}
