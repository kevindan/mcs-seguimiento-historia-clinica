package pe.sld.inen.back.seguimiento.hc.util;
//package pe.sld.inen.back.seguimiento.hc.util;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import pe.sld.inen.back.seguimiento.hc.model.Usuario;
//
//@Component
////@PropertySource(value = { "classpath:mcs-consulta-trabajador-hogar.properties" })
//@PropertySource(value = { "file:/opt/data/mcs-trabajo/properties/mcs-consulta-trabajador-hogar.properties" })
//public class JwtTokenUtility implements Serializable {
//
//	
//	private static final long serialVersionUID = 1L;
//	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
//	
//	@Value("${jwt.secret}")
//	private String secret;
//	
//	
//	public String getUsernameFromToken(String token) {
//		return getClaimFromToken(token, Claims::getSubject);
//	}
//	
//	public Date getExpirationDateFromToken(String token) {
//		return getClaimFromToken(token, Claims::getExpiration);
//	}
//	
//	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//		final Claims claims = getAllClaimsFromToken(token);
//		return claimsResolver.apply(claims);
//	}
//	
//	public Claims getAllClaimsFromToken(String token) {
//		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//	}
//	
//	private Boolean isTokenExpired(String token) {
//		final Date expiration = getExpirationDateFromToken(token);
//		return expiration.before(new Date());
//	}
//	
//	public String generateToken(UserDetails userDetails, Usuario usuario) {
//		Map<String, Object> claims = new HashMap<>();
//		claims.put("usuario", usuario);
//		return doGenerateToken(claims, userDetails.getUsername());
//	}
//	
//	public String doGenerateToken(Map<String, Object> claims, String subject) {
//		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
//				.signWith(SignatureAlgorithm.HS512, secret).compact();
//	}
//	
//	public Boolean validateToken(String token, UserDetails userDetails) {
//		final String username = getUsernameFromToken(token);
//		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//	}
//	
//	public Usuario getUsuarioToken(String token) throws Exception {
//		ObjectMapper mapper = new ObjectMapper();
//		Map<String, Object> claims = new HashMap<>();
//		claims = this.getAllClaimsFromToken(token);
//		String json = mapper.writeValueAsString(claims.get("usuario"));
//		return  mapper.readValue(json, Usuario.class);		
//	}
//	
//}
