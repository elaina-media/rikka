package net.mikoto.rikka.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.mikoto.rikka.mapper.UploaderMapper;
import net.mikoto.rikka.model.Uploader;
import net.mikoto.rikka.service.UploaderService;
import org.springframework.stereotype.Service;

/**
 * @author mikoto
 * &#064;date 2023/3/19
 * Create for rikka
 */
@Service
public class UploaderServiceImpl
        extends ServiceImpl<UploaderMapper, Uploader>
        implements UploaderService {
}
