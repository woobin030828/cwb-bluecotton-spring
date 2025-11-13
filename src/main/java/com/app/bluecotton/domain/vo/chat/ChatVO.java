package com.app.bluecotton.domain.vo.chat;

import com.app.bluecotton.domain.dto.ChatCreateDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ChatVO {
    private Long id;
    private String chatTitle;
    private String chatType;
    private Long chatOwnerId;
    private Date chatCreateAt;
    private String chatStatus;
    private Integer chatMemberCount;

    private List<ChatMemberVO> members;

    public ChatVO(ChatCreateDTO chatCreateDTO) {
        this.chatTitle = chatCreateDTO.getChatTitle();
        this.chatType = chatCreateDTO.getChatType();
    }
}
