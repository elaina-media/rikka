package net.mikoto.rikka.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import net.mikoto.rikka.model.Author;
import net.mikoto.rikka.model.Uploader;
import net.mikoto.rikka.service.AuthorService;
import net.mikoto.rikka.service.UploaderService;
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
public class UserRestController {
    private final AuthorService authorService;
    private final UploaderService uploaderService;

    @Autowired
    public UserRestController(AuthorService authorService, UploaderService uploaderService) {
        this.authorService = authorService;
        this.uploaderService = uploaderService;
    }

    @RequestMapping(
            value = "/author/create",
            method = RequestMethod.POST
    )
    public boolean createAuthor(@RequestParam Map<String,Object> params) {
        Author author = JSON.to(Author.class, params);
        return authorService.save(author);
    }

    @RequestMapping(
            value = "/uploader/create",
            method = RequestMethod.POST
    )
    public boolean createUploader(@RequestParam Map<String,Object> params) {
        Uploader uploader = JSON.to(Uploader.class, params);
        return uploaderService.save(uploader);
    }
}
