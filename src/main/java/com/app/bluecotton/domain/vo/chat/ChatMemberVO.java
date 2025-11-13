package com.app.bluecotton.domain.vo.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMemberVO {
    private Long id;
    private Long memberId;
    private Long chatId;
    private String chatMemberRole;
    private String chatMemberStatus;

    public ChatMemberVO(ChatMessageVO chatMessageVO) {
        this.chatId = chatMessageVO.getChatId();
        this.memberId = chatMessageVO.getChatMessageSenderId();
        this.chatMemberRole = "USER";
    }
}