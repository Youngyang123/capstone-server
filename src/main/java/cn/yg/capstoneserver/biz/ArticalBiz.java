package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.Artical;
import cn.yg.capstoneserver.entity.Setting;
import cn.yg.capstoneserver.entity.User;
import cn.yg.capstoneserver.mapper.ArticalMapper;
import cn.yg.capstoneserver.utils.Query;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class ArticalBiz extends BaseBiz<ArticalMapper, Artical> {

    @Autowired
    private UserBiz userBiz;
    @Autowired
    private SettingBiz settingBiz;


    public ObjectResponseResult<Artical> add(Artical entity) {
        User user = userBiz.selectById(entity.getUid());
        if(user == null) {
            return ObjectResponseResult.getInstance()
                    .message("作者不存在")
                    .success(false);
        }
        entity.setUname(user.getName());
        entity.setCrtTime(new Date());
        mapper.insertSelective(entity);
        return ObjectResponseResult.getInstance().message("发表成功");
    }

    public QueryResponseResult<Artical> detailList(Query query) {
        QueryResponseResult<Artical> queryResponseResult = selectByQuery(query);
        Setting setting = settingBiz.selectById(1);
        int wordNum = 86;
        String wordExceed = "...";
        if (setting != null) {
            wordNum = setting.getWordNum();
            wordExceed = setting.getWordExceed();
        }
        int wn = wordNum;
        String we = wordExceed;
        queryResponseResult.getData().forEach(artical -> {
            String summery = Jsoup.parse(artical.getContent()).text();
            if (summery.length() > wn) {
                summery = summery.substring(0, wn);
            }
            summery = summery + we;
            artical.setContent(summery);
        });
        return queryResponseResult;
    }

    public ObjectResponseResult getDetail(int id) {
        return null;
    }


}
