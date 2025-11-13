package com.app.bluecotton.mapper;

import com.app.bluecotton.domain.vo.chat.ChatMemberVO;
import com.app.bluecotton.domain.vo.chat.ChatMessageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatMessageMapper {
    public List<ChatMessageVO> selectAll(ChatMessageVO chatMessageVO);
    public void insert(ChatMessageVO chatMessageVO);
    public void updateReadStatus(ChatMessageVO chatMessageVO);
}
