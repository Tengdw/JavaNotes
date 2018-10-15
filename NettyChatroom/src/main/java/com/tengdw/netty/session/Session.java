package com.tengdw.netty.session;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/8 9:33
 */
@Data
@NoArgsConstructor
public class Session {

    private String userId;
    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userId + ":" + userName;
    }
}
