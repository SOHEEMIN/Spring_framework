package com.its.member.DTO;

import lombok.Data;

@Data
public class MemberDTO {
    private String memberId;
    private String memberPassword;
    private String memberName;
    private int memberAge;
    private String memberPhone;
}
