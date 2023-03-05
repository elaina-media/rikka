package net.mikoto.rikka.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.mikoto.rikka.mapper.IllustrationImageMapper;
import net.mikoto.rikka.model.IllustrationImage;
import net.mikoto.rikka.service.IllustrationImageService;
import org.springframework.stereotype.Service;

/**
 * @author mikoto
 * &#064;date 2023/3/5
 * Create for rikka
 */
@Service
public class IllustrationImageServiceImpl
        extends ServiceImpl<IllustrationImageMapper, IllustrationImage>
        implements IllustrationImageService {
}
