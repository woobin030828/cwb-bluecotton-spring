package com.app.bluecotton.service;

import com.app.bluecotton.domain.vo.chat.ChatMemberVO;
import com.app.bluecotton.repository.ChatMemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatMemberServiceImpl implements ChatMemberService {

    private final ChatMemberDAO chatMemberDAO;

    @Override
    public void createChatMember(ChatMemberVO chatMemberVO) {
        chatMemberDAO.insertChatMember(chatMemberVO);
    }

    @Override
    public void delete(ChatMemberVO chatMemberVO) {
        chatMemberDAO.delete(chatMemberVO);
    }
}
