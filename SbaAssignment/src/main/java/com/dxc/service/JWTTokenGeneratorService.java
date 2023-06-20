package com.dxc.service;

import java.util.Date;
import java.util.Map;

import org.bouncycastle.jcajce.BCFKSLoadStoreParameter.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dxc.model.*;
@Service
public class JWTTokenGeneratorService implements TokenGeneratorService {

	@Value("${jwt.secret.key}")
	private String secretKey;
	
	
	@Override
	public Map<String, String> generateToken(UserCredential user) {
		String token = Jwts.builder().setSubject(String.valueOf(user.getUserId()))
				.setIssuer("NoteService")
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
				
		return Map.of("token",token);
	}

}
