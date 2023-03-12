package net.mikoto.rikka.model;

import lombok.Data;

import java.util.Date;

/**
 * @author mikoto
 * &#064;date 2023/3/5
 * Create for rikka
 */
@Data
public class Video {
    long videoGlobalId;
    String title;
    String description;
    String urlSmall;
    long uploaderGlobalId;
    long authorGlobalId;
    String url;
    String format;
    /**
     * Using unit: pixel
     */
    int wide;
    /**
     * Using unit: pixel
     */
    int height;
    int fps;
    /**
     * Using unit: bps
     */
    int bitRate;
    int bookmarkCount;
    int likeCount;
    int viewCount;
    int grading;
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
}
