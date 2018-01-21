package subject;

import observer.Observer;

public interface Subject {
    // 增加订阅者
    void insert(Observer observer);
    // 删除订阅者
    void delete(Observer observer);
    // 通知更新
    void notify(String message);
}
