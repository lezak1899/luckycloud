package edu.lingnan.luckycloud.luckycore.modules.user.domain.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("lc_user")
public class User {
    private String id;
    private String username;
    private String gender;
    private String password;
    private String phone;
    private String faceImg;
    private String faceImgWhole;
    private String nickname;
    private String qrcode;
    private String plusId;
    private String funSignature;
    private Long lastLoginDate;
    private String lastLoginLocation;
    private String lastLoginEquipment;
    private String isValid;
    private Long createdDate;
    private Long modifiedDate;
    private Long deletedDate;
}
