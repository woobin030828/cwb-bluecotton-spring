package com.app.bluecotton.repository;

import com.app.bluecotton.domain.vo.chat.ChatMemberVO;
import com.app.bluecotton.mapper.ChatMemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class ChatMemberDAO {

    private final ChatMemberMapper chatMemberMapper;

    public void insertChatMember(ChatMemberVO chatMemberVO) {
        chatMemberMapper.insertChatMember(chatMemberVO);
    }

    public void delete(ChatMemberVO chatMemberVO) {
        chatMemberMapper.delete(chatMemberVO);
    }

}
