package net.mikoto.rikka.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.mikoto.rikka.model.Collection;
import net.mikoto.rikka.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * @author mikoto
 * &#064;date 2023/3/19
 * Create for rikka
 */
@RestController
public class CollectionRestController {
    private final CollectionService collectionService;

    @Autowired
    public CollectionRestController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @RequestMapping(
            value = "/collection/createSingle",
            method = RequestMethod.POST
    )
    public JSONObject createCollection(@RequestParam Map<String, Object> params) {
        Collection collection = JSON.to(Collection.class, params);
        collection.setCreateTime(new Date());
        collection.setUpdateTime(new Date());

        collectionService.save(collection);
        QueryWrapper<Collection> collectionQueryWrapper = new QueryWrapper<>();
        collectionQueryWrapper.eq("title", collection.getTitle()).select();
        collection = collectionService.getOne(collectionQueryWrapper);
        return JSONObject.from(collection);
    }

    @RequestMapping(
            value = "/collection/initCollection",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8"
    )
    public void initCollection(@RequestBody JSONObject jsonParam) {
        System.out.println(jsonParam);
    }
}
