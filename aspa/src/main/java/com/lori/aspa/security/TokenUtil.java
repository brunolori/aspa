package com.lori.aspa.security;

import java.util.Calendar;

import com.lori.aspa.dto.UserDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

public class TokenUtil {

	public static String getUsername(String token)
	{
		String jwt = token.substring(7);
		Claims claims = Jwts.parser().setSigningKey(TextCodec.BASE64.decode(SecurityConstants.SECRET))
			       .parseClaimsJws(jwt).getBody();
			    
		return claims.getSubject();
	}
	
	
	public static String generateToken(UserDTO user)
	{
		String jws = Jwts.builder()
				  .setIssuer("ASPA")
				  .setSubject(user.getUsername())
				  .claim("u_id", user.getId())
				  .setIssuedAt(Calendar.getInstance().getTime())
				//  .setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
				  .signWith(
				    SignatureAlgorithm.HS256,
				    TextCodec.BASE64.decode(SecurityConstants.SECRET)
				  )
				  .compact();
		
		return SecurityConstants.TOKEN_PREFIX+jws;
	}
	
	
	
}
