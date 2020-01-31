package com.ouyang.scorerank.service;

import com.ouyang.scorerank.dao.RankDOMapper;
import com.ouyang.scorerank.dataobject.RankDO;
import com.ouyang.scorerank.error.BusinessException;
import com.ouyang.scorerank.service.model.RankModel;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName RankServiceImpl
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-30 14:59
 * @Version 1.0
 **/

@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private RankDOMapper rankDOMapper;

    @Override
    public List<RankModel> listScore() {
        List<RankDO> rankDOList = rankDOMapper.listScore();
        List<RankModel> rankModelList = rankDOList.stream().map(rankDO -> {
            RankModel rankModel = this.convertFromDataObject(rankDO);
            return rankModel;
        }).collect(Collectors.toList());

        Collections.sort(rankModelList, new Comparator<RankModel>() {
            @Override
            public int compare(RankModel o1, RankModel o2) {
                if(o1.getScore() > o2.getScore()){
                    return -1;
                }else{
                    return 1;
                }
            }
        });

        return rankModelList;
    }

    @Override
    public List<RankModel> listLocalScore() {
        // create 5 local model for testing, no need to connect database
        RankModel rankModel;
        DateTime dateTime = DateTime.now();
        List<RankModel> rankModelList = new ArrayList<>();
        Random random = new Random();
        for(int i=0; i<10; i++){
            rankModel = new RankModel();
            rankModel.setId(i);
            rankModel.setName("model" + i);
            rankModel.setScore(random.nextInt(100-10)+10);
            rankModel.setScoreDate(dateTime);
            rankModelList.add(rankModel);
        }
        Collections.sort(rankModelList, new Comparator<RankModel>() {
            @Override
            public int compare(RankModel o1, RankModel o2) {
                if(o1.getScore() > o2.getScore()){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        return rankModelList;
    }

    @Override
    public void createScore(String name, Integer score) throws BusinessException {

    }

    private RankModel convertFromDataObject(RankDO rankDO) {
        if(rankDO == null){
            return null;
        }
        RankModel rankModel = new RankModel();
        BeanUtils.copyProperties(rankDO, rankModel);
        rankModel.setScoreDate(new DateTime(rankDO.getScoreDate()));
        return rankModel;
    }
}
