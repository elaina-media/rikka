package net.mikoto.rikka.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.mikoto.rikka.mapper.AuthorMapper;
import net.mikoto.rikka.model.Author;
import net.mikoto.rikka.service.AuthorService;
import org.springframework.stereotype.Service;

/**
 * @author mikoto
 * &#064;date 2023/3/19
 * Create for rikka
 */
@Service
public class AuthorServiceImpl
        extends ServiceImpl<AuthorMapper, Author>
        implements AuthorService {
}
