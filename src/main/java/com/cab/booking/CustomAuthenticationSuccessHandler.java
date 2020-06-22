package com.cab.booking;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.cab.booking.entity.User;


@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	protected CustomAuthenticationSuccessHandler() {
		super();
	}

	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, 
			final Authentication authentication) throws IOException {
		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
	}

	protected void handle(final HttpServletRequest request, final HttpServletResponse response,
			final Authentication authentication) throws IOException {
		final String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(final Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		final Collection<? extends GrantedAuthority> authorities = user
				.getAuthorities();
		//if (!authorities.isEmpty()) {
			return "/welcome";
		/*} else {
			LOG.error("User authentication has been failed...");
			throw new IllegalStateException();
		}*/
//		return "/login";
	}

	/**
	 * Removes temporary authentication-related data which may have been stored
	 * in the session during the authentication process.
	 */
	protected final void clearAuthenticationAttributes(final HttpServletRequest request) {
		final HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public void setRedirectStrategy(final RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
}