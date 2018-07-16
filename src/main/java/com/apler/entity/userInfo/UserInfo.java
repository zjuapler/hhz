package com.apler.entity.userInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    private String uid;
    private String nick;
    private String gender;
    private String birthday;
    private String area;
    private String type;

    @JsonProperty("avatar_version")
    private String avatarVersion;

    private String profile;
    private String status;

    @JsonProperty("emblem_adorn")
    private Emblem emblemAdorn;

    @JsonProperty("emblems")
    private List<Emblem> emblemList;

    @JsonProperty("cover_img")
    private String coverImg;

    @JsonProperty("is_follow")
    private int isFollow;

    private String avatar;

    @JsonProperty("big_avatar")
    private String bigAvatar;
}
