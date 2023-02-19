package net.mikoto.rikka.controller;

import net.mikoto.yukino.manager.YukinoModelManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author mikoto
 * &#064;date 2023/2/11
 * Create for rikka
 */
@RestController
public class RikkaRestController {
    private final YukinoModelManager yukinoModelManager;

    @Autowired
    public RikkaRestController(YukinoModelManager yukinoModelManager) {
        this.yukinoModelManager = yukinoModelManager;
    }
}
