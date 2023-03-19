package net.mikoto.rikka.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import net.mikoto.rikka.model.Collection;
import net.mikoto.rikka.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public boolean createCollection(@RequestParam Map<String,Object> params) {
        Collection collection = JSON.to(Collection.class, params);
        return collectionService.save(collection);
    }
}
