package com.base.security.audit;

/**
 * IKeycloakUserInfo.
 *
 * @author vsangucho on 2022/12/15
 * @version 1.0
 */
public interface IKeycloakUserInfo {

    String getUserId();

    String getUserName();

    String getIp();

}
