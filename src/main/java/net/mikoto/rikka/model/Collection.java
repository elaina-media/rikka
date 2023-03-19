package net.mikoto.rikka.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author mikoto
 * &#064;date 2023/2/26
 * Create for rikka
 */
@Data
public class Collection {
    @TableId
    long collectionGlobalId;
    String title;
    String description;
    String coverUrl;
    long uploaderGlobalId;
    long firstMediaGlobalId;
    MediaType firstMediaType;
    int bookmarkCount;
    int likeCount;
    int viewCount;
    int grading;
    String tags;
    Date createTime;
    Date updateTime;
}
