package org.xiangkui;

import org.hibernate.Session;

@FunctionalInterface
public interface ExecInterface {
    void exec(Session session);
}
