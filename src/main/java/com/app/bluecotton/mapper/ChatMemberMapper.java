package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.vo.chat.ChatMemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMemberMapper {
    public void insertChatMember(ChatMemberVO chatMemberVO);

    public void delete(ChatMemberVO chatMemberVO);
}
