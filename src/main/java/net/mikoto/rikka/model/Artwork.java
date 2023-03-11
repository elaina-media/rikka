package net.mikoto.rikka.model;

import lombok.Data;

import java.util.Date;

/**
 * @author mikoto
 * &#064;date 2023/2/26
 * Create for rikka
 */
@Data
public class Artwork {
    long artworkGlobalId;
    String title;
    String description;
    String coverUrl;
    long uploaderGlobalId;
    long authorGlobalId;
    int pagesCount;
    /**
     * If the pagesCount is bigger than 1, the id will be the first page of the image
     */
    long imageGlobalId;
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
    long nextArtworkGlobalId;
    String nextArtworkTitle;
    long previousArtworkGlobalId;
    String previousArtworkTitle;
}
