package pe.sld.inen.back.seguimiento.hc.entrypoint;
//package pe.sld.inen.back.seguimiento.hc.entrypoint;
//
//import java.io.IOException;
//import java.io.Serializable;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import pe.sld.inen.back.seguimiento.hc.bean.ResponseBeanGeneric;
//import pe.sld.inen.back.seguimiento.hc.util.Mensaje;
//
//@Component
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint,Serializable  {
//
//
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	public void commence(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException authException) throws IOException, ServletException {
//		ObjectMapper _mapper = new ObjectMapper();
//
//        response.setContentType("application/json");
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        response.getOutputStream().println(_mapper.writeValueAsString(new ResponseBeanGeneric("6000", Mensaje.CREDENCIALES_INVALIDAS.getMensaje(), null)));
//		
//	}
//
//}
