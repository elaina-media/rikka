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
public class Artwork {
    @TableId()
    long artworkGlobalId;
    String title;
    String description;
    String coverUrl;
    long uploaderGlobalId;
    String uploaderName;
    long authorGlobalId;
    String authorName;
    int pagesCount;
    /**
     * If the pagesCount is bigger than 1, the id will be the first page of the image
     */
    long imageGlobalId;
    int bookmarkCount;
    int likeCount;
    int viewCount;
    Grading grading;
    String tags;
    Date createTime;
    Date updateTime;
    boolean isCollected;
    long collectionGlobalId;
    int collectionOrder;
    long nextMediaGlobalId;
    MediaType nextMediaType;
    String nextMediaTitle;
    long previousMediaGlobalId;
    MediaType previousMediaType;
    String previousMediaTitle;

    public enum Grading {
        ALL_AGES, R15, R18, R18G;
    }
}
