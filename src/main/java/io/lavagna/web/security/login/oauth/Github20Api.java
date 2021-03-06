/**
 * This file is part of lavagna.
 *
 * lavagna is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * lavagna is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with lavagna.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.lavagna.web.security.login.oauth;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.OAuthConfig;
import org.scribe.oauth.OAuth20ServiceImpl;
import org.scribe.oauth.OAuthService;

import static io.lavagna.web.security.login.oauth.Utils.encode;

class Github20Api extends DefaultApi20 {

	@Override
	public String getAccessTokenEndpoint() {
		return "https://github.com/login/oauth/access_token";
	}

	@Override
	public String getAuthorizationUrl(OAuthConfig config) {
		return "https://github.com/login/oauth/authorize?client_id=" + encode(config.getApiKey()) + "&redirect_uri="
				+ encode(config.getCallback());
	}

    @Override
    public OAuthService createService(OAuthConfig config) {
        return new OAuth2ServiceImplCustomSignRequest(this, config);
    }
}
