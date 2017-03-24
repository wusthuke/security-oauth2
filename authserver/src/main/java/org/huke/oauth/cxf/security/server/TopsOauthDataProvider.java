package org.huke.oauth.cxf.security.server;

import org.apache.cxf.rs.security.oauth2.common.Client;
import org.apache.cxf.rs.security.oauth2.common.ServerAccessToken;
import org.apache.cxf.rs.security.oauth2.common.UserSubject;
import org.apache.cxf.rs.security.oauth2.provider.AbstractOAuthDataProvider;
import org.apache.cxf.rs.security.oauth2.provider.OAuthServiceException;
import org.apache.cxf.rs.security.oauth2.tokens.refresh.RefreshToken;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 销冠Oauth数据 provider
 * 1. Authenticate 认证
 * 2. Authorization 授权
 * 3. accessToken
 * 4. ThirdParty register 三方应用注册
 *
 * @author huke
 * @create 2017/3/21
 */
public class TopsOauthDataProvider extends AbstractOAuthDataProvider {

    private final Map<String, ServerAccessToken> accessTokenCache;
    private final Map<String, RefreshToken> refreshTokenCache;
    private final Map<String, Client> clientCache;      //client app cache

    public TopsOauthDataProvider() {
        this.accessTokenCache = new ConcurrentHashMap<>();
        this.refreshTokenCache = new ConcurrentHashMap<>();
        this.clientCache = new ConcurrentHashMap<>();
    }

    @Override
    protected void doRemoveClient(Client c) {
        this.clientCache.remove(c.getClientId());
    }

    @Override
    public void setClient(Client client) {
        this.clientCache.put(client.getClientId(), client);
    }

    @Override
    public List<Client> getClients(UserSubject resourceOwner) {
        return null;
    }

    @Override
    public Client getClient(String clientId) {
        return this.clientCache.get(clientId);
    }

    @Override
    protected void saveAccessToken(ServerAccessToken serverToken) {
        this.accessTokenCache.put(serverToken.getTokenKey(), serverToken);
    }

    @Override
    protected void saveRefreshToken(RefreshToken refreshToken) {
        this.refreshTokenCache.put(refreshToken.getTokenKey(), refreshToken);
    }

    @Override
    protected void doRevokeAccessToken(ServerAccessToken accessToken) {

    }

    @Override
    protected void doRevokeRefreshToken(RefreshToken refreshToken) {

    }

    @Override
    protected RefreshToken getRefreshToken(String refreshTokenKey) {
        return this.refreshTokenCache.get(refreshTokenKey);
    }

    @Override
    public ServerAccessToken getAccessToken(String accessToken) throws OAuthServiceException {
        return this.accessTokenCache.get(accessToken);
    }

    @Override
    public List<ServerAccessToken> getAccessTokens(Client client, UserSubject subject) throws OAuthServiceException {
        return null;
    }

    @Override
    public List<RefreshToken> getRefreshTokens(Client client, UserSubject subject) throws OAuthServiceException {
        return null;
    }
}
