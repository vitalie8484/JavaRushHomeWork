package com.javarush.test.level26.lesson15.big01;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;
import java.util.*;
/**
 * Created by timerbaev_rr on 24.05.2016.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations;
    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }
    public String getCurrencyCode()
    {
        return currencyCode;
    }
    public void addAmount(int denomination, int count)
    {
        if (denominations==null)
            denominations= new HashMap<>();
        if (denominations.keySet().contains(denomination))
        {
            denominations.put(denomination,denominations.get(denomination)+count);
        }
        else
            denominations.put(denomination,count);
    }
    public int getTotalAmount()
    {
        int sum=0;
        for (Map.Entry<Integer,Integer> entry: denominations.entrySet())
        {
            sum+=(entry.getKey()*entry.getValue());
        }
        return sum;
    }
    public boolean  hasMoney()
    {
        boolean result=true;
        if (denominations.isEmpty()) result = false;
        else {
            int zerosCount=0;
            for (Map.Entry<Integer,Integer> pair : denominations.entrySet()){
                if (pair.getValue()==0) zerosCount++;
            }
            if (zerosCount==denominations.size()) result=false;
        }
        return result;
    }
    public boolean isAmountAvailable(int expectedAmount){
        if (expectedAmount <= getTotalAmount()) return true;
        return false;
    }
    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        TreeMap<Integer,Integer> amount = new TreeMap<>(Collections.reverseOrder());
        amount.putAll(denominations);
        Map<Integer,Integer> putAmount;
        int expected;
        while (!amount.isEmpty())
        {
            putAmount = new TreeMap<>(Collections.reverseOrder());
            expected = expectedAmount;
            for (Map.Entry<Integer, Integer> entry : amount.entrySet())
            {
                if (expected / entry.getKey() > 0 && entry.getValue() >= expected / entry.getKey())
                {
                    putAmount.put(entry.getKey(), expected / entry.getKey());
                    expected = expected - entry.getKey() * (int) (expected / entry.getKey());
                }
                else if(expected / entry.getKey() > 0 && entry.getValue() < expected / entry.getKey() && entry.getValue() > 0)
                {
                    putAmount.put(entry.getKey(), entry.getValue());
                    expected = expected - entry.getKey() * entry.getValue();
                }
            }
            if (expected == 0)
            {
                for (Map.Entry<Integer, Integer> entry : putAmount.entrySet())
                    denominations.put(entry.getKey(), denominations.get(entry.getKey()) - entry.getValue());
                return putAmount;
            }
            else{
                if (amount.get(amount.firstKey()) == 0) amount.remove(amount.firstKey());
                if (!amount.isEmpty()) amount.put(amount.firstKey(),amount.get(amount.firstKey())-1);
            }
        }
        throw new NotEnoughMoneyException();
    }
}