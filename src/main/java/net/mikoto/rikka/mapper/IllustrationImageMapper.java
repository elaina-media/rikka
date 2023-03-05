package net.mikoto.rikka.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.mikoto.rikka.model.IllustrationImage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author mikoto
 * &#064;date 2023/3/5
 * Create for rikka
 */
@Mapper
public interface IllustrationImageMapper extends BaseMapper<IllustrationImage> {
}
