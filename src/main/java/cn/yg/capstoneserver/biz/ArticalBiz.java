package cn.yg.capstoneserver.biz;

import cn.yg.capstoneserver.entity.Artical;
import cn.yg.capstoneserver.entity.Setting;
import cn.yg.capstoneserver.entity.User;
import cn.yg.capstoneserver.entity.vo.ArticalVo;
import cn.yg.capstoneserver.mapper.ArticalMapper;
import cn.yg.capstoneserver.mapper.UserCollectionMapper;
import cn.yg.capstoneserver.mapper.UserFocusMapper;
import cn.yg.capstoneserver.mapper.UserLikeRefMapper;
import cn.yg.capstoneserver.utils.Query;
import cn.yg.capstoneserver.utils.biz.BaseBiz;
import cn.yg.capstoneserver.utils.response.ObjectResponseResult;
import cn.yg.capstoneserver.utils.response.QueryResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.jsoup.Jsoup;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticalBiz extends BaseBiz<ArticalMapper, Artical> {

    @Autowired
    private UserBiz userBiz;
    @Autowired
    private SettingBiz settingBiz;
    @Autowired
    private UserCollectionMapper userCollectionMapper;
    @Autowired
    private UserLikeRefMapper userLikeRefMapper;
    @Autowired
    private UserFocusMapper userFocusMapper;

    public ObjectResponseResult<Artical> add(Artical entity) {
        User user = userBiz.selectById(entity.getUid());
        if (user == null) {
            return ObjectResponseResult.getInstance()
                    .message("作者不存在")
                    .success(false);
        }
        entity.setUname(user.getName());
        entity.setCrtTime(new Date());
        mapper.insertSelective(entity);
        return ObjectResponseResult.getInstance().message("发表成功");
    }

    public QueryResponseResult detailList(Query query) {
        QueryResponseResult<Artical> queryResponseResult = selectByQuery(query);
        String uid = (String) query.get("uid");
        uid = uid!=null ? uid : (String) query.get("uid_eq");
        if (uid == null) {
            throw new RuntimeException("必须传入uid或者uid_eq");
        }
        List<Integer> aidsOfCollection = userCollectionMapper.selectAids(uid);
        List<Integer> aidsOfUserLike = userLikeRefMapper.selectAids(uid);
        List<String> focusIds = userFocusMapper.getFocusIds(uid);
        Setting setting = settingBiz.selectById(1);
        int wordNum = 86;
        String wordExceed = "...";
        if (setting != null) {
            wordNum = setting.getWordNum();
            wordExceed = setting.getWordExceed();
        }
        int wn = wordNum;
        String we = wordExceed;
        List<ArticalVo> articalVos = new ArrayList<>();
        queryResponseResult.getData().forEach(artical -> {
            String summery = Jsoup.parse(artical.getContent()).text();
            if (summery.length() > wn) {
                summery = summery.substring(0, wn);
            }
            summery = summery + we;
            artical.setContent(summery);
            ArticalVo articalVo = new ArticalVo();
            BeanUtils.copyProperties(artical, articalVo);
            if (aidsOfUserLike.contains(artical.getId())) {
                articalVo.setIsLike(true);
            }
            if (aidsOfCollection.contains(artical.getId())) {
                articalVo.setIsCollected(true);
            }
            if (focusIds.contains(artical.getUid())) {
                articalVo.setIsFocus(true);
            }

            articalVos.add(articalVo);
        });

        return QueryResponseResult.getInstance()
                .data(articalVos)
                .total(queryResponseResult.getTotal());
    }

    public ObjectResponseResult getDetail(int id) {
        return null;
    }

    public QueryResponseResult getTeacherArtical(Query query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<Artical> articals = mapper.selectByIdentity(2);
        PageInfo<Artical> pageInfo = new PageInfo<>(articals);
        return QueryResponseResult.getInstance()
                .data(pageInfo.getList())
                .total(pageInfo.getTotal());
    }

    public QueryResponseResult getMajorArtical(Query query) {
        Integer mid = Integer.parseInt(String.valueOf(query.get("mid")));
        if (mid == null) {
            throw new RuntimeException("mid不能为null");
        }
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<Artical> articals = mapper.selectByMid(mid);
        PageInfo<Artical> pageInfo = new PageInfo<>(articals);
        return QueryResponseResult.getInstance()
                .data(pageInfo.getList())
                .total(pageInfo.getTotal());
    }


    public ObjectResponseResult selectCollection(Query query) {
        return null;
    }
}
