package com.system.demo.util;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UniqId {
	
	public Long generateUniqueId()
    {	//maxId = 9000000000000000
        long val = -1;
        do
        {
            final UUID uid = UUID.randomUUID();
            final ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
            buffer.putLong(uid.getLeastSignificantBits());
            buffer.putLong(uid.getMostSignificantBits());
            final BigInteger bi = new BigInteger(buffer.array());
            val = bi.longValue();
        } 
         // También nos aseguramos de que el ID esté en un espacio positivo, si no es así, simplemente repetimos el proceso.
        while (val < 0);
        return val;
    }
	
	//private Random random = new Random();
	//Generador de claves unicas en formato Long
	public Long uniqid()
	{
		long time = System.currentTimeMillis();
		String generator = "";
		SecureRandom sec = new SecureRandom();
		byte[] sbuf = sec.generateSeed(8);
		ByteBuffer bb = ByteBuffer.wrap(sbuf);
		generator = String.format("%d%.3s", time, Math.abs(bb.getLong()));
		Long Uniqid=Long.parseLong(generator);
		return Uniqid;
	}
	
	//private Random random = new Random();
	//Generador de claves unicas en formato Long
	public Long uniqid(byte prefix, boolean more_entropy)
	{
		long time = System.currentTimeMillis();
		String generator = "";
		if(!more_entropy)
		{
			generator = String.format("%d%d", prefix, time);
		}else
		{
			SecureRandom sec = new SecureRandom();
			byte[] sbuf = sec.generateSeed(8);
			ByteBuffer bb = ByteBuffer.wrap(sbuf);

			generator = String.format("%d%d%.3s", prefix, time, Math.abs(bb.getLong()));
		}
		Long Uniqid=Long.parseLong(generator);
		return Uniqid;
	}
	
	//Generador de claves unicas en formato String
	public String uniqid(String prefix, boolean more_entropy)
	{
		long time = System.currentTimeMillis();
		//String uniqid = String.format("%fd%05f", Math.floor(time),(time-Math.floor(time))*1000000);
		//uniqid = uniqid.substring(0, 13);
		String uniqid = "";
		if(!more_entropy)
		{
			uniqid = String.format("%s%08x%05x", prefix, time/1000, time);
		}else
		{
			SecureRandom sec = new SecureRandom();
			byte[] sbuf = sec.generateSeed(8);
			ByteBuffer bb = ByteBuffer.wrap(sbuf);
			//formato %s string, %08x llenar 0 y hexadecimales en 8 espacion
			uniqid = String.format("%s%08x%05x", prefix, time/1000, time);
			uniqid += "." + String.format("%.8s", ""+bb.getLong()*-1);
		}
		return uniqid;
	}
	
}
