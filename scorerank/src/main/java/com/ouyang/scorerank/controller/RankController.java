package com.ouyang.scorerank.controller;

import com.ouyang.scorerank.controller.viewobject.RankVO;
import com.ouyang.scorerank.response.CommonReturnType;
import com.ouyang.scorerank.service.RankService;
import com.ouyang.scorerank.service.model.RankModel;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName RankController
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-30 15:16
 * @Version 1.0
 **/

@Controller
@RequestMapping("/rank")
@CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
public class RankController extends BaseController {

    @Autowired
    private RankService rankService;

    /**
     * Access to MySQL and retrieve data
     * */
    @RequestMapping(value = "/score", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getRankList(){

        List<RankModel> rankModelList = rankService.listScore();
        List<RankVO> rankVOList = rankModelList.stream().map(rankModel -> {
            RankVO rankVO = this.convertVOFromModel(rankModel);
            return rankVO;
        }).collect(Collectors.toList());
        return CommonReturnType.create(rankVOList);
    }


    /**
     * Access local data (for test)
     * */
    @RequestMapping(value = "/localscore", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getLocalRankList(){

        List<RankModel> rankLocalModelList = rankService.listLocalScore();
        List<RankVO> rankLocalVOList = rankLocalModelList.stream().map(rankLocalModel -> {
            RankVO rankLocalVO = this.convertVOFromModel(rankLocalModel);
            return rankLocalVO;
        }).collect(Collectors.toList());

        return CommonReturnType.create(rankLocalVOList);
    }

    private RankVO convertVOFromModel(RankModel rankModel) {
        if(rankModel == null) {
            return null;
        }

        RankVO rankVO = new RankVO();
        BeanUtils.copyProperties(rankModel, rankVO);
        rankVO.setId(rankModel.getId());
        rankVO.setName(rankModel.getName());
        rankVO.setScore(rankModel.getScore());
        rankVO.setScoreDate(rankModel.getScoreDate().toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));

        return rankVO;
    }


}
