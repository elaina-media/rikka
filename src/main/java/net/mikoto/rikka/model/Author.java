package net.mikoto.rikka.model;

import lombok.Data;

/**
 * @author mikoto
 * &#064;date 2023/2/25
 * Create for rikka
 */
@Data
public class Author {
    long authorGlobalId;
    String name;
    String avatar;
    String profile;
}
