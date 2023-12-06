package com.prueba_tecnica.monitoreo.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class TokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenUtils tokenUtils;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Obtén el token de la solicitud (implementa la lógica según tu caso)
        String bearerToken = request.getHeader("Authorization");
        System.out.println(bearerToken);

        // Si tienes el token, autentica al usuario
        if (bearerToken != null && bearerToken.startsWith("Bearer")){
            String token = bearerToken.replace("Bearer ", "");
            UsernamePasswordAuthenticationToken usernamePAT = tokenUtils.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(usernamePAT);
        }
        filterChain.doFilter(request,response);

    }
}
