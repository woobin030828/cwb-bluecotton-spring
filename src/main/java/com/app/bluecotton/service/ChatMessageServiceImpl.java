package com.app.bluecotton.service;

import com.app.bluecotton.domain.vo.chat.ChatMessageVO;
import com.app.bluecotton.repository.ChatMessageDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageDAO chatMessageDAO;

    @Override
    public List<ChatMessageVO> selectAll(ChatMessageVO chatMessageVO) {
        return chatMessageDAO.selectAll(chatMessageVO);
    }

    @Override
    public void insert(ChatMessageVO chatMessageVO) {
        chatMessageDAO.insert(chatMessageVO);
    }

    @Override
    public void updateReadStatus(ChatMessageVO chatMessageVO) {
        chatMessageDAO.updateReadStatus(chatMessageVO);
    }
}
