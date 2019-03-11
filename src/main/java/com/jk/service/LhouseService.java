package com.jk.service;

import java.util.List;

public interface LhouseService {
    List queryhouse(Integer userid);

    void inserthouse(Integer userid, String mintitle);
}
