package com.jk.service;

import com.jk.bean.Game;
import com.jk.mapper.GameMapper;

import javax.annotation.Resource;
import java.util.List;

public interface GameService {

    List<Game> queryGame();

}
