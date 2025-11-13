package com.app.bluecotton.service;

import com.app.bluecotton.domain.vo.chat.ChatMemberVO;

public interface ChatMemberService {
    public void createChatMember(ChatMemberVO chatMemberVO);
    public void delete(ChatMemberVO chatMemberVO);
}
