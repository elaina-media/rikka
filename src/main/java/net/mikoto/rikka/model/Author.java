package net.mikoto.rikka.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author mikoto
 * &#064;date 2023/2/25
 * Create for rikka
 */
@Data
public class  Author {
    @TableId(type = IdType.AUTO)
    long authorGlobalId;
    String name;
    String avatar;
    String profile;
}
