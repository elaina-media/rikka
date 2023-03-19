package net.mikoto.rikka.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.mikoto.rikka.mapper.CollectionMapper;
import net.mikoto.rikka.model.Collection;
import net.mikoto.rikka.service.CollectionService;
import org.springframework.stereotype.Service;

/**
 * @author mikoto
 * &#064;date 2023/3/12
 * Create for rikka
 */
@Service
public class CollectionServiceImpl
        extends ServiceImpl<CollectionMapper, Collection>
        implements CollectionService {
}
