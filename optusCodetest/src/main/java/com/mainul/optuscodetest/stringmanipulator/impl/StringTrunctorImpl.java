/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mainul.optuscodetest.stringmanipulator.impl;

import com.mainul.optuscodetest.stringmanipulator.IStringTrunctor;
import org.springframework.util.StringUtils;


/**
 *
 * @author Mainul
 */
public class StringTrunctorImpl implements IStringTrunctor{

    @Override
    public String shortenStringWithMark(String origStr, String markStr, int truncatedLen) {
        // If Original String or Marker is empty, no need to do anything 
        if(!StringUtils.hasLength(markStr) || !StringUtils.hasLength(origStr))
            return origStr;
        
        int origStringLen = origStr.length();
        int markStringLen = markStr.length();
        
        // If the original string length is less than truncated length, no need to do anything
        // if truncated length is lower than marker length no need to do anything
        if (origStringLen < truncatedLen || truncatedLen < markStringLen)
            return origStr;
        
        
        int tructedOrigContentLen = truncatedLen - markStringLen;
        int firstOffset = tructedOrigContentLen / 2 + tructedOrigContentLen % 2;
        int secondOffset = origStringLen - tructedOrigContentLen / 2;
        StringBuilder finalStringBld = new StringBuilder(truncatedLen);
        finalStringBld.append(origStr.substring(0, firstOffset));
        finalStringBld.append(markStr);
        finalStringBld.append(origStr.substring(secondOffset));
        
        return finalStringBld.toString();
    }
    
}
