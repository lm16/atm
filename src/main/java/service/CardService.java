package service;

import entity.Bill;
import entity.Card;

public interface CardService {
    String showMoney(Card card);
    String updateMoney(Card a, Bill bill, Card b);
}
