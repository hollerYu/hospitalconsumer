package com.jk.service.impl;

import com.jk.bean.Game;
import com.jk.mapper.GameMapper;
import com.jk.service.GameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Resource
    private GameMapper gameMapper;

    @Override
    public List<Game> queryGame() {

        return gameMapper.queryGame();
    }
}
